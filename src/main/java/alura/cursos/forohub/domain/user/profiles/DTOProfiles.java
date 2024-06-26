package alura.cursos.forohub.domain.user.profiles;

import jakarta.validation.constraints.NotNull;

public record DTOProfiles(
        @NotNull
        Long user_id,
        @NotNull
        Long profile_id
) {
}
