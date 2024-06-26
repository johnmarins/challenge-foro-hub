package alura.cursos.forohub.controller;

import alura.cursos.forohub.domain.course.Course;
import alura.cursos.forohub.domain.course.CourseRepository;
import alura.cursos.forohub.domain.course.DTOCourse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    @Transactional
    public void createCourse(@RequestBody @Valid DTOCourse dtoCourse){
        courseRepository.save(new Course(dtoCourse));
    }
}
