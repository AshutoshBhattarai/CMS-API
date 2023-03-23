package com.application.cms.User.RequestHandler;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

    String username;
    String password;
    String email;
    Long phone;


}
