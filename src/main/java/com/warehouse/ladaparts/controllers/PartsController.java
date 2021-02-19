package com.warehouse.ladaparts.controllers;

import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.dto.rq.PartRqDTO;
import com.warehouse.ladaparts.dto.rq.UpdateAutoMarkPartDTORq;
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

    /**
     * @param partRqDTO ДТО с возможность кастомных фильтров, на модель/семейство
     * @return Спсиок найденных запчастей
     */
    @PostMapping("/getPart")
    public List<PartDTO> getPart(@RequestBody PartRqDTO partRqDTO) {
        return partsService.getPartByFilter(partRqDTO);
    }

    /**
     * @param partName - Имя запчасти для которой формируем карточку
     * @return - Карточка запчкаи
     */
    @PostMapping(value = "/getPartCart")
    public List<PartCartDTO> getPartCart(@RequestParam String partName) {
        return partsService.getPartCartByPartName(partName);
    }

    /**
     * @param page - Страница для формирования списка запчастей, выдаем по  10 на страницу
     * @return - Список запчастей
     */
    @PostMapping(value = "/getParts")
    public List<PartDTO> getAllPartsPageable(@RequestParam Integer page) {
        return partsService.getAllPartsPageable(page);
    }

    /**
     * @param updatePartDTORq  - DTO обновляемой запчасти
     * @return Успешность обновления
     */
    @PostMapping("/updatePart")
    public ResponseEntity<Boolean> updatePart(@RequestBody UpdatePartDTORq updatePartDTORq) {
        PartDTO currentPart = partsService.findById(updatePartDTORq.getId());
        if (currentPart == null) {
            partsService.save(updatePartDTORq);
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
        partsService.save(updatePartDTORq);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    /**
     * Сохраняем запчасть согласно ДТО
     * @param updatePartDTORq - ДТО с информацией по запчасти
     */
    @PostMapping("/savePart")
    public void savePart(@RequestBody UpdatePartDTORq updatePartDTORq) {
        partsService.save(updatePartDTORq);
    }

    /**
     * Устанавливаеем совместимость запчасти с марками
     */
    @PostMapping("/setModelCompatibility")
    public void setModelCompatibilityWithPart(@RequestBody UpdateAutoMarkPartDTORq updateAutoMarkPartDTORq) {
        partsService.setModelCompatibilityWithPart(updateAutoMarkPartDTORq);
    }


    /**
     * Удаляем запчасть по заданному ИД
     * @param id - ИД удаляемой запчасти
     */
    @DeleteMapping("/deletePartById")
    public void deletePartById(@RequestParam Integer id) {
        partsService.deleteById(id);
    }

    @Autowired
    public void setPartsService(PartsService partsService) {
        this.partsService = partsService;
    }
}
