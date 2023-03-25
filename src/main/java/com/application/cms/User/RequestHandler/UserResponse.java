package com.application.cms.User.RequestHandler;

import com.application.cms.ExtraModels.Models.Role;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserResponse {
    UUID id;
    String username;
    String password;
    String email;
    Long phone;
    Role role;
}
