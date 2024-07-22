package com.main.bookmyshow.Models;

import com.main.bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "THEATER_SEATS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String seatNo;

    private Integer screenno;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    @JoinColumn
    private Theater theater;
}


















