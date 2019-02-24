package pl.betse.beontime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.model.UserRole;


@Repository
public interface RoleRepository extends CrudRepository<UserRole, Integer> {


    UserRole findByRole(String roleName);

}
