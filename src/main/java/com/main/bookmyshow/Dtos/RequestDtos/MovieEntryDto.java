package com.main.bookmyshow.Dtos.RequestDtos;

import com.main.bookmyshow.Enums.Genre;
import com.main.bookmyshow.Enums.Language;
import lombok.Data;

import java.sql.Date;

@Data
public class MovieEntryDto {
    private String movieName;
    private Integer duration;
    private Double rating;
    private Date releaseDate;
    private Genre genre;
    private Language language;
}
