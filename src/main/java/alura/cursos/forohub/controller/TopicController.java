package alura.cursos.forohub.controller;

import alura.cursos.forohub.domain.answer.Answer;
import alura.cursos.forohub.domain.answer.AnswerRepository;
import alura.cursos.forohub.domain.answer.DTOAnswer;
import alura.cursos.forohub.domain.topic.DTOGetTopics;
import alura.cursos.forohub.domain.topic.DTOTopic;
import alura.cursos.forohub.domain.topic.Topic;
import alura.cursos.forohub.domain.topic.TopicRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity<Page<DTOGetTopics>> listTopics(@PageableDefault(size = 10) Pageable pagination) {
        return ResponseEntity.ok(topicRepository.findAll(pagination).map(DTOGetTopics::new));
    }
}
