package com.application.cms.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public List<StudentTable> getStudents(){
        //System.out.println(studentRepo.findAll());
        return studentRepo.findAll();
    }

    public StudentTable saveStudent(StudentTable student){
        return studentRepo.save(student);
    }
}
