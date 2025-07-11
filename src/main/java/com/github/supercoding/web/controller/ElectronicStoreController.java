package com.github.supercoding.web.controller;

import com.github.supercoding.service.ElectronicStoreItemService;
import com.github.supercoding.web.dto.items.BuyOrder;
import com.github.supercoding.web.dto.items.Item;
import com.github.supercoding.web.dto.items.ItemBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class ElectronicStoreController {

    private final ElectronicStoreItemService electronicStoreItemService;

    @Operation(summary = "모든 Items 검색")
    @GetMapping("/items")
    public List<Item> findAllItem() {
        log.info("GET /items 요청이 들어왔습니다.");
        List<Item> items = electronicStoreItemService.findAllItem();
        log.info("GET /items 응답: {}", items);
        return items;
    }

    @Operation(summary = "단일 Item 등록")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "등록할 Item 정보",
            required = true
    )
    @PostMapping("/items")
    public String registerItem(
            @RequestBody ItemBody itemBody
    ) {
        Integer itemId = electronicStoreItemService.savaItem(itemBody);
        return "ID: " + itemId;
    }

    @Operation(summary = "단일 Item 조회 (PathVariable)")
    @GetMapping("/items/{id}")
    public Item findItemByPathId(
            @Parameter(name = "id", description = "Item ID", example = "1")
            @PathVariable String id
    ) {
        return electronicStoreItemService.findItemById(id);
    }

    @Operation(summary = "단일 Item 조회 (RequestParam)")
    @GetMapping("/items-query")
    public Item findItemByQueryId(
            @Parameter(name = "id", description = "Item ID", example = "1")
            @RequestParam("id") String id
    ) {
        return electronicStoreItemService.findItemById(id);
    }

    @Operation(summary = "여러 Item 조회 (RequestParam 리스트)")
    @GetMapping("/items-queries")
    public List<Item> findItemByQueryIds(
            @Parameter(name = "ids", description = "Item ID 리스트", example = "[\"1\",\"2\",\"3\"]")
            @RequestParam("ids") List<String> ids
    ) {
        log.info("GET /items-queries 요청 ids: {}", ids);
        List<Item> items = electronicStoreItemService.findItemsByIds(ids);
        log.info("GET /items-queries 응답: {}", items);
        return items;
    }

    @Operation(summary = "단일 Item 삭제")
    @DeleteMapping("/items/{id}")
    public String deleteItemByPathId(
            @Parameter(name = "id", description = "Item ID", example = "1")
            @PathVariable String id
    ) {
        electronicStoreItemService.deleteItem(id);
        return "Object with id=" + id + " has been deleted";
    }

    @Operation(summary = "단일 Item 수정")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "수정할 Item 정보",
            required = true
    )
    @PutMapping("/items/{id}")
    public Item updateItem(
            @Parameter(name = "id", description = "Item ID", example = "1")
            @PathVariable String id,
            @RequestBody ItemBody itemBody
    ) {
        return electronicStoreItemService.updateItem(id, itemBody);
    }

    @Operation(summary = "단일 Item 구매")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "구매 주문 정보",
            required = true
    )
    @PostMapping("/items/buy")
    public String buyItem(
            @RequestBody BuyOrder buyOrder
    ) {
        Integer orderItemNums = electronicStoreItemService.buyItems(buyOrder);
        return "요청하신 Item 중 " + orderItemNums + "개를 구매하였습니다.";
    }
}
