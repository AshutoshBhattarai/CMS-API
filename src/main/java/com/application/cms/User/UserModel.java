package com.application.cms.User;

import com.application.cms.ExtraModels.Models.Role;
import com.application.cms.ExtraModels.Tables.Addresses.AddressModel;
import com.application.cms.Student.StudentModel;
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
    @Column(unique = true,nullable = false)
    String username;
    @Column(nullable = false)
    String password;
    @Column(unique = true,nullable = false)
    String email;
    @Column(name = "phone_number",unique = true,nullable = false)
    Long phone;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    Role role = Role.STUDENT;

    @OneToMany(mappedBy = "user")
    private Set<StudentModel> students ;
    @OneToMany(mappedBy = "user")
    private Set<TeacherModel> teachers ;
    @ManyToMany(mappedBy = "users")
    private Set<AddressModel> address ;



}
