package com.main.bookmyshow.Transformers;

import com.main.bookmyshow.Dtos.ResponseDtos.TicketResponseDto;
import com.main.bookmyshow.Models.Show;
import com.main.bookmyshow.Models.Ticket;

public class TicketTransformer {

    public static TicketResponseDto returnTicket(Show show, Ticket ticket) {
        TicketResponseDto ticketResponseDto = TicketResponseDto.builder()
                .bookedSeats(ticket.getBookedSeats())
                .address(show.getTheater().getAddress())
                .theaterName(show.getTheater().getName())
                .movieName(show.getMovie().getMovieName())
                .date(show.getDate())
                .time(show.getTime_start())
                .screenno(show.getScreenno())
                .totalPrice(ticket.getTotalTicketsPrice())
                .build();

        return ticketResponseDto;
    }
}
