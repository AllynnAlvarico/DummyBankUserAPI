package application.util;

import application.model.User;
import application.repository.UserRepository;
import application.service.UserService;

import java.util.*;

public class UUIDGenerator {

    public String generateUserID(UserRepository userRepository) {
        List<User> listOfUsers = userRepository.findAll();
        Set<String> existingUserIds = new HashSet<>(); /** using HashSet makes checking for duplicates much faster */
        for (User user : listOfUsers) {
            existingUserIds.add(user.getUserId());
        }

        String newUserId;
        do {
            newUserId = UUID.randomUUID().toString();
        } while (existingUserIds.contains(newUserId));

        return newUserId;
    }


}
