package application.service;

import application.model.User;
import application.repository.UserRepository;
import application.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getByUserId(Long id) {
        return userRepository.findById(id);
    }

    public User addUser(User user) {
        String urlAvatar = "https://robohash.org/" + user.getUserId();
        user.setUserId(new UUIDGenerator().generateUserID(userRepository));
        user.setAvatar(urlAvatar);
        return userRepository.save(user);
    }

    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }
}
