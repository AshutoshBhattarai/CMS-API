package com.application.cms.User;

import com.application.cms.User.RequestHandler.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    private String displayHome() {
        return "Welcome to user home";
    }

    @GetMapping("/all")
    private List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/save")
    private ResponseEntity<?> saveUser(@RequestBody String user) {
        try {
            userService.saveUser(user);
            return ResponseEntity.ok("User saved Successfully");
        } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/save/student")
    private ResponseEntity<?> saveStudent(@RequestBody String user) {
        try {
            String msg = userService.saveUser(user);
            return ResponseEntity.ok(msg);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
