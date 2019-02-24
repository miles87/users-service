package pl.betse.beontime.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

//    @Query("SELECT room FROM Room room WHERE LOWER(room.name)=LOWER(:roomName)")
//    Room getRoomByName(@Param("roomName") String roomName);

    boolean existsByUserId(Integer userID);

    boolean existsByEmailLogin(String userEmail);

    @Query("SELECT user FROM User user where  lower(user.emailLogin)=lower(:userEmail)")
    User findByEmail(@Param("userEmail") String userEmail);
}
