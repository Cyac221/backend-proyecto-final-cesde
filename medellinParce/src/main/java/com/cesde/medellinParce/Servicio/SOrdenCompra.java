package com.cesde.medellinParce.Servicio;

import com.cesde.medellinParce.Modelo.MOrdenCompra;
import com.cesde.medellinParce.Repositorio.IOrdenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SOrdenCompra {
    @Autowired
    IOrdenCompra iOrdenCompra;

    public SOrdenCompra(IOrdenCompra iOrdenCompra) {
        this.iOrdenCompra = iOrdenCompra;
    }

    // Adicionar orden de compra
    public MOrdenCompra adicionarRegistroOrdenCompra(MOrdenCompra mOrdenCompra) throws Exception {
        try {
            return iOrdenCompra.save(mOrdenCompra);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general ordenes de compra
    public List<MOrdenCompra> consultaGeneralOrdenCompra() throws Exception {
        try {
            return iOrdenCompra.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
    public MOrdenCompra consultaIndividualID(String idCompra) throws Exception {
        try {
            Optional<MOrdenCompra> registroEncontrado = iOrdenCompra.findById(idCompra);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Orden de compra no registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar orden de compra
    public MOrdenCompra modificarOrdenCompra(String idCompra, MOrdenCompra mOrdenCompra) throws Exception {
        try {
            Optional<MOrdenCompra> registroEncontrado = iOrdenCompra.findById(idCompra);
            if (registroEncontrado.isPresent()) {
                MOrdenCompra registroNuevo = registroEncontrado.get();
                registroNuevo.setIdCompra(mOrdenCompra.getIdCompra());
                registroNuevo.setNumeroOrden(mOrdenCompra.getNumeroOrden());
                registroNuevo.setCliente(mOrdenCompra.getCliente());
                registroNuevo.setListaProductos(mOrdenCompra.getListaProductos());
                registroNuevo.setFecha(mOrdenCompra.getFecha());
                return iOrdenCompra.save(registroNuevo);
            } else
                throw new Exception("No se puede modificar porque la orden de compra no está registrada");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar orden de compra
    public Boolean eliminarOrdenCompra(String idCompra) throws Exception {
        try {
            Optional<MOrdenCompra> registroEncontrado = iOrdenCompra.findById(idCompra);
            if (registroEncontrado.isPresent()) {
                iOrdenCompra.deleteById(idCompra);
                return true;
            } else {
                throw new Exception("No se puede eliminar porque la orden de compra no está registrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
