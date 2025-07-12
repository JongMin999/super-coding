package com.github.supercoding.web.controller;

import com.github.supercoding.service.AirReservationService;
import com.github.supercoding.web.dto.airline.ReservationRequest;
import com.github.supercoding.web.dto.airline.ReservationResult;
import com.github.supercoding.web.dto.airline.Ticket;
import com.github.supercoding.web.dto.airline.TicketResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/air-reservation")
@RequiredArgsConstructor
@Slf4j
public class AirReservationController {

    private final AirReservationService airReservationService;

    @Operation(summary = "선호하는 티켓 탐색")
    @GetMapping("/tickets")
    public TicketResponse findAirlineTickets(
            @Parameter(name = "user-Id", description = "유저 ID", example = "1")
            @RequestParam("user-Id") Integer userId,

            @Parameter(name = "airline-ticket-type", description = "항공권 타입", example = "왕복|편도")
            @RequestParam("airline-ticket-type") String ticketType
    ) {
        List<Ticket> tickets = airReservationService.findUserFavoritePlaceTickets(userId, ticketType);
        return new TicketResponse(tickets);
    }

    @Operation(summary = "User와 Ticket Id로 예약 진행")
    @PostMapping("/reservations")
    public ReservationResult makeReservation(
            @RequestBody ReservationRequest reservationRequest){
        return airReservationService.makeReservation(reservationRequest);
    }
}
