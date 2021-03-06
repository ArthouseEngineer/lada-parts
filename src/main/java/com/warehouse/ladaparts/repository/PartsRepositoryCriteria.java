package com.warehouse.ladaparts.repository;

import com.warehouse.ladaparts.converters.PartsEntityToPartCartDTOConverter;
import com.warehouse.ladaparts.converters.PartsEntityToPartDTOConverter;
import com.warehouse.ladaparts.dto.model.PartCartDTO;
import com.warehouse.ladaparts.dto.model.PartDTO;
import com.warehouse.ladaparts.dto.rq.PartRqDTO;
import com.warehouse.ladaparts.enteties.AutoFamiliesEntity;
import com.warehouse.ladaparts.enteties.AutoMarkPartsEntity;
import com.warehouse.ladaparts.enteties.ModelsEntity;
import com.warehouse.ladaparts.enteties.PartsEntity;
import com.warehouse.ladaparts.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PartsRepositoryCriteria {

    @PersistenceContext
    private EntityManager entityManager;
    private PartsEntityToPartDTOConverter partsEntityToPartDTOConverter;
    private PartsEntityToPartCartDTOConverter partsEntityToPartCartDTOConverter;

    /**
     * В качестве кретериев фильтрации можно добавить
     * name - Название запчасти
     * model - Совместимость с моделью
     * family - Совместимость с семейством
     * @param partRqDTO - ДТО фильтрации
     * @return Список с информацей по найденной детали PartDTO
     */
    public List<PartDTO> getPartByFilter(PartRqDTO partRqDTO) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PartsEntity> criteriaQuery = cb.createQuery(PartsEntity.class);
        Root<PartsEntity> partsEntityRoot = criteriaQuery.from(PartsEntity.class);
        Join<PartsEntity, AutoMarkPartsEntity> autoParts = partsEntityRoot.join("autoMarkPartsById", JoinType.LEFT);
        Join<AutoMarkPartsEntity, AutoFamiliesEntity> autoFamilies = autoParts.join("autoFamiliesByAutoFamilyId", JoinType.LEFT);
        Join<AutoMarkPartsEntity, ModelsEntity> autoModels = autoParts.join("modelsByAutoModelId", JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>();
        Map<String, String> searchParamsMap = new LinkedHashMap<>();
        if (partRqDTO.getName() != null) {
            predicates.add(cb.like(cb.upper(partsEntityRoot.get("name")), "%" + partRqDTO.getName().toUpperCase(Locale.ROOT) + "%"));
            searchParamsMap.put("name", partRqDTO.getName());
        }
        if (partRqDTO.getFamily() != null) {
            predicates.add(cb.like(cb.upper(autoFamilies.get("familyName")), "%" + partRqDTO.getFamily().toUpperCase(Locale.ROOT) + "%"));
            searchParamsMap.put("family", partRqDTO.getFamily());
        }
        if (partRqDTO.getModel() != null) {
            predicates.add(cb.like(cb.upper(autoModels.get("model")), "%" + partRqDTO.getModel().toUpperCase(Locale.ROOT) + "%"));
            searchParamsMap.put("model", partRqDTO.getModel());
        }
        // Так как заджоинились на модели если деталь подходит к нескольким модеям инфу в карточке не выводим, чтобы не дублировать информацию по запачасти дистинктнем
        criteriaQuery.where(predicates.toArray(new Predicate[0])).distinct(true);
        List<PartsEntity> partsEntities = entityManager.createQuery(criteriaQuery).getResultList();
        if (CollectionUtils.isEmpty(partsEntities)) {
            throw new EntityNotFoundException(PartsEntity.class, searchParamsMap);
        }
        return partsEntities.stream()
                .map(partsEntityToPartDTOConverter)
                .collect(Collectors.toList());
    }

    /**
     * @param partName - Найменование запчасти
     * @return Список карточек найденных запчастей
     */
    public List<PartCartDTO> getPartCartByPartName(String partName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<PartsEntity> criteriaQuery = cb.createQuery(PartsEntity.class);
        Root<PartsEntity> partsEntityRoot = criteriaQuery.from(PartsEntity.class);
        criteriaQuery.where(cb.like(cb.upper(partsEntityRoot.get("name")), "%" + partName.toUpperCase(Locale.ROOT) + "%"));
        List<PartsEntity> partsEntities = entityManager.createQuery(criteriaQuery).getResultList();
        if (CollectionUtils.isEmpty(partsEntities)) {
            throw new EntityNotFoundException(PartsEntity.class, partName);
        }
        return partsEntities.stream()
                .map(partsEntityToPartCartDTOConverter)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setConverter(PartsEntityToPartDTOConverter converter) {
        this.partsEntityToPartDTOConverter = converter;
    }

    @Autowired
    public void setPartsEntityToPartCartDTOConverter(PartsEntityToPartCartDTOConverter partsEntityToPartCartDTOConverter) {
        this.partsEntityToPartCartDTOConverter = partsEntityToPartCartDTOConverter;
    }
}
