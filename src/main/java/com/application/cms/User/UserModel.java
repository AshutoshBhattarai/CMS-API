package com.application.cms.User;

import com.application.cms.ExtraModels.Models.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue
    UUID user_id;
    @Column(unique = true,nullable = false)
    String username;
    @Column(unique = true,nullable = false)
    String password;
    @Column(unique = true,nullable = false)
    String email;
    @Column(name = "phone_number",unique = true,nullable = false)
    Long phone;
    @Enumerated(EnumType.STRING)
    Role role = Role.STUDENT;



}
