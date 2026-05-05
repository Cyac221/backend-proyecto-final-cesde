package com.cesde.medellinParce.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MCarritoItemsId implements Serializable {

    @Column(name = "idProductoFK", length = 10, nullable = false)
    String idProductoFK;
    @Column(name = "idCarritoFK" ,length = 10, nullable = false)
    String idCarritoFK;

    public MCarritoItemsId(String idProductoFK, String idCarritoFK) {
        this.idProductoFK = idProductoFK;
        this.idCarritoFK = idCarritoFK;
    }

    public MCarritoItemsId() {
    }

    public String getIdProductoFK() {
        return idProductoFK;
    }

    public void setIdProductoFK(String idProductoFK) {
        this.idProductoFK = idProductoFK;
    }

    public String getIdCarritoFK() {
        return idCarritoFK;
    }

    public void setIdCarritoFK(String idCarritoFK) {
        this.idCarritoFK = idCarritoFK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MCarritoItemsId)) return false;
        MCarritoItemsId that = (MCarritoItemsId) o;
        return Objects.equals(idProductoFK, that.idProductoFK) && Objects.equals(idCarritoFK, that.idCarritoFK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProductoFK, idCarritoFK);
    }
}
