package pl.betse.beontime.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String emailLogin;

    private String firstName;

    private String lastName;


    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @JsonProperty
    private boolean isActive;

    @ManyToOne(optional = false)
    @JoinColumn(name = "DEPARTMENT_ID")
    @JsonIgnore
    private UserDepartment userDepartment;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<UserRole> roles;

    public User(String emailLogin, String firstName, String lastName, String password, boolean isActive, UserDepartment userDepartment, Set<UserRole> roles) {
        this.emailLogin = emailLogin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.isActive = isActive;
        this.userDepartment = userDepartment;
        this.roles = roles;
    }

}

