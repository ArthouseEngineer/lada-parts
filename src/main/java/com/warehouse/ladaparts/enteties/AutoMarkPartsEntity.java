package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "auto_mark_parts", schema = "public", catalog = "lada_store")
public class AutoMarkPartsEntity {
    private Integer id;
    private Integer partId;
    private Integer autoFamilyId;
    private Integer autoModelId;
    private PartsEntity partsByPartId;
    private AutoFamiliesEntity autoFamiliesByAutoFamilyId;
    private ModelsEntity modelsByAutoModelId;

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
    @Column(name = "auto_family_id", nullable = true)
    public Integer getAutoFamilyId() {
        return autoFamilyId;
    }

    public void setAutoFamilyId(Integer autoFamilyId) {
        this.autoFamilyId = autoFamilyId;
    }

    @Basic
    @Column(name = "auto_model_id", nullable = true)
    public Integer getAutoModelId() {
        return autoModelId;
    }

    public void setAutoModelId(Integer autoModelId) {
        this.autoModelId = autoModelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoMarkPartsEntity that = (AutoMarkPartsEntity) o;
        return id == that.id && partId == that.partId && Objects.equals(autoFamilyId, that.autoFamilyId) && Objects.equals(autoModelId, that.autoModelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, partId, autoFamilyId, autoModelId);
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
    @JoinColumn(name = "auto_family_id", referencedColumnName = "id",insertable = false, updatable = false)
    public AutoFamiliesEntity getAutoFamiliesByAutoFamilyId() {
        return autoFamiliesByAutoFamilyId;
    }

    public void setAutoFamiliesByAutoFamilyId(AutoFamiliesEntity autoFamiliesByAutoFamilyId) {
        this.autoFamiliesByAutoFamilyId = autoFamiliesByAutoFamilyId;
    }

    @ManyToOne
    @JoinColumn(name = "auto_model_id", referencedColumnName = "id",insertable = false, updatable = false)
    public ModelsEntity getModelsByAutoModelId() {
        return modelsByAutoModelId;
    }

    public void setModelsByAutoModelId(ModelsEntity modelsByAutoModelId) {
        this.modelsByAutoModelId = modelsByAutoModelId;
    }
}
