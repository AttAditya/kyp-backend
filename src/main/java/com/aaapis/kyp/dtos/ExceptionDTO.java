package com.aaapis.kyp.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionDTO {
    private String message;
    private Date time;
}
