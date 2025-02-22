package Xcess.example.Habit_Tracking.controller;

import Xcess.example.Habit_Tracking.entity.User;
import Xcess.example.Habit_Tracking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

   @PostMapping("/register")
    public User registerUser(@RequestBody User user){
    System.out.println("Register User Endpoint Hit with Data: " + user);
        return userService.registerUser(user);

    }
/*
    @GetMapping("/email/{email}")
    public User FindUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email).orElse(null);
    }
*/

 @GetMapping
 public ResponseEntity<List<User>> getAllUsers() {
     List<User> users = userService.getAllUsers();
     return ResponseEntity.ok(users);
 }

    // Get a user by email
    @GetMapping("/email/{email}")
    public User findUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get a user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> ResponseEntity.ok().body((Object) user)) // Ensure a valid ResponseEntity is created
                .orElseGet(() -> ResponseEntity.status(404).body("User not found")); // Provide a valid String for the body
    }

    // Update user details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(id, user);
            return ResponseEntity.ok(updatedUser);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    // Delete a user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.status(200).body("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}


