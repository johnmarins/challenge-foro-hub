package alura.cursos.forohub.domain.user;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;

    public User(DTOUser dtoUser){
        this.first_name = dtoUser.first_name();
        this.last_name = dtoUser.last_name();
        this.username = dtoUser.username();
        this.email = dtoUser.email();
        this.password = dtoUser.password();
    }
}
