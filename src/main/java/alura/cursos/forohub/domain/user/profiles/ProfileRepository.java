package alura.cursos.forohub.domain.user.profiles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<UProfile, Long> {
}
