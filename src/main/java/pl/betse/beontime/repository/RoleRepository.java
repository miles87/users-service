package pl.betse.beontime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.entity.RoleEntity;


@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {


    RoleEntity findByRole(String roleName);

}
