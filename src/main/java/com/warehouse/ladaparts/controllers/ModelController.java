package com.warehouse.ladaparts.controllers;

import com.warehouse.ladaparts.dto.model.ModelDTO;
import com.warehouse.ladaparts.enteties.ModelsEntity;
import com.warehouse.ladaparts.services.ModelService;
import com.warehouse.ladaparts.utils.DTOUtilConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/models")
public class ModelController {

    private ModelService modelService;

    @PostMapping("/saveModel")
    public ModelsEntity saveModel(final @RequestBody ModelDTO modelDTO) {
        return modelService.saveModel(modelDTO);
    }

    @DeleteMapping("/deleteModelById/{id}")
    public void deleteModelById(final @PathVariable Integer id) {
        modelService.deleteModelByID(id);
    }

    @PostMapping("/deleteModel")
    public void deleteModelById(final @RequestBody ModelDTO modelDTO) {
        modelService.deleteModel(modelDTO);
    }

    @GetMapping("/getAll")
    public List<ModelDTO> getAllModels() {
        return DTOUtilConverter.mapList(modelService.getAllModels(), ModelDTO.class);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ModelDTO> findModelById(@PathVariable Integer id) {
        Optional<ModelsEntity> entityOptional = modelService.getModelById(id);
        return entityOptional
                .map(modelsEntity -> ResponseEntity.ok(DTOUtilConverter.map(modelsEntity, ModelDTO.class)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }
}
