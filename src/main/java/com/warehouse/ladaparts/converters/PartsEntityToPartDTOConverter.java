package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.enteties.PartsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PartsEntityToPartDTOConverter implements Function<PartsEntity, PartDTO> {

    @Override
    public PartDTO apply(PartsEntity partsEntity) {
        PartDTO partDTO = new PartDTO();
        partDTO.setId(partsEntity.getId());
        partDTO.setName(partsEntity.getName());
        partDTO.setPrice(partsEntity.getPrice());
        return partDTO;
    }
}
