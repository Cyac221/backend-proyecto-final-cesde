package com.cesde.medellinParce.Servicio;

import com.cesde.medellinParce.Modelo.MProducto;
import com.cesde.medellinParce.Repositorio.IProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SProducto {
    @Autowired
    IProducto iProducto;

    public SProducto(IProducto iProducto) {
        this.iProducto = iProducto;
    }

    // Adicionar producto
    public MProducto adicionarRegistroProducto(MProducto mProducto) throws Exception {
        try {
            return iProducto.save(mProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general productos
    public List<MProducto> consultaGeneralProducto() throws Exception {
        try {
            return iProducto.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
    public MProducto consultaIndividualID(String idProducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrado = iProducto.findById(idProducto);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Producto no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por nombre
    public List<MProducto> consultaIndividualNombre(String nombreProducto) throws Exception {
        try {
            return iProducto.findByNombreProducto(nombreProducto);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar producto
    public MProducto modificarProducto(String idProducto, MProducto mProducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrado = iProducto.findById(idProducto);
            if (registroEncontrado.isPresent()) {
                MProducto registroNuevo = registroEncontrado.get();
                registroNuevo.setIdProducto(mProducto.getIdProducto());
                registroNuevo.setNombreProducto(mProducto.getNombreProducto());
                registroNuevo.setTalla(mProducto.getTalla());
                registroNuevo.setColor(mProducto.getColor());
                registroNuevo.setPrecio(mProducto.getPrecio());
                registroNuevo.setDescripcion(mProducto.getDescripcion());
                return iProducto.save(registroNuevo);
            } else
                throw new Exception("No se puede modificar porque el producto no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar producto
    public Boolean eliminarProducto(String idProducto) throws Exception {
        try {
            Optional<MProducto> registroEncontrado = iProducto.findById(idProducto);
            if (registroEncontrado.isPresent()) {
                iProducto.deleteById(idProducto);
                return true;
            } else {
                throw new Exception("No se puede eliminar porque el producto no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
