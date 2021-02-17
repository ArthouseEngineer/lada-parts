package com.warehouse.ladaparts.services;

import com.warehouse.ladaparts.dto.model.ModelDTO;
import com.warehouse.ladaparts.enteties.ModelsEntity;
import com.warehouse.ladaparts.repository.ModelRepository;
import com.warehouse.ladaparts.utils.DTOUtilConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("modelService")
public class ModelService  {
   private ModelRepository modelRepository;

   public ModelsEntity saveModel(ModelDTO modelDTO) {
      return modelRepository.save(DTOUtilConverter.map(modelDTO, ModelsEntity.class));
   }

    public void deleteModel(ModelDTO modelDTO) {
        modelRepository.delete(DTOUtilConverter.map(modelDTO,ModelsEntity.class));
    }

    public void deleteModelByID(Integer id) {
        modelRepository.deleteById(id);
    }

   public List<ModelsEntity> getAllModels() {
       return modelRepository.findAll();
   }

   public Optional<ModelsEntity> getModelById(Integer id) {
       return modelRepository.findById(id);
   }


    @Autowired
    public void setModelRepository(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
