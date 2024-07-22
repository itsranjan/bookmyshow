package com.main.bookmyshow.Services;

import com.main.bookmyshow.Dtos.RequestDtos.ShowEntryDto;
import com.main.bookmyshow.Dtos.RequestDtos.ShowSeatEntryDto;
import com.main.bookmyshow.Dtos.RequestDtos.ShowTimingsDto;
import com.main.bookmyshow.Enums.SeatType;
import com.main.bookmyshow.Exceptions.*;
import com.main.bookmyshow.Models.*;
import com.main.bookmyshow.Repositories.MovieRepository;
import com.main.bookmyshow.Repositories.ShowRepository;
import com.main.bookmyshow.Repositories.TheaterRepository;
import com.main.bookmyshow.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.*;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(ShowEntryDto showEntryDto) throws MovieDoesNotExists, TheaterDoesNotExists{
        Show show = ShowTransformer.showDtoToShow(showEntryDto);

        Optional<Movie> movieOpt = movieRepository.findById(showEntryDto.getMovieId());
        if(movieOpt.isEmpty()) {
            throw new MovieDoesNotExists();
        }
        Optional<Theater> theaterOpt = theaterRepository.findById(showEntryDto.getTheaterId());
        if(theaterOpt.isEmpty()) {
            throw new TheaterDoesNotExists();
        }

        Theater theater = theaterOpt.get();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();
        Set<Integer> screenset = new HashSet<>();

        for(TheaterSeat theaterSeat:theaterSeatList){
            screenset.add(theaterSeat.getScreenno());
        }
        if(!screenset.contains(showEntryDto.getScreenno())){
            throw new ScreenNotYetSet();
        }

        //boolean overlapping = false;
        //HashMap<Date,Integer> dateset = new HashMap();
        List<Show> showList = showRepository.getoverlappingdetails(showEntryDto.getShowDate(),showEntryDto.getScreenno());

        for(Show shows:showList){
            Time time_start = shows.getTime_start();
            Time time_end = shows.getTime_end();
            if(showEntryDto.getShowStartTime().after(time_start) && showEntryDto.getShowStartTime().before(time_end)){
                throw new ShowAlreadyPresentAtTheGivenTime();
            }
        }

        Movie movie = movieOpt.get();
        show.setScreenno(showEntryDto.getScreenno());
        show.setMovie(movie);
        show.setTheater(theater);
        show = showRepository.save(show);

        movie.getShows().add(show);
        theater.getShowList().add(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);

        return "Show has been added Successfully";
    }

    public String associateShowSeats(ShowSeatEntryDto showSeatEntryDto) throws ShowDoesNotExists{
        Optional<Show> showOpt = showRepository.findById(showSeatEntryDto.getShowId());

        if(showOpt.isEmpty()) {
            throw new ShowDoesNotExists();
        }
        Show show = showOpt.get();
        Theater theater = show.getTheater();

        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = show.getShowSeatList();
        for(TheaterSeat theaterSeat : theaterSeatList) {
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());

            if(showSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setPrice((showSeatEntryDto.getPriceOfClassicSeat()));
            } else {
                showSeat.setPrice(showSeatEntryDto.getPriceOfPremiumSeat());
            }

            showSeat.setShow(show);
            showSeat.setIsAvailable(Boolean.TRUE);
            showSeat.setIsFoodContains(Boolean.FALSE);

            showSeatList.add(showSeat);
        }
        showRepository.save(show);

        return "Show seats have been associated successfully";
    }

    public List<Time> showTimingsOnDate(ShowTimingsDto showTimingsDto) {
        Date date = showTimingsDto.getDate();
        Integer theaterId = showTimingsDto.getTheaterId();
        Integer movieId = showTimingsDto.getMovieId();
        return showRepository.getShowTimingsOnDate(date, theaterId, movieId);
    }

    public String movieHavingMostShows() {
        Integer movieId = showRepository.getMostShowsMovie();
        return movieRepository.findById(movieId).get().getMovieName();
    }
}
