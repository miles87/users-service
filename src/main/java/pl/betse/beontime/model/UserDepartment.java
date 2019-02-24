package pl.betse.beontime.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.betse.beontime.model.enums.DepartmentEnum;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPARTMENTS")
public class UserDepartment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private int id;

     public UserDepartment(DepartmentEnum name) {
        this.name = name.name();
    }


    @Column(nullable = false,unique = true)
    private String name;





    /* DIGITAL,
    SALESFORCE,
    BANKING*/
}