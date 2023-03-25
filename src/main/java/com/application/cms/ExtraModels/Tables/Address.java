package com.application.cms.ExtraModels.Tables;

import com.application.cms.Student.StudentModel;
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
public class Address {

    @Id
    @GeneratedValue
    Long address_id;
    String zipCode;
    String city;
    String state;
    @ManyToMany(mappedBy = "student_address")
    List<StudentModel> students = new ArrayList<>();

}
