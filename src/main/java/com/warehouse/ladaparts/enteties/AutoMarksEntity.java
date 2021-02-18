package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "auto_marks", schema = "public", catalog = "lada_store")
public class AutoMarksEntity {
    private Integer id;
    private Integer familyId;
    private Integer modelId;
    private AutoFamiliesEntity autoFamiliesByFamilyId;
    private ModelsEntity modelsByModelId;

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
    @Column(name = "family_id", nullable = false,updatable = false, insertable = false)
    public Integer getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "model_id", nullable = false,updatable = false, insertable = false)
    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoMarksEntity that = (AutoMarksEntity) o;
        return id.equals(that.id) && familyId.equals(that.familyId) && modelId.equals(that.modelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyId, modelId);
    }

    @ManyToOne
    @JoinColumn(name = "family_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    public AutoFamiliesEntity getAutoFamiliesByFamilyId() {
        return autoFamiliesByFamilyId;
    }

    public void setAutoFamiliesByFamilyId(AutoFamiliesEntity autoFamiliesByFamilyId) {
        this.autoFamiliesByFamilyId = autoFamiliesByFamilyId;
    }

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false,updatable = false, insertable = false)
    public ModelsEntity getModelsByModelId() {
        return modelsByModelId;
    }

    public void setModelsByModelId(ModelsEntity modelsByModelId) {
        this.modelsByModelId = modelsByModelId;
    }
}
