package Xcess.example.Habit_Tracking.services;


import Xcess.example.Habit_Tracking.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
/*    User registerUser(User user);
    Optional<User> findUserByEmail(String email);

 */

    User registerUser(User user);
    Optional<User> findUserByEmail(String email);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
