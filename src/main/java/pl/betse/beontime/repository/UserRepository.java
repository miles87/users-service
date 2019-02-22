package pl.betse.beontime.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.betse.beontime.model.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
