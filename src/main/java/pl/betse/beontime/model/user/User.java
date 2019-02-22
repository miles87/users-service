package pl.betse.beontime.model.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.betse.beontime.model.department.UserDepartment;
import pl.betse.beontime.model.role.UserRole;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
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
    private Set<UserRole> roles;


}

