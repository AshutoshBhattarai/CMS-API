package com.application.cms.Student;


import com.application.cms.ExtraModels.Tables.Addresses.AddressModel;
import com.application.cms.ExtraModels.Tables.Authorities.Authorities;
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

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
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
    LocalDate dob;
    @Builder.Default
    LocalDateTime createAt = LocalDateTime.now();
    @Builder.Default
    LocalDateTime updateAt = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel user;
    @Builder.Default
    @JsonProperty("address")
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_address",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))

    private List<AddressModel> address = new ArrayList<>();
    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authorities> student_authorities = new ArrayList<>();
    @Transient
    int age;




}
