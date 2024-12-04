package com.example.forumcodeadvisors.feature.question.service;

import com.example.forumcodeadvisors.base.BaseResponse;
import com.example.forumcodeadvisors.domain.Question;
import com.example.forumcodeadvisors.domain.Tag;
import com.example.forumcodeadvisors.feature.question.dto.CreateQuestionRequest;
import com.example.forumcodeadvisors.feature.question.dto.QuestionResponse;
import com.example.forumcodeadvisors.feature.question.mapper.QuestionMapper;
import com.example.forumcodeadvisors.feature.question.repository.QuestionRepository;
import com.example.forumcodeadvisors.feature.tag.repository.TagRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


@Service
@RequiredArgsConstructor
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionRepository questionRepository;
    private final TagRepository tagRepository;


    /**
     * Create forum content
     *
     * @param createQuestionRequest
     * @return void
     * by Yith Sopheaktra
     */
    @Transactional
    @Override
    public BaseResponse<?> createQuestion(CreateQuestionRequest createQuestionRequest) {

        // check if user is null
        if (createQuestionRequest.authorUuid() == null) {
            throw new ResponseStatusException(
                    BAD_REQUEST,
                    "Author UUID is required"
            );
        }

        // find tags by tag id
        List<Tag> existingTags = tagRepository.findAllById(createQuestionRequest.tagIds());

        // map request to question object
        Question question = questionMapper.fromCreateQuestionRequest(createQuestionRequest);

        // set tags to question
        question.setTags(existingTags);

        // set UUID to question
        question.setUuid(UUID.randomUUID().toString());

        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.CREATED.value())
                .message("Question created successfully")
                .build();

    }


    /**
     * Publish question
     *
     * @param questionUuid
     * @return void
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> publishQuestion(String questionUuid) {

        // find question by UUID
        Question question = questionRepository.findByUuid(questionUuid)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));

        // check if question is archived
        if(question.getIsArchived()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question is archived");
        }

        // check if question is deleted
        if(question.getIsDeleted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question not found");
        }

        // check if question is already published
        if(!question.getIsDrafted()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Question is already published");
        }

        question.setIsDrafted(false);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question published successfully")
                .build();
    }


    /**
     * Delete question
     *
     * @param questionUuid
     * @return void
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> deleteQuestion(String questionUuid) {

        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid,false,false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));
        question.setIsDeleted(true);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question deleted successfully")
                .build();
    }



    /**
     * Archive question
     *
     * @param questionUuid
     * @return void
     * by Yith Sopheaktra
     */
    @Override
    public BaseResponse<?> archiveQuestion(String questionUuid) {

        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid,false,false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));
        question.setIsArchived(true);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question archived successfully")
                .build();
    }

    @Override
    public BaseResponse<?> unarchiveQuestion(String questionUuid) {

        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid,true,false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));
        question.setIsArchived(false);
        questionRepository.save(question);

        return BaseResponse.builder()
                .code(HttpStatus.NO_CONTENT.value())
                .message("Question unarchived successfully")
                .build();
    }


    /**
     * Find all questions
     *
     * @return List<QuestionResponse>
     * by Yith Sopheaktra
     */
    @Override
    public List<QuestionResponse> findAllQuestions() {

        List<Question> questions = questionRepository.findAllByIsArchivedAndIsDeletedAndIsDrafted(false, false, false);

        return questionMapper.toQuestionResponse(questions);
    }


    /**
     * Find question by UUID
     *
     * @param questionUuid
     * @return QuestionResponse
     * by Yith Sopheaktra
     */
    @Override
    public QuestionResponse findQuestionByUuid(String questionUuid) {
        Question question = questionRepository.findByUuidAndIsArchivedAndIsDeletedAndIsDrafted(questionUuid, false, false, false)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Question not found"));

        return questionMapper.toQuestionResponse(question);
    }
}
