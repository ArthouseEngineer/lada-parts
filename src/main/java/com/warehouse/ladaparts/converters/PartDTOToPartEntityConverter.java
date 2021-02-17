package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.rq.UpdatePartDTORq;
import com.warehouse.ladaparts.enteties.PartsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PartDTOToPartEntityConverter implements Function<UpdatePartDTORq, PartsEntity> {
    @Override
    public PartsEntity apply(UpdatePartDTORq updatePartDTORq) {
        PartsEntity partsEntity = new PartsEntity();
        // Переисользуем конвертер для создания новой запчасти
        if (updatePartDTORq.getId() != null)
            partsEntity.setId(updatePartDTORq.getId());
        partsEntity.setName(updatePartDTORq.getName());
        partsEntity.setPrice(updatePartDTORq.getPrice());
        partsEntity.setWeight(updatePartDTORq.getWeight());
        return partsEntity;
    }
}
