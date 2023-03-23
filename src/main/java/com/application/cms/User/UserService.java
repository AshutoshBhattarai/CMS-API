package com.application.cms.User;

import com.application.cms.User.RequestHandler.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    public UserModel saveUser(UserRequest request)
    {
        return null;
        //return userRepo.save()
    }
}
