package pl.betse.beontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.betse.beontime.model.User;
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
    public User findById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public boolean existsByUserId(Integer userId) {
        return userRepository.existsByUserId(userId);
    }

    @Override
    public boolean existsByEmailLogin(String userEmail) {
        return userRepository.existsByEmailLogin(userEmail);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
