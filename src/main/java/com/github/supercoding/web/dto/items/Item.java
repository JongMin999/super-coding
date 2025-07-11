package com.github.supercoding.web.dto.items;

import com.github.supercoding.repository.Items.ItemEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(description = "상품 DTO")
public class Item {

    @Schema(
            name        = "id",
            description = "Item Id",
            example     = "1"
    )
    private String id;

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
