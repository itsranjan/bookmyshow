package com.main.bookmyshow.Repositories;

import com.main.bookmyshow.Models.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    Theater findByAddress(String address);
}
