package pl.betse.beontime.model.user;


import lombok.*;
import pl.betse.beontime.model.department.UserDepartment;
import pl.betse.beontime.model.role.UserRole;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID")
    private String userEmail;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String salt;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DEPARTMENT_ID")
    private UserDepartment userDepartment;

    @ManyToMany
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<UserRole> roles;


}

