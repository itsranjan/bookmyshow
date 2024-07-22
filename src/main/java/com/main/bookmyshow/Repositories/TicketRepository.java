package com.main.bookmyshow.Repositories;

import com.main.bookmyshow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
