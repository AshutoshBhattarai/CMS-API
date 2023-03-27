package com.application.cms.User;

import com.application.cms.ExtraModels.ApiResponse;
import com.application.cms.User.RequestHandler.StudentSaveReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
            //userService.saveUser(user);
            return okResponse("User saved Successfully");
        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }

    }

    @PostMapping("/save/student")
    private ResponseEntity<?> saveStudent(@RequestBody StudentSaveReq request) {
        try {
            String msg = userService.saveUser(request);
            return okResponse(msg);
        } catch (Exception e) {
            return errorResponse(e.getMessage());
        }

    }

    private ResponseEntity<?> okResponse(String message) {
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .code(200)
                .message(message)
                .build();
        return ResponseEntity.ok(response);
    }

    private ResponseEntity<?> errorResponse(String message) {
        ApiResponse response = ApiResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .code(400)
                .message(message)
                .build();
        return ResponseEntity.badRequest().body(response);
    }

}
