package com.github.supercoding.web.dto;

import java.util.Objects;

public class Item {
    private String id;
    private String name;
    private String type;
    private Integer price;
    private Spec spec;

    public Item(){
    }

    public Item(Integer id, ItemBody itemBody){
        this.id = String.valueOf(id);
        this.name = itemBody.getName();
        this.type = itemBody.getType();
        this.price = itemBody.getPrice();
        this.spec = itemBody.getSpec();
    }

    public Item(String id, String name, String type, Integer price, String cpu, String capacity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.spec = new Spec(cpu, capacity);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Integer getPrice() {
        return price;
    }

    public Spec getSpec() {
        return spec;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
