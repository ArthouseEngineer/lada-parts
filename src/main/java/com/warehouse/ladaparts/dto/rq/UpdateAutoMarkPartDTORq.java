package com.warehouse.ladaparts.dto.rq;

public class UpdateAutoMarkPartDTORq {
    private Integer partId;
    private Integer autoFamilyId;
    private Integer autoModelId;

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getAutoFamilyId() {
        return autoFamilyId;
    }

    public void setAutoFamilyId(Integer autoFamilyId) {
        this.autoFamilyId = autoFamilyId;
    }

    public Integer getAutoModelId() {
        return autoModelId;
    }

    public void setAutoModelId(Integer autoModelId) {
        this.autoModelId = autoModelId;
    }
}
