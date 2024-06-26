package alura.cursos.forohub.domain.course;

import jakarta.validation.Valid;

public record DTOCourse(
        String course_name,
        CourseCategory category
) {
}
