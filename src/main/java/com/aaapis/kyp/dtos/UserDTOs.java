package com.aaapis.kyp.dtos;

import com.aaapis.kyp.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTOs {
//    private Long id;
    private String username;
    private String name;
    private String password;
    private UserRole userRole;

    public UserRole getUserRole() {
        return userRole;
    }
}
