package com.warehouse.ladaparts.dto.model;

public class ModelDTO {
    private String model;
    private Integer id;

    public ModelDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
