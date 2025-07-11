package com.github.supercoding.web.dto.items;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "상품 요청 바디 DTO")
public class ItemBody {

    @Schema(
            name        = "name",
            description = "Item 이름",
            example     = "Dell XPS 15"
    )
    private String name;

    @Schema(
            name        = "type",
            description = "Item 기기타입",
            example     = "Laptop"
    )
    private String type;

    @Schema(
            name        = "price",
            description = "Item 가격",
            example     = "125000"
    )
    private Integer price;

    @Schema(
            name        = "spec",
            description = "Item 상세 사양"
    )
    private Spec spec;
}
