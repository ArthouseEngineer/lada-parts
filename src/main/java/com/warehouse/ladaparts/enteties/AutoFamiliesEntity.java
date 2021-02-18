package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "auto_families", schema = "public", catalog = "lada_store")
public class AutoFamiliesEntity {
    private Integer id;
    private String familyName;
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
    @Column(name = "family_name", nullable = false, length = -1)
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoFamiliesEntity that = (AutoFamiliesEntity) o;
        return id.equals(that.id) && Objects.equals(familyName, that.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, familyName);
    }

    @OneToMany(mappedBy = "autoFamiliesByAutoFamilyId")
    public Collection<AutoMarkPartsEntity> getAutoMarkPartsById() {
        return autoMarkPartsById;
    }

    public void setAutoMarkPartsById(Collection<AutoMarkPartsEntity> autoMarkPartsById) {
        this.autoMarkPartsById = autoMarkPartsById;
    }

    @OneToMany(mappedBy = "autoFamiliesByFamilyId")
    public Collection<AutoMarksEntity> getAutoMarksById() {
        return autoMarksById;
    }

    public void setAutoMarksById(Collection<AutoMarksEntity> autoMarksById) {
        this.autoMarksById = autoMarksById;
    }
}
