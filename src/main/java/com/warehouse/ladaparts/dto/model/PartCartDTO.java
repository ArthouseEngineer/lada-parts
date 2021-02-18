package com.warehouse.ladaparts.dto.model;

import java.math.BigDecimal;
import java.util.List;

public class PartCartDTO extends PartDTO {
    private BigDecimal weight;
    private List<ModelDTO> models;
    private List<PartDTO> compositionParts;

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }


    public List<ModelDTO> getModels() {
        return models;
    }

    public void setModels(List<ModelDTO> models) {
        this.models = models;
    }

    public List<PartDTO> getCompositionParts() {
        return compositionParts;
    }

    public void setCompositionParts(List<PartDTO> compositionParts) {
        this.compositionParts = compositionParts;
    }

}
