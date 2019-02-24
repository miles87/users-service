package pl.betse.beontime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.model.UserDepartment;


@Repository
public interface DepartamentRepository extends CrudRepository<UserDepartment, Integer> {

UserDepartment findByName(String departmentName);

}
