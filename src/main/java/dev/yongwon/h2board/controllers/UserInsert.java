package dev.yongwon.h2board.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserInsert {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/insertUserData")
    public ResponseEntity<String> insertUserData(@RequestParam("username") String username,
                                                 @RequestParam("email") String email) {
        try {
            jdbcTemplate.update("INSERT INTO users (username, email) VALUES (?, ?)", username, email);
            return ResponseEntity.ok("User data inserted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while inserting user data: " + e.getMessage());
        }
    }
    
    @PostMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestParam("user_id") String userId) {
        try {
            jdbcTemplate.update("DELETE FROM users WHERE user_id = ?", userId);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting user: " + e.getMessage());
        }
    }
    
  




}
