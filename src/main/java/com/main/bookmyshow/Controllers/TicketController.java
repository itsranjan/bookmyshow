package com.main.bookmyshow.Controllers;

import com.main.bookmyshow.Dtos.RequestDtos.TicketEntryDto;
import com.main.bookmyshow.Dtos.ResponseDtos.TicketResponseDto;
import com.main.bookmyshow.Exceptions.RequestedSeatAreNotAvailable;
import com.main.bookmyshow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/book")
    public ResponseEntity<TicketResponseDto> ticketBooking(@RequestBody TicketEntryDto ticketEntryDto) {
        try {
            TicketResponseDto result = ticketService.ticketBooking(ticketEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            //e.getMessage();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
