package com.github.supercoding.web.dto.airline;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@Setter
@NoArgsConstructor
@Schema(description = "항공권 정보")
public class Ticket {

    @Schema(description = "승객 출발지", example = "서울")
    private String depart;

    @Schema(description = "승객 도착지", example = "파리")
    private String arrival;

    @Schema(description = "항공권 출발시간", example = "2023-05-05 11:00:00")
    private String departureTime;

    @Schema(description = "항공권 귀국시간", example = "2023-05-07 11:00:00")
    private String returnTime;

    @Schema(name = "ticketId", description = "Ticket ID", example = "1")
    private Integer ticketId;
}
