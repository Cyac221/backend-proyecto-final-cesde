package com.cesde.medellinParce.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.List;

@Entity
@Table(name = "producto")
public class MProducto {

    @Id
    @Column(length = 10, nullable = false)
    String idProducto;
    @Column(length = 20, nullable = false)
    String nombreProducto;
    @Column(length = 5, nullable = false)
    String talla;
    @Column(length = 10, nullable = false)
    String color;
    @Column(nullable = false)
    Integer precio;
    @Column(length = 60, nullable = false)
    String descripcion;

    // Relaciones
    @OneToMany(mappedBy = "mProducto")
    @JsonIgnore
    List<MCarritoItems> mCarritoItems;

    // Constructores
    public MProducto(String idProducto, String nombreProducto, String talla, String color, Integer precio, String descripcion) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.talla = talla;
        this.color = color;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public MProducto() {
    }

    // Getter y setter
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<MCarritoItems> getmCarritoItems() {
        return mCarritoItems;
    }

    public void setmCarritoItems(List<MCarritoItems> mCarritoItems) {
        this.mCarritoItems = mCarritoItems;
    }
}
