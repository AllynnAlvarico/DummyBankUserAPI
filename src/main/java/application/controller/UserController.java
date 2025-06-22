package application.controller;

import application.model.User;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/{userid}")
//    public Optional<User> getUserId(Long id){
//        return userService.getByUserId(id);
//    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
