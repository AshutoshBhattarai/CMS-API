package com.application.cms.Teacher;

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
@Table(name = "Teachers")
public class TeacherModel {
    @Id
    @GeneratedValue
    @Column(name = "teacher_id")
    UUID teacherId;
    String firstname;
    String lastname;
    String middlename;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDateTime dob;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_addresses",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> teacher_address = new ArrayList<>();
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Address> teacher_authorities = new ArrayList<>();
    @Transient
    int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel user;
}
