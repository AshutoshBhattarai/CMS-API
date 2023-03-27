package com.application.cms.User;

import com.application.cms.Student.StudentTable;
import com.application.cms.Student.StudentService;
import com.application.cms.Teacher.TeacherRepo;
import com.application.cms.User.RequestHandler.StudentSaveReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ObjectMapper mapper;
    private final StudentService studentService;
    private final TeacherRepo teacherRepo;
    private final UserRepo userRepo;

    public String saveUser(StudentSaveReq request) throws Exception {
        UserModel user = UserModel.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .password(request.getPassword())
                .email(request.getEmail())
                .role(request.getRole())
                .phone(request.getPhone())
                .build();
        StudentTable student = StudentTable.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .middlename(request.getMiddlename())
                .user(user)
                .address(request.getAddress())
                .dob(request.getDob())
                .build();
        studentService.saveStudent(student);
        return "Student created successfully";
    }

    public List<UserModel> getUsers() {
        return userRepo.findAll();
    }


}
