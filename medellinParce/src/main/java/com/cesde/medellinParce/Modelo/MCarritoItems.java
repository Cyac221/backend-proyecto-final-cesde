package com.cesde.medellinParce.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "carritoItems-intermedia")
public class MCarritoItems {

    @EmbeddedId
    MCarritoItemsId id;

    @Column(nullable = false)
    Integer cantidad;

    // Relaciones
    @ManyToOne
    @MapsId("idProductoFK")
    @JoinColumn(name = "idProductoFK")
    @JsonBackReference("producto-carritoItems")  // nombre único
    MProducto mProducto;

    @ManyToOne
    @MapsId("idCarritoFK")
    @JoinColumn(name = "idCarritoFK")
    @JsonBackReference("carrito-carritoItems")  // nombre único
    MCarrito mCarrito;

    // Constructores
    public MCarritoItems(MCarritoItemsId id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }

    public MCarritoItems() {
    }

    // Getter y setter
    public MCarritoItemsId getId() {
        return id;
    }

    public void setId(MCarritoItemsId id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public MProducto getmProducto() {
        return mProducto;
    }

    public void setmProducto(MProducto mProducto) {
        this.mProducto = mProducto;
    }

    public MCarrito getmCarrito() {
        return mCarrito;
    }

    public void setmCarrito(MCarrito mCarrito) {
        this.mCarrito = mCarrito;
    }
}
