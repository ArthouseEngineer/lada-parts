package com.warehouse.ladaparts.controllers;

import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.dto.rq.PartRqDTO;
import com.warehouse.ladaparts.dto.rq.UpdatePartDTORq;
import com.warehouse.ladaparts.services.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parts")
public class PartsController {

    private PartsService partsService;

    @PostMapping("/getPart")
    public List<PartDTO> getPart(@RequestBody PartRqDTO partRqDTO) {
        return partsService.getPartByFilter(partRqDTO);
    }

    @PostMapping("/updatePart")
    public ResponseEntity<Boolean> updatePart(@RequestBody UpdatePartDTORq updatePartDTORq) {
        PartDTO currentPart = partsService.findById(updatePartDTORq.getId());
        if (currentPart == null) {
            partsService.save(updatePartDTORq);
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
        partsService.save(updatePartDTORq);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/savePart")
    public void savePart(@RequestBody UpdatePartDTORq updatePartDTORq) {
        partsService.save(updatePartDTORq);
    }

    @GetMapping("/deletePartById/{id}")
    public void deletePartById(@PathVariable Integer id) {
        partsService.deleteById(id);
    }

    @Autowired
    public void setPartsService(PartsService partsService) {
        this.partsService = partsService;
    }
}
