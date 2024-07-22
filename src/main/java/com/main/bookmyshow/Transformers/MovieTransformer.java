package com.main.bookmyshow.Transformers;

import com.main.bookmyshow.Dtos.RequestDtos.MovieEntryDto;
import com.main.bookmyshow.Models.Movie;

public class MovieTransformer {

    public static Movie movieDtoToMovie(MovieEntryDto movieEntryDto) {
        Movie movie = Movie.builder()
                .movieName(movieEntryDto.getMovieName())
                .duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre())
                .language(movieEntryDto.getLanguage())
                .releaseDate(movieEntryDto.getReleaseDate())
                .rating(movieEntryDto.getRating())
                .build();

        return movie;
    }
}
