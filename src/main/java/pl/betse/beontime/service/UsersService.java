package pl.betse.beontime.service;

import pl.betse.beontime.model.user.User;

import java.util.List;

public interface UsersService {

    List<User> findAll();

    User getUser(String userEmail);

    void save(User user);
}
