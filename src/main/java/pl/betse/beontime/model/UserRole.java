package pl.betse.beontime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pl.betse.beontime.model.enums.RoleEnum;
import pl.betse.beontime.model.User;

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

    @Column(nullable = false, unique = true)
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
