package com.cesde.medellinParce.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuarios")
public class MUsuario {

    @Id
    @Column(name = "id", length = 15, nullable = false)
    String idCliente;
    @Column(length = 150, nullable = false)
    String nombreCliente;
    @Column(length = 200, nullable = false)
    String correoElectronico;
    @Column(length = 300, nullable = false)
    String password;
    @Column(length = 300, nullable = true)
    String direccionEnvio;
    @Column(length = 130, nullable = true)
    String numeroTelefono;
    @Column(nullable = false)
    Boolean activo = true;
    @Column(length = 20, nullable = false)
    String rol = "usuario";

    // Relaciones
    @OneToMany(mappedBy = "mUsuario")
    @JsonManagedReference
    List<MOrdenCompra> mOrdenCompras;

    @OneToMany(mappedBy = "mUsuario")
    @JsonIgnore
    List<MCarrito> mCarritos;

    // Constructores
    public MUsuario(String idCliente, String nombreCliente, String correoElectronico, String password, String direccionEnvio, String numeroTelefono,String rol) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.direccionEnvio = direccionEnvio;
        this.numeroTelefono = numeroTelefono;
        this.rol = rol;
    }

    public MUsuario() {
    }

    // Getter y setter
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public List<MOrdenCompra> getmOrdenCompras() {
        return mOrdenCompras;
    }

    public void setmOrdenCompras(List<MOrdenCompra> mOrdenCompras) {
        this.mOrdenCompras = mOrdenCompras;
    }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public List<MCarrito> getmCarritos() { return mCarritos; }
    public void setmCarritos(List<MCarrito> mCarritos) { this.mCarritos = mCarritos; }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
