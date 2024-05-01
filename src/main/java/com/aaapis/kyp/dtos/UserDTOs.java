package com.aaapis.kyp.dtos;

import com.aaapis.kyp.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTOs {
    private Long id;
    private String name;
    private String password;

    private Enum<UserRole> userRole;
}
