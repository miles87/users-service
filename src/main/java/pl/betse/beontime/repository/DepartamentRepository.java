package pl.betse.beontime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.entity.DepartmentEntity;


@Repository
public interface DepartamentRepository extends CrudRepository<DepartmentEntity, Integer> {

DepartmentEntity findByName(String departmentName);

}
