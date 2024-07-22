package com.main.bookmyshow.Dtos.RequestDtos;

import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class ShowEntryDto {

    private Integer screenno;
    private Time showStartTime;
    private Time showEndTime;
    private Date showDate;
    private Integer theaterId;
    private Integer movieId;
}
