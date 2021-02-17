package com.warehouse.ladaparts.enteties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "parts", schema = "public", catalog = "lada_store")
public class PartsEntity {
    private int id;
    private String name;
    private BigDecimal price;
    private BigDecimal weight;
    private Collection<AutoMarkPartsEntity> autoMarkPartsById;
    private Collection<PartOfPartsEntity> partOfPartsById;
    private Collection<PartOfPartsEntity> partOfPartsById_0;

    public PartsEntity(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public PartsEntity() {

    }

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
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "weight", nullable = false)
    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartsEntity that = (PartsEntity) o;
        return id == that.id && price.equals(that.price) && weight.equals(that.weight) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, weight);
    }

    @OneToMany(mappedBy = "partsByPartId")
    public Collection<AutoMarkPartsEntity> getAutoMarkPartsById() {
        return autoMarkPartsById;
    }

    public void setAutoMarkPartsById(Collection<AutoMarkPartsEntity> autoMarkPartsById) {
        this.autoMarkPartsById = autoMarkPartsById;
    }

    @OneToMany(mappedBy = "partsByPartId")
    public Collection<PartOfPartsEntity> getPartOfPartsById() {
        return partOfPartsById;
    }

    public void setPartOfPartsById(Collection<PartOfPartsEntity> partOfPartsById) {
        this.partOfPartsById = partOfPartsById;
    }

    @OneToMany(mappedBy = "partsByCompositivePartId")
    public Collection<PartOfPartsEntity> getPartOfPartsById_0() {
        return partOfPartsById_0;
    }

    public void setPartOfPartsById_0(Collection<PartOfPartsEntity> partOfPartsById_0) {
        this.partOfPartsById_0 = partOfPartsById_0;
    }
}
