package com.main.bookmyshow.Repositories;

import com.main.bookmyshow.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {


    Movie findByMovieName(String name);
}
