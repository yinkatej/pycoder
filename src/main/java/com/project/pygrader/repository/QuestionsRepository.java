package com.project.pygrader.repository;

import com.project.pygrader.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface QuestionsRepository extends MongoRepository<Question, String> {

    List<Question> findQuestionsByTopic(String topic);
    Optional<Question> findByTitle(String title);
    Optional<Question> findByUnique(int id);
}
