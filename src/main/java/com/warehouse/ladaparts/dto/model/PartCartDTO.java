package com.warehouse.ladaparts.dto.model;

import java.util.List;

public class  PartCartDTO  extends  PartDTO  {
    private Integer weight;
    private List<ModelDTO> models;
    private List<PartDTO> compositionParts;
    private List<ModelDTO> modelsList;

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
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

    public List<ModelDTO> getModelsList() {
        return modelsList;
    }

    public void setModelsList(List<ModelDTO> modelsList) {
        this.modelsList = modelsList;
    }
}
