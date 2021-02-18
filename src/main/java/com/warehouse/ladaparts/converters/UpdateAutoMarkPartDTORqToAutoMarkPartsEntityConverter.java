package com.warehouse.ladaparts.converters;

import com.warehouse.ladaparts.dto.rq.UpdateAutoMarkPartDTORq;
import com.warehouse.ladaparts.enteties.AutoMarkPartsEntity;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UpdateAutoMarkPartDTORqToAutoMarkPartsEntityConverter implements Function<UpdateAutoMarkPartDTORq, AutoMarkPartsEntity> {

    @Override
    public AutoMarkPartsEntity apply(UpdateAutoMarkPartDTORq updateAutoMarkPartDTORq) {
        AutoMarkPartsEntity autoMarkPartsEntity = new AutoMarkPartsEntity();
        autoMarkPartsEntity.setPartId(updateAutoMarkPartDTORq.getPartId());
        autoMarkPartsEntity.setAutoModelId(updateAutoMarkPartDTORq.getAutoModelId());
        if (updateAutoMarkPartDTORq.getAutoFamilyId() != null)
            autoMarkPartsEntity.setAutoFamilyId(updateAutoMarkPartDTORq.getAutoFamilyId());
        return autoMarkPartsEntity;
    }
}
