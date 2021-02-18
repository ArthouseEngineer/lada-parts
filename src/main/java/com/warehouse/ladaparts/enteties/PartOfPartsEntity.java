package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "part_of_parts", schema = "public", catalog = "lada_store")
public class PartOfPartsEntity {
    private Integer id;
    private Integer partId;
    private Integer compositivePartId;
    private Integer countOfCompositivePart;
    private PartsEntity partsByPartId;
    private PartsEntity partsByCompositivePartId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "part_id", nullable = false)
    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    @Basic
    @Column(name = "compositive_part_id", nullable = false)
    public Integer getCompositivePartId() {
        return compositivePartId;
    }

    public void setCompositivePartId(Integer compositivePartId) {
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
        return id.equals(that.id) && partId.equals(that.partId) && compositivePartId.equals(that.compositivePartId) && Objects.equals(countOfCompositivePart, that.countOfCompositivePart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partId, compositivePartId, countOfCompositivePart);
    }

    @ManyToOne
    @JoinColumn(name = "part_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    public PartsEntity getPartsByPartId() {
        return partsByPartId;
    }

    public void setPartsByPartId(PartsEntity partsByPartId) {
        this.partsByPartId = partsByPartId;
    }

    @ManyToOne
    @JoinColumn(name = "compositive_part_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    public PartsEntity getPartsByCompositivePartId() {
        return partsByCompositivePartId;
    }

    public void setPartsByCompositivePartId(PartsEntity partsByCompositivePartId) {
        this.partsByCompositivePartId = partsByCompositivePartId;
    }
}
