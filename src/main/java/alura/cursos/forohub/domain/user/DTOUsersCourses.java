package alura.cursos.forohub.domain.user;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DTOUsersCourses(
        @NotNull
        Long user_id,
        @NotNull
        Long course_id
) {
}
