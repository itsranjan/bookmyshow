package com.main.bookmyshow.Services;

import com.main.bookmyshow.Dtos.RequestDtos.MovieEntryDto;
import com.main.bookmyshow.Exceptions.MovieAlreadyPresentWithSameNameAndLanguage;
import com.main.bookmyshow.Exceptions.MovieDoesNotExists;
import com.main.bookmyshow.Models.Movie;
import com.main.bookmyshow.Models.Show;
import com.main.bookmyshow.Models.Ticket;
import com.main.bookmyshow.Repositories.MovieRepository;
import com.main.bookmyshow.Repositories.ShowRepository;
import com.main.bookmyshow.Transformers.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ShowRepository showRepository;

    public String addMovie(MovieEntryDto movieEntryDto) throws MovieAlreadyPresentWithSameNameAndLanguage {
        if(movieRepository.findByMovieName(movieEntryDto.getMovieName()) != null) {
            if(movieRepository.findByMovieName(movieEntryDto.getMovieName()).getLanguage().equals(movieEntryDto.getLanguage())){
                throw new MovieAlreadyPresentWithSameNameAndLanguage();
            }
        }
        Movie movie = MovieTransformer.movieDtoToMovie(movieEntryDto);
        movieRepository.save(movie);
        return "The movie has been added successfully";
    }

    public Long totalCollection(Integer movieId) throws MovieDoesNotExists {
        Optional<Movie> movieOpt = movieRepository.findById(movieId);
        if(movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }
        List<Show> showListOfMovie = showRepository.getAllShowsOfMovie(movieId);
        long ammount = 0;
        for(Show show : showListOfMovie) {
            for(Ticket ticket : show.getTicketList()) {
                ammount += (long)ticket.getTotalTicketsPrice();
            }
        }
        return ammount;
    }
}
