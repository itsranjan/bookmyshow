package com.main.bookmyshow.Repositories;

import com.main.bookmyshow.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    @Query(value = "select time_start from shows where date = :date and movie_id = :movieId and theater_id = :theaterId" , nativeQuery = true)
    public List<Time> getShowTimingsOnDate(@Param("date")Date date, @Param("theaterId")Integer theaterId, @Param("movieId")Integer movieId);

    @Query(value = "select movie_id from shows group by movie_id order by count(*) desc limit 1" , nativeQuery = true)
    public Integer getMostShowsMovie();

    @Query(value = "select * from shows where date = :date and screenno = :screenno", nativeQuery = true)
    public List<Show> getoverlappingdetails(@Param("date")Date date, @Param("screenno")Integer screenno);
    @Query(value = "select * from shows where movie_id = :movieId" , nativeQuery = true)
    public List<Show> getAllShowsOfMovie(@Param("movieId")Integer movieId);
}
