package com.github.supercoding.web.dto.airline;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@NoArgsConstructor
@Getter
@Schema(description = "예약 요청 DTO")
public class ReservationRequest {

    @Schema(
            name        = "user_id",
            description = "유저 ID",
            example     = "1"
    )
    private Integer userId;

    @Schema(
            name        = "airline_ticket_id",
            description = "항공권 ID",
            example     = "2"
    )
    private Integer airlineTicketId;
}
