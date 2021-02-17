package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "part_of_parts", schema = "public", catalog = "lada_store")
public class PartOfPartsEntity {
    private int id;
    private int partId;
    private int compositivePartId;
    private Integer countOfCompositivePart;
    private PartsEntity partsByPartId;
    private PartsEntity partsByCompositivePartId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "part_id", nullable = false)
    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "compositive_part_id", nullable = false)
    public int getCompositivePartId() {
        return compositivePartId;
    }

    public void setCompositivePartId(int compositivePartId) {
        this.compositivePartId = compositivePartId;
    }

    @Basic
    @Column(name = "count_of_compositive_part", nullable = true)
    public Integer getCountOfCompositivePart() {
        return countOfCompositivePart;
    }

    public void setCountOfCompositivePart(Integer countOfCompositivePart) {
        this.countOfCompositivePart = countOfCompositivePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartOfPartsEntity that = (PartOfPartsEntity) o;
        return id == that.id && partId == that.partId && compositivePartId == that.compositivePartId && Objects.equals(countOfCompositivePart, that.countOfCompositivePart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partId, compositivePartId, countOfCompositivePart);
    }

    @ManyToOne
    @JoinColumn(name = "part_id", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    public PartsEntity getPartsByPartId() {
        return partsByPartId;
    }

    public void setPartsByPartId(PartsEntity partsByPartId) {
        this.partsByPartId = partsByPartId;
    }

    @ManyToOne
    @JoinColumn(name = "compositive_part_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public PartsEntity getPartsByCompositivePartId() {
        return partsByCompositivePartId;
    }

    public void setPartsByCompositivePartId(PartsEntity partsByCompositivePartId) {
        this.partsByCompositivePartId = partsByCompositivePartId;
    }
}
