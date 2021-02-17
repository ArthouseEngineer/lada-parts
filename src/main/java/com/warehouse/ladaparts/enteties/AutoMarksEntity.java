package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "auto_marks", schema = "public", catalog = "lada_store")
public class AutoMarksEntity {
    private int id;
    private int familyId;
    private int modelId;
    private AutoFamiliesEntity autoFamiliesByFamilyId;
    private ModelsEntity modelsByModelId;

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
    @Column(name = "family_id", nullable = false)
    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Basic
    @Column(name = "model_id", nullable = false)
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoMarksEntity that = (AutoMarksEntity) o;
        return id == that.id && familyId == that.familyId && modelId == that.modelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyId, modelId);
    }

    @ManyToOne
    @JoinColumn(name = "family_id", referencedColumnName = "id", nullable = false,insertable = false, updatable = false)
    public AutoFamiliesEntity getAutoFamiliesByFamilyId() {
        return autoFamiliesByFamilyId;
    }

    public void setAutoFamiliesByFamilyId(AutoFamiliesEntity autoFamiliesByFamilyId) {
        this.autoFamiliesByFamilyId = autoFamiliesByFamilyId;
    }

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public ModelsEntity getModelsByModelId() {
        return modelsByModelId;
    }

    public void setModelsByModelId(ModelsEntity modelsByModelId) {
        this.modelsByModelId = modelsByModelId;
    }
}
