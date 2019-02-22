package pl.betse.beontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betse.beontime.model.user.User;
import pl.betse.beontime.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(userList::add);
        return userList;
    }

    @Override
    public User getUser(String userEmail) {
        return userRepository.findById(userEmail).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
