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
        } else { // if answerUuid is not null ( This mean this is a reply )
            // get the parent answer
            parentAnswer = answerRepository.findByUuidAndIsDeleted(createAnswerRequest.answerUuid(), false);

            // map the request to answer
            Answer answer = answerMapper.fromCreateAnswerRequest(createAnswerRequest);
            answer.setUuid(UUID.randomUUID().toString());
            answer.setQuestion(question);
            answer.setReplies(List.of());

            // get the replies of the parent answer
            List<Answer> answerList = parentAnswer.getReplies();

            // add the new reply to the list
            answerList.add(answer);
            // set the replies to the parent answer
            parentAnswer.setReplies(answerList);

        }
        answerRepository.save(parentAnswer);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Answer or Reply created successfully")
                .build();
    }

    @Override
    public ParentAnswerResponse findAnswerByUuid(String answerUuid) {

        Answer answer = answerRepository.findByUuid(answerUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Answer not found"
                ));

        return answerMapper.toParentAnswerResponse(answer);
    }
}
