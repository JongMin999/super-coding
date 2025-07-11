package com.github.supercoding.web.dto.airline;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Schema(description = "티켓 응답 객체")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class TicketResponse {

    @Schema(
            name        = "tickets",
            description = "티켓 목록",
            example     = "[{\"depart\":\"서울\",\"arrival\":\"파리\",\"departureTime\":\"2025-07-11T10:00:00\",\"returnTime\":\"2025-07-20T10:00:00\",\"ticketId\":1}]"
    )
    private List<Ticket> tickets;
}
