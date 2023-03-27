package com.application.cms.DBTables.Authorities;

import com.application.cms.Student.StudentTable;
import com.application.cms.Teacher.TeacherModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Authorities")
public class Authorities {
    @Id
    @GeneratedValue
    @Column(name = "authority_id")
    Long id;
    String name;

    @ManyToMany(mappedBy = "student_authorities")
    List<StudentTable> students = new ArrayList<>();
    @ManyToMany(mappedBy = "teacher_authorities")
    List<TeacherModel> teachers = new ArrayList<>();
}
