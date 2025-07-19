package com.github.supercoding.web.controller;

import com.github.supercoding.repository.userDetails.CustomUserDetails;
import com.github.supercoding.service.AirReservationService;
import com.github.supercoding.web.dto.airline.ReservationRequest;
import com.github.supercoding.web.dto.airline.ReservationResult;
import com.github.supercoding.web.dto.airline.Ticket;
import com.github.supercoding.web.dto.airline.TicketResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            @AuthenticationPrincipal CustomUserDetails customUserDetails,
            @Parameter(name = "airline-ticket-type", description = "항공권 타입", example = "왕복|편도")
            @RequestParam("airline-ticket-type") String ticketType
    ) {
        Integer userId = customUserDetails.getUserId();
        List<Ticket> tickets = airReservationService.findUserFavoritePlaceTickets(userId, ticketType);
        return new TicketResponse(tickets);
    }

    @Operation(summary = "User와 Ticket Id로 예약 진행")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reservations")
    public ReservationResult makeReservation(
            @RequestBody ReservationRequest reservationRequest){
        return airReservationService.makeReservation(reservationRequest);
    }

    @Operation(summary = "userId의 예약한 항공편과 수수료 총합")
    @GetMapping("/users-sum-price")
    public Double findUserFlightSumPrice(
            @AuthenticationPrincipal CustomUserDetails customUserDetails
    )
    {
        Integer userId = customUserDetails.getUserId();
        Double sum = airReservationService.findUserFlightSumPrice(userId);
        return sum;
    }
}
