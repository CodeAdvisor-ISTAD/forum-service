package com.example.forumcodeadvisors.feature.answer.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Answer;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.feature.answer.dto.ParentAnswerResponse;
import com.example.forumcodeadvisors.feature.answer.dto.CreateAnswerRequest;
import com.example.forumcodeadvisors.feature.answer.mapper.AnswerMapper;
import com.example.forumcodeadvisors.feature.answer.repository.AnswerRepository;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerMapper answerMapper;


    /**
     * Create an answer or reply
     *
     * @param createAnswerRequest
     * @return BaseResponse<?>
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> createAnswer(CreateAnswerRequest createAnswerRequest) {

        Question question = questionRepository.findByUuid(createAnswerRequest.questionUuid())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Question not found"
                ));


        Answer parentAnswer;

        // check if answerUuid is null ( This mean this is the first answer )
        if (createAnswerRequest.answerUuid() == null) {
            parentAnswer = answerMapper.fromCreateAnswerRequest(createAnswerRequest);
            parentAnswer.setUuid(UUID.randomUUID().toString());
            parentAnswer.setQuestion(question);
            parentAnswer.setReplies(List.of());
            parentAnswer.setIsParent(true);
            answerRepository.save(parentAnswer);

        } else { // if answerUuid is not null ( This mean this is a reply )
            // get the parent answer
            parentAnswer = answerRepository.findByUuidAndIsDeleted(createAnswerRequest.answerUuid(), false)
                    .orElseThrow(()-> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Parent answer not found"
                    ));

            // map the request to answer
            Answer answer = answerMapper.fromCreateAnswerRequest(createAnswerRequest);
            answer.setUuid(UUID.randomUUID().toString());
            answer.setQuestion(question);
            answer.setIsParent(false);
            answer.setReplies(List.of());

            // get the replies of the parent answer
            List<Answer> answerList = parentAnswer.getReplies();

            // add the new reply to the list
            answerList.add(answer);
            // set the replies to the parent answer
            parentAnswer.setReplies(answerList);
            answerRepository.save(parentAnswer);

        }

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Answer or Reply created successfully")
                .build();
    }


    /**
     * Find answer by UUID
     *
     * @param answerUuid
     * @return ParentAnswerResponse
     * by Yith Sopheaktra
     */
    @Override
    public ParentAnswerResponse findAnswerByUuid(String answerUuid) {

        Answer answer = answerRepository.findByUuid(answerUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        return answerMapper.toParentAnswerResponse(answer);
    }


    /**
     * Find all answers
     *
     * @return List<ParentAnswerResponse>
     * by Yith Sopheaktra
     */
    @Override
    public List<ParentAnswerResponse> findAllQuestionByQuestionUuid(String questionUuid) {

        List<Answer> answers = answerRepository.findAllByQuestionAndIsParentAndIsDeleted(
                questionRepository.findByUuid(questionUuid).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Question not found"
                )),
                true,
                false
        );
        return answerMapper.toAnswerResponseList(answers);
    }


    /**
     * Delete an answer
     *
     * @param answerUuid
     * @param authorUuid
     * @return BaseResponse<?>
     * by Yith Sopheaktra
     * @problem The author of the question should be able to delete the answer of the question and also the author of the answer should be able to delete the answer
     */
    @Override
    public BaseResponse<?> deleteAnswer(String answerUuid, String authorUuid) {

        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

//        if(!answer.getAuthorUuid().equals(authorUuid)){
//            if(!answer.getQuestion().getAuthorUuid().equals(authorUuid)){
//                throw new ResponseStatusException(
//                        HttpStatus.FORBIDDEN,
//                        "You are not allowed to delete this answer"
//                );
//            }
//        }

        answer.setIsDeleted(true);
        answerRepository.save(answer);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Answer deleted successfully")
                .build();
    }

    /**
     * Accept an answer
     *
     * @param answerUuid
     * @param authorUuid
     * @return BaseResponse<?>
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> acceptAnswer(String answerUuid, String authorUuid) {

        Answer answer = answerRepository.findByUuidAndIsDeleted(answerUuid, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        Question question = answer.getQuestion();

        // check if the author of the question is the same as the author of the answer
        if(!question.getAuthorUuid().equals(authorUuid)){
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "You are not allowed to accept this answer"
            );
        }

        // check if the answer is already accepted
        if(answer.getIsAccepted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Answer is already accepted"
            );
        }

        answer.setIsAccepted(true);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Answer accepted successfully")
                .build();
    }
}
