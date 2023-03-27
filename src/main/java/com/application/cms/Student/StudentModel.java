package com.application.cms.Student;

import com.application.cms.DBTables.Addresses.AddressModel;
import com.application.cms.DBTables.Authorities.Authorities;
import com.application.cms.User.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class StudentModel {
    UUID studentId;
    String firstname;
    String lastname;
    String middlename;
    LocalDate dob;
    LocalDateTime createAt;
    LocalDateTime updateAt;
    UserModel user;
    List<AddressModel> address;
    List<Authorities> authorities;
    int age;


}
