package pl.betse.beontime.model.department;

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

    /*public UserDepartment(DepartmentEnum name) {
        this.name = name.name();
    }*/

    public UserDepartment(String name) {
        this.name = name;
    }

    private String name;





    /* DIGITAL,
    SALESFORCE,
    BANKING*/
}
