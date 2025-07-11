package com.github.supercoding.web.dto.items;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(description = "상품 상세 사양 DTO")
public class Spec {

    @Schema(
            name        = "cpu",
            description = "Item CPU",
            example     = "Google Tensor"
    )
    private String cpu;

    @Schema(
            name        = "capacity",
            description = "Item 용량 Spec",
            example     = "25G"
    )
    private String capacity;
}
