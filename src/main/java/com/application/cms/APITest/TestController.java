package com.application.cms.APITest;

import com.application.cms.User.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    ObjectMapper mapper;

    @PostMapping("/json")
    private ResponseEntity<?> testMapper(@RequestBody String json) {
        try {
            System.out.println(json);
            UserModel user = mapper.readValue(json, UserModel.class);
            System.out.println(user);
            return ResponseEntity.ok("User Saved!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
