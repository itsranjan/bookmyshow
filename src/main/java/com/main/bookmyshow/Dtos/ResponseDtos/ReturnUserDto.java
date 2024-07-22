package com.main.bookmyshow.Dtos.ResponseDtos;

import com.main.bookmyshow.Enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnUserDto {

    private String name;
    private Integer age;
    private Gender gender;
    private String address;
}
