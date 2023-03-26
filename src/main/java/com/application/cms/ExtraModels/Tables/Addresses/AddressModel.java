package com.application.cms.ExtraModels.Tables.Addresses;

import com.application.cms.Student.StudentModel;
import com.application.cms.Teacher.TeacherModel;
import com.application.cms.User.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "address")
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long address_id;
    String zipCode;
    String city;
    String state;
    @Builder.Default
    @ManyToMany
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "address_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    List<UserModel> users = new ArrayList<>();

}
