package com.main.bookmyshow.Dtos.RequestDtos;

import com.main.bookmyshow.Enums.Gender;
import lombok.Data;

@Data
public class UserEntryDto {

    private String name;
    private Integer age;
    private String address;
    private String mobileNo;
    private String emailId;
    private Gender gender;
}
