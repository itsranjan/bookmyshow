package com.main.bookmyshow.Transformers;


import com.main.bookmyshow.Dtos.RequestDtos.TheaterEntryDto;
import com.main.bookmyshow.Models.Theater;

public class TheaterTransformer {

    public static Theater theaterDtoToTheater(TheaterEntryDto entryDto) {
        Theater theater = Theater.builder()
                .name(entryDto.getName())
                .address(entryDto.getAddress())
                .noofscreen(entryDto.getNoofscreen())
                .build();
        return theater;
    }
}
