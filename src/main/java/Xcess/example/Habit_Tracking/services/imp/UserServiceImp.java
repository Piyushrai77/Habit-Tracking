package Xcess.example.Habit_Tracking.services.imp;

import Xcess.example.Habit_Tracking.entity.User;
import Xcess.example.Habit_Tracking.repo.UserRepository;
import Xcess.example.Habit_Tracking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;


/*   @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
*/

 @Override
 public User registerUser(User user) {
     if (userRepository.findByEmail(user.getEmail()).isPresent()) {
         throw new RuntimeException("Email is already registered!");
     }
     return userRepository.save(user);
 }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(existingUser);
    }
}
