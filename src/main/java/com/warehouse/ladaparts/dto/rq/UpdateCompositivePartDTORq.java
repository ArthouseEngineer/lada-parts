package com.warehouse.ladaparts.dto.rq;

public class UpdateCompositivePartDTORq extends UpdatePartDTORq {
    private Integer partId;
    private Integer compositivePartId;
    private Integer countOfCompositivePart;

    public Integer getCountOfCompositivePart() {
        return countOfCompositivePart;
    }

    public void setCountOfCompositivePart(Integer countOfCompositivePart) {
        this.countOfCompositivePart = countOfCompositivePart;
    }

    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public Integer getCompositivePartId() {
        return compositivePartId;
    }

    public void setCompositivePartId(Integer compositivePartId) {
        this.compositivePartId = compositivePartId;
    }
}
