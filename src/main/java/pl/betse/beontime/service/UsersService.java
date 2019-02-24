package pl.betse.beontime.service;

import pl.betse.beontime.model.User;

import java.util.List;

public interface UsersService {

    List<User> findAll();

    User findById(Integer userId);

    boolean existsByUserId(Integer userId);

    boolean existsByEmailLogin(String userEmail);


    User getUserByEmail(String userEmail);

    void save(User user);
}
