package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.enteties.PartsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PartsEntityToPartCartDTOConverter implements Function<PartsEntity, PartDTO> {

    @Override
    public PartDTO apply(PartsEntity partsEntity) {
        PartCartDTO partCartDTO = new PartCartDTO();
        partCartDTO.setName(partsEntity.getName());
        partCartDTO.setPrice(partsEntity.getPrice());
        return partCartDTO;
    }
}
