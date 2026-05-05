package com.cesde.medellinParce.Modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ordenCompra")
public class MOrdenCompra {

    @Id
    @Column(length = 10, nullable = false)
    String idCompra;
    @Column(length = 10, nullable = false)
    String numeroOrden;
    @Column(length = 10, nullable = false)
    String cliente;
    @Column(length = 10, nullable = false)
    String listaProductos;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    LocalDate fecha;

    // Relaciones
    @ManyToOne
    @JoinColumn(name = "pkorden", referencedColumnName = "id")
    @JsonBackReference
    MUsuario mUsuario;

    // Constructores
    public MOrdenCompra(String idCompra, String numeroOrden, String cliente, String listaProductos, LocalDate fecha) {
        this.idCompra = idCompra;
        this.numeroOrden = numeroOrden;
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.fecha = fecha;
    }

    public MOrdenCompra() {
    }

    // Getter y setter
    public String getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(String idCompra) {
        this.idCompra = idCompra;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(String listaProductos) {
        this.listaProductos = listaProductos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MUsuario getmUsuario() {
        return mUsuario;
    }

    public void setmUsuario(MUsuario mUsuario) {
        this.mUsuario = mUsuario;
    }
}
