package alura.cursos.forohub.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DTOTopic(
        @NotBlank
        @Size(min = 0, max = 100)
        String title,
        @NotBlank
        @Size(min = 0, max = 2000)
        String message,
        Tag tag,
        @NotNull
        Long user_id,
        @NotNull
        Long course_id
) {
}
