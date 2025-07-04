package com.github.supercoding.web.controller;

import com.github.supercoding.service.ElectronicStoreItemService;
import com.github.supercoding.web.dto.BuyOrder;
import com.github.supercoding.web.dto.Item;
import com.github.supercoding.web.dto.ItemBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ElectronicStoreController {
    private ElectronicStoreItemService electronicStoreItemService;

    public ElectronicStoreController(ElectronicStoreItemService electronicStoreItemService) {
        this.electronicStoreItemService = electronicStoreItemService;
    }

    @PostMapping("/items")
    public String registerItem(@RequestBody ItemBody itemBody) {
        Integer id = electronicStoreItemService.saveItem(itemBody);
        return "ID: " + id;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return electronicStoreItemService.findAllItem();
    }

    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable String id) {
        return electronicStoreItemService.findItemByID(id);
    }

    @GetMapping("/items-query")
    public Item getItemByQueryId(@RequestParam("id") String id) {
        return electronicStoreItemService.findItemByID(id);
    }

    @GetMapping("/items-queries")
    public List<Item> getItemByQueryId(@RequestParam("id") List<String> ids) {
        return electronicStoreItemService.findItemsByIds(ids);
    }

    @DeleteMapping("/items/{id}")
    public String deleteItemById(@PathVariable String id) {
        electronicStoreItemService.deleteItem(id);
        return "Object with id =" + id + "has been deleted";
    }

    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody ItemBody itemBody) {
        return electronicStoreItemService.updateItem(id, itemBody);
    }

    @PostMapping("/items/buy")
    public String buyItems(@RequestBody BuyOrder buyOrder){
        Integer orderItemNums = electronicStoreItemService.buyItems(buyOrder);
        return "요청하신 Item 중 " + orderItemNums + "개를 구매 하였습니다.";
    }
}