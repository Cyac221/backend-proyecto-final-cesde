package com.cesde.medellinParce.Servicio;

import com.cesde.medellinParce.Modelo.MCarrito;
import com.cesde.medellinParce.Repositorio.ICarrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCarrito {
    @Autowired
    ICarrito iCarrito;

    public SCarrito(ICarrito iCarrito) {
        this.iCarrito = iCarrito;
    }

    // Adicionar carrito
    public MCarrito adicionarRegistroCarrito(MCarrito mCarrito) throws Exception {
        try {
            return iCarrito.save(mCarrito);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general carritos
    public List<MCarrito> consultaGeneralCarrito() throws Exception {
        try {
            return iCarrito.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
    public MCarrito consultaIndividualID(String idCarrito) throws Exception {
        try {
            Optional<MCarrito> registroEncontrado = iCarrito.findById(idCarrito);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Carrito no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar carrito
    public MCarrito modificarCarrito(String idCarrito, MCarrito mCarrito) throws Exception {
        try {
            Optional<MCarrito> registroEncontrado = iCarrito.findById(idCarrito);
            if (registroEncontrado.isPresent()) {
                MCarrito registroNuevo = registroEncontrado.get();
                registroNuevo.setIdCarrito(mCarrito.getIdCarrito());
                registroNuevo.setFecha(mCarrito.getFecha());
                registroNuevo.setItems(mCarrito.getItems());
                registroNuevo.setTotal(mCarrito.getTotal());
                return iCarrito.save(registroNuevo);
            } else
                throw new Exception("No se puede modificar porque el carrito no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar carrito
    public Boolean eliminarCarrito(String idCarrito) throws Exception {
        try {
            Optional<MCarrito> registroEncontrado = iCarrito.findById(idCarrito);
            if (registroEncontrado.isPresent()) {
                iCarrito.deleteById(idCarrito);
                return true;
            } else {
                throw new Exception("No se puede eliminar porque el carrito no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
