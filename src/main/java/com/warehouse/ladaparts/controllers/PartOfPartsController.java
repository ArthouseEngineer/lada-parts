package com.warehouse.ladaparts.controllers;

import com.warehouse.ladaparts.dto.rq.UpdateCompositivePartDTORq;
import com.warehouse.ladaparts.enteties.PartOfPartsEntity;
import com.warehouse.ladaparts.repository.PartOfPartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compositiveParts")
public class PartOfPartsController {

    private PartOfPartsRepository partsRepository;

    @PostMapping("/save")
    public void saveCompositivePart(@RequestBody UpdateCompositivePartDTORq updateCompositivePartDTORq) {
        PartOfPartsEntity partOfPartsEntity = new PartOfPartsEntity();
        partOfPartsEntity.setCompositivePartId(updateCompositivePartDTORq.getCompositivePartId());
        partOfPartsEntity.setPartId(updateCompositivePartDTORq.getPartId());
        partOfPartsEntity.setCountOfCompositivePart(updateCompositivePartDTORq.getCountOfCompositivePart());
        partsRepository.save(partOfPartsEntity);
    }

    @Autowired
    public void setPartsRepository(PartOfPartsRepository partsRepository) {
        this.partsRepository = partsRepository;
    }
}
