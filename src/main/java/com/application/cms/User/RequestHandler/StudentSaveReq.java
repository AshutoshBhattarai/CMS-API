package com.application.cms.User.RequestHandler;

import com.application.cms.ExtraModels.Role;
import com.application.cms.DBTables.Addresses.AddressModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StudentSaveReq {
    String username;
    String password;
    String email;
    Long phone;
    Role role;
    String firstname;
    String lastname;
    String middlename;
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
    List<AddressModel> address;
}
