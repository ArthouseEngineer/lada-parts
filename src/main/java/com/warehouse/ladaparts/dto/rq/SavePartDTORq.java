package com.warehouse.ladaparts.dto.rq;

import java.math.BigDecimal;

public class SavePartDTORq {
    private String name;
    private BigDecimal price;
    private BigDecimal weight;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
