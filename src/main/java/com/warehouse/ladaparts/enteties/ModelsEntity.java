package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "models", schema = "public", catalog = "lada_store")
public class ModelsEntity {
    private Integer id;
    private String model;
    private Collection<AutoMarkPartsEntity> autoMarkPartsById;
    private Collection<AutoMarksEntity> autoMarksById;

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
    @Column(name = "model", nullable = false, length = -1)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModelsEntity that = (ModelsEntity) o;
        return id == that.id && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model);
    }

    @OneToMany(mappedBy = "modelsByAutoModelId")
    public Collection<AutoMarkPartsEntity> getAutoMarkPartsById() {
        return autoMarkPartsById;
    }

    public void setAutoMarkPartsById(Collection<AutoMarkPartsEntity> autoMarkPartsById) {
        this.autoMarkPartsById = autoMarkPartsById;
    }

    @OneToMany(mappedBy = "modelsByModelId")
    public Collection<AutoMarksEntity> getAutoMarksById() {
        return autoMarksById;
    }

    public void setAutoMarksById(Collection<AutoMarksEntity> autoMarksById) {
        this.autoMarksById = autoMarksById;
    }
}
