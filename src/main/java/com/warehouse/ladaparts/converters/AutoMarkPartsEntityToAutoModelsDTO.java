package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.model.ModelDTO;
import com.warehouse.ladaparts.enteties.AutoMarkPartsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AutoMarkPartsEntityToAutoModelsDTO implements Function<AutoMarkPartsEntity, ModelDTO> {
    @Override
    public ModelDTO apply(AutoMarkPartsEntity autoMarkPartsEntity) {
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setModel(autoMarkPartsEntity.getModelsByAutoModelId().getModel());
        modelDTO.setId(autoMarkPartsEntity.getModelsByAutoModelId().getId());
        return modelDTO;
    }
}
