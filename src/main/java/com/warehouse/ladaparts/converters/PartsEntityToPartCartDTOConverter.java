package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.enteties.PartsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PartsEntityToPartCartDTOConverter implements Function<PartsEntity, PartCartDTO> {

    private AutoMarkPartsEntityToAutoModelsDTO autoMarkPartsEntityToAutoModelsDTO;
    private PartsEntityToPartDTOConverter partsEntityToPartDTOConverter;

    @Override
    public PartCartDTO apply(PartsEntity partsEntity) {
        PartCartDTO partCartDTO = new PartCartDTO();
        partCartDTO.setId(partsEntity.getId());
        partCartDTO.setName(partsEntity.getName());
        partCartDTO.setPrice(partsEntity.getPrice());
        partCartDTO.setWeight(partsEntity.getWeight());
        partCartDTO.setModels(
                !CollectionUtils.isEmpty(partsEntity.getAutoMarkPartsById()) ?
                        partsEntity.getAutoMarkPartsById()
                                .stream()
                                .map(autoMarkPartsEntityToAutoModelsDTO)
                                .collect(Collectors.toList())
                        : Collections.emptyList()
        );
        partCartDTO.setCompositionParts(
                !CollectionUtils.isEmpty(partsEntity.getPartOfPartsById()) ?
                        partsEntity.getPartOfPartsById().stream()
                                .map(compParts -> partsEntityToPartDTOConverter.apply(compParts.getPartsByCompositivePartId()))
                                .collect(Collectors.toList())
                        : Collections.emptyList());
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
