package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.enteties.PartsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PartsEntityToPartCartDTOConverter implements Function<PartsEntity, PartCartDTO> {

    private AutoMarkPartsEntityToAutoModelsDTO autoMarkPartsEntityToAutoModelsDTO;
    private PartsEntityToPartDTOConverter partsEntityToPartDTOConverter;

    @Override
    public PartCartDTO apply(PartsEntity partsEntity) {
        PartCartDTO partCartDTO = new PartCartDTO();
        partCartDTO.setName(partsEntity.getName());
        partCartDTO.setPrice(partsEntity.getPrice());
        partCartDTO.setModels(partsEntity.getAutoMarkPartsById().stream()
                .map(autoMarkPartsEntityToAutoModelsDTO)
                .collect(Collectors.toList()));
        partCartDTO.setCompositionParts(partsEntity.getPartOfPartsById_0().stream()
                .map(compParts -> partsEntityToPartDTOConverter.apply(compParts.getPartsByCompositivePartId()))
                .collect(Collectors.toList()));
        return partCartDTO;
    }

    @Autowired
    public void setAutoMarkPartsEntityToAutoModelsDTO(AutoMarkPartsEntityToAutoModelsDTO autoMarkPartsEntityToAutoModelsDTO) {
        this.autoMarkPartsEntityToAutoModelsDTO = autoMarkPartsEntityToAutoModelsDTO;
    }

    @Autowired
    public void setPartsEntityToPartDTOConverter(PartsEntityToPartDTOConverter partsEntityToPartDTOConverter) {
        this.partsEntityToPartDTOConverter = partsEntityToPartDTOConverter;
    }
}
