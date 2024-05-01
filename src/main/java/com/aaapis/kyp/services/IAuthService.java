package com.aaapis.kyp.services;

import com.aaapis.kyp.dtos.UserDTOs;
import com.aaapis.kyp.models.User;

public interface IAuthService {
    User userLogin(String email, String password);
    User userRegister(UserDTOs user);

    User userLogout(User user);
}
