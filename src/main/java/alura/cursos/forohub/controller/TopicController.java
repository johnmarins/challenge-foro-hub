package alura.cursos.forohub.controller;

import alura.cursos.forohub.domain.answer.Answer;
import alura.cursos.forohub.domain.answer.AnswerRepository;
import alura.cursos.forohub.domain.answer.DTOAnswer;
import alura.cursos.forohub.domain.topic.DTOTopic;
import alura.cursos.forohub.domain.topic.Topic;
import alura.cursos.forohub.domain.topic.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @PostMapping
    @Transactional
    public void createTopic(@RequestBody @Valid DTOTopic dtoTopic){
        topicRepository.save(new Topic(dtoTopic));
    }

    @PostMapping("/answers")
    @Transactional
    public void createAnswer(@RequestBody @Valid DTOAnswer dtoAnswer){
        answerRepository.save(new Answer(dtoAnswer));
    }
}
