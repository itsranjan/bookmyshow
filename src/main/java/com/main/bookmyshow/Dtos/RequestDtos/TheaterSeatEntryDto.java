package com.main.bookmyshow.Dtos.RequestDtos;

import lombok.Data;

@Data
public class TheaterSeatEntryDto {
    private String address;
    private Integer screenno;
    private Integer noOfSeatInRow;
    private Integer noOfPremiumSeat;
    private Integer noOfClassicSeat;
}
