package pl.betse.beontime.model.role;

import lombok.*;
import pl.betse.beontime.model.enums.RoleEnum;
import pl.betse.beontime.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private int id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public UserRole(RoleEnum roleEnum) {
        this.role = roleEnum.name();
    }






    /*ADMINISTRATION,
    CONSULTANT,
    MANAGER*/
}
