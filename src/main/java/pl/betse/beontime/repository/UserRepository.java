package pl.betse.beontime.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.entity.DepartmentEntity;
import pl.betse.beontime.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {



    boolean existsByUserId(Integer userID);

    boolean existsByEmailLogin(String userEmail);


    @Query("SELECT user FROM UserEntity user where  lower(user.emailLogin)=lower(:userEmail)")
    UserEntity findByEmail(@Param("userEmail") String userEmail);

    List<UserEntity> findByDepartmentEntity(DepartmentEntity departmentEntity);
}
