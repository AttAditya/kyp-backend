package com.aaapis.kyp.services.authServiceIMPL;

import com.aaapis.kyp.models.User;
import com.aaapis.kyp.services.IAuthService;
import org.springframework.stereotype.Service;

@Service("V1AuthService")
public class AuthService implements IAuthService {
    @Override
    public User userLogin(String email, String password) {
        return null;
    }

    @Override
    public User userRegister(User user) {
        return null;
    }

    @Override
    public User userLogout(User user) {
        return null;
    }
}
