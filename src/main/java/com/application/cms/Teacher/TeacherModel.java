package com.application.cms.Teacher;

import com.application.cms.ExtraModels.Tables.Addresses.AddressModel;
import com.application.cms.ExtraModels.Tables.Authorities.Authorities;
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
    @Builder.Default
    LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    LocalDateTime updatedAt = LocalDateTime.now();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel user;
    @Builder.Default
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
    private List<Authorities> teacher_authorities = new ArrayList<>();
    @Transient
    int age;


}
