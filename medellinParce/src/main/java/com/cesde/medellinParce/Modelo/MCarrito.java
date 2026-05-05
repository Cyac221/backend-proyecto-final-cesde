package com.cesde.medellinParce.Modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;




@Entity
@Table(name = "carrito")
public class MCarrito {

    @Id
    @Column(name = "id_carrito", nullable = false)
    String idCarrito;  // cambia a camelCase    String id_carrito;
    @JsonFormat(pattern = "yyyy-MM-dd")  // <- aquí, encima de fecha
    @Column(nullable = false)
    LocalDate fecha;
    @Column(nullable = false)
    Integer items;
    @Column(nullable = false)
    Integer total;


    // Relaciones
    @OneToMany(mappedBy = "mCarrito")
    @JsonManagedReference("carrito-carritoItems")
    List<MCarritoItems> mCarritoItems;

    @ManyToOne
    @JoinColumn(name = "idUsuarioFK", nullable = false)
    @JsonProperty("mUsuario")
    MUsuario mUsuario;

    // Constructores
    public MCarrito(String idCarrito, LocalDate fecha, Integer items, Integer total) {
        this.idCarrito = idCarrito;
        this.fecha = fecha;
        this.items = items;
        this.total = total;
    }

    public MCarrito() {
    }

    // Getter y setter
    public String getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(String idCarrito) {
        this.idCarrito = idCarrito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<MCarritoItems> getmCarritoItems() {
        return mCarritoItems;
    }

    public void setmCarritoItems(List<MCarritoItems> mCarritoItems) {
        this.mCarritoItems = mCarritoItems;
    }

    public MUsuario getmUsuario() { return mUsuario; }
    public void setmUsuario(MUsuario mUsuario) { this.mUsuario = mUsuario; }
}
