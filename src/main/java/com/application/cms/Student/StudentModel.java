package com.application.cms.Student;


import com.application.cms.ExtraModels.Tables.Address;
import com.application.cms.User.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Students")
public class StudentModel {
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    UUID studentId;
    String firstname;
    String lastname;
    String middlename;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime dob;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_addresses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))

    private List<Address> student_address = new ArrayList<>();
    @Transient
    int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel user;


}
