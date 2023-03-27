package com.application.cms.User;

import com.application.cms.ExtraModels.Role;
import com.application.cms.Student.StudentTable;
import com.application.cms.Teacher.TeacherModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
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
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(unique = true, nullable = false)
    String email;
    @Column(name = "phone_number", unique = true, nullable = false)
    Long phone;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<StudentTable> students;
    @OneToMany(mappedBy = "user")
    @ToString.Exclude
    private Set<TeacherModel> teachers;


}
