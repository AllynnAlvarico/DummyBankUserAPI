package application.service;

import application.model.User;
import application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

//    public Optional<User> getByUserId(Long id) {
//        return userRepository.findById(id);
//    }
    public User addUser(User user) {
        return userRepository.save(user);

    }
}
