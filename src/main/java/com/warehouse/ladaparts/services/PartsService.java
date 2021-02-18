package com.warehouse.ladaparts.services;

import com.warehouse.ladaparts.converters.PartDTOToPartEntityConverter;
import com.warehouse.ladaparts.converters.PartsEntityToPartDTOConverter;
import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.dto.rq.PartRqDTO;
import com.warehouse.ladaparts.dto.rq.UpdatePartDTORq;
import com.warehouse.ladaparts.enteties.PartsEntity;
import com.warehouse.ladaparts.exceptions.EntityNotFoundException;
import com.warehouse.ladaparts.repository.PartsRepository;
import com.warehouse.ladaparts.repository.PartsRepositoryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsService {

    private PartsRepository partsRepository;
    private PartsRepositoryCriteria partsRepositoryCriteria;
    private PartDTOToPartEntityConverter partDTOToPartEntityConverter;
    private PartsEntityToPartDTOConverter partsEntityToPartDTOConverter;

    public void save(UpdatePartDTORq updatePartDTORq) {
        partsRepository.save(partDTOToPartEntityConverter.apply(updatePartDTORq));
    }

    public void deleteById(Integer id) {
        partsRepository.deleteById(id);
    }

    public PartDTO findById(Integer id) {
        return partsEntityToPartDTOConverter.apply(partsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PartsEntity.class, id.toString())));
    }

    public List<PartDTO> getPartByFilter(PartRqDTO partRqDTO) {
        return partsRepositoryCriteria.getPartByFilter(partRqDTO);
    }

    public List<PartCartDTO> getPartCartByPartName(String partName) {
        return partsRepositoryCriteria.getPartCartByPartName(partName);
    }

    @Autowired
    public void setPartsRepository(PartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }

    @Autowired
    public void setPartsRepositoryCriteria(PartsRepositoryCriteria partsRepositoryCriteria) {
        this.partsRepositoryCriteria = partsRepositoryCriteria;
    }

    @Autowired
    public void setPartDTOToPartEntityConverter(PartDTOToPartEntityConverter partDTOToPartEntityConverter) {
        this.partDTOToPartEntityConverter = partDTOToPartEntityConverter;
    }

    @Autowired
    public void setPartsEntityToPartDTOConverter(PartsEntityToPartDTOConverter partsEntityToPartDTOConverter) {
        this.partsEntityToPartDTOConverter = partsEntityToPartDTOConverter;
    }
}
