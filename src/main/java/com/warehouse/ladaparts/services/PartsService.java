package com.warehouse.ladaparts.services;

import com.warehouse.ladaparts.converters.PartDTOToPartEntityConverter;
import com.warehouse.ladaparts.converters.PartsEntityToPartDTOConverter;
import com.warehouse.ladaparts.converters.UpdateAutoMarkPartDTORqToAutoMarkPartsEntityConverter;
import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.dto.rq.PartRqDTO;
import com.warehouse.ladaparts.dto.rq.UpdateAutoMarkPartDTORq;
import com.warehouse.ladaparts.dto.rq.UpdatePartDTORq;
import com.warehouse.ladaparts.enteties.PartsEntity;
import com.warehouse.ladaparts.exceptions.EntityNotFoundException;
import com.warehouse.ladaparts.repository.AutoMarkPartsRepository;
import com.warehouse.ladaparts.repository.PartsRepository;
import com.warehouse.ladaparts.repository.PartsRepositoryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartsService {

    private PartsRepository partsRepository;
    private PartsRepositoryCriteria partsRepositoryCriteria;
    private AutoMarkPartsRepository autoMarkPartsRepository;
    private PartDTOToPartEntityConverter partDTOToPartEntityConverter;
    private PartsEntityToPartDTOConverter partsEntityToPartDTOConverter;
    private UpdateAutoMarkPartDTORqToAutoMarkPartsEntityConverter updateAutoMarkPartDTORqToAutoMarkPartsEntityConverter;

    public void save(UpdatePartDTORq updatePartDTORq) {
        partsRepository.save(partDTOToPartEntityConverter.apply(updatePartDTORq));
    }

    public void setModelCompatibilityWithPart(UpdateAutoMarkPartDTORq updateAutoMarkPartDTORq) {
        autoMarkPartsRepository.save(updateAutoMarkPartDTORqToAutoMarkPartsEntityConverter.apply(updateAutoMarkPartDTORq));
    }

    public void deleteById(Integer id) {
        partsRepository.deleteById(id);
    }

    public PartDTO findById(Integer id) {
        return partsEntityToPartDTOConverter.apply(partsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(PartsEntity.class, id.toString())));
    }

    public List<PartDTO> getAllPartsPageable(Integer page) {
        Pageable pageable = PageRequest.of(--page, 10);
        return partsRepository.findAll(pageable).stream()
                .map(partsEntityToPartDTOConverter)
                .collect(Collectors.toList());
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

    @Autowired
    public void setAutoMarkPartsRepository(AutoMarkPartsRepository autoMarkPartsRepository) {
        this.autoMarkPartsRepository = autoMarkPartsRepository;
    }

    @Autowired
    public void setUpdateAutoMarkPartDTORqToAutoMarkPartsEntityConverter(UpdateAutoMarkPartDTORqToAutoMarkPartsEntityConverter updateAutoMarkPartDTORqToAutoMarkPartsEntityConverter) {
        this.updateAutoMarkPartDTORqToAutoMarkPartsEntityConverter = updateAutoMarkPartDTORqToAutoMarkPartsEntityConverter;
    }
}
