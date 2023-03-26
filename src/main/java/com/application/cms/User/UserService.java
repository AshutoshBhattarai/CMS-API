package com.application.cms.User;

import com.application.cms.ExtraModels.Tables.Addresses.AddressRepo;
import com.application.cms.Student.StudentModel;
import com.application.cms.Student.StudentRepo;
import com.application.cms.Teacher.TeacherRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ObjectMapper mapper;
    private final StudentRepo studentRepo;
    private final TeacherRepo teacherRepo;
    private final AddressRepo addressRepo;
    private final UserRepo userRepo;
    public String saveUser(String request) throws Exception
    {
        UserModel user = mapper.readValue(request, UserModel.class);
        userRepo.save(user);
        StudentModel student = mapper.readValue(request, StudentModel.class);

        StudentModel saveStudent = StudentModel.builder()
                .firstname(student.getFirstname())
                .lastname(student.getLastname())
                .middlename(student.getMiddlename())
                .dob(student.getDob())
                .address(student.getAddress())
                .user(user)
                .build();
        studentRepo.save(saveStudent);
        return "Student created successfully";
    }
    public List<UserModel> getUsers()
    {
        return userRepo.findAll();
    }


}
