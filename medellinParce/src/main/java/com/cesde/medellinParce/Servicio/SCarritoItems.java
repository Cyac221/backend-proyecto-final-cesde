package com.cesde.medellinParce.Servicio;

import com.cesde.medellinParce.Modelo.MCarritoItems;
import com.cesde.medellinParce.Modelo.MCarritoItemsId;
import com.cesde.medellinParce.Repositorio.ICarritoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SCarritoItems {
    @Autowired
    ICarritoItems iCarritoItems;

    public SCarritoItems(ICarritoItems iCarritoItems) {
        this.iCarritoItems = iCarritoItems;
    }

    // Adicionar carritoItem
    public MCarritoItems adicionarRegistroCarritoItems(MCarritoItems mCarritoItems) throws Exception {
        try {
            return iCarritoItems.save(mCarritoItems);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general carritoItems
    public List<MCarritoItems> consultaGeneralCarritoItems() throws Exception {
        try {
            return iCarritoItems.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID compuesto
    public MCarritoItems consultaIndividualID(String idProductoFK, String idCarritoFK) throws Exception {
        try {
            MCarritoItemsId id = new MCarritoItemsId(idProductoFK, idCarritoFK);
            Optional<MCarritoItems> registroEncontrado = iCarritoItems.findById(id);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("CarritoItem no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar carritoItem
    public MCarritoItems modificarCarritoItems(String idProductoFK, String idCarritoFK, MCarritoItems mCarritoItems) throws Exception {
        try {
            MCarritoItemsId id = new MCarritoItemsId(idProductoFK, idCarritoFK);
            Optional<MCarritoItems> registroEncontrado = iCarritoItems.findById(id);
            if (registroEncontrado.isPresent()) {
                MCarritoItems registroNuevo = registroEncontrado.get();
                registroNuevo.setId(mCarritoItems.getId());
                registroNuevo.setCantidad(mCarritoItems.getCantidad());
                return iCarritoItems.save(registroNuevo);
            } else
                throw new Exception("No se puede modificar porque el carritoItem no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar carritoItem
    public Boolean eliminarCarritoItems(String idProductoFK, String idCarritoFK) throws Exception {
        try {
            MCarritoItemsId id = new MCarritoItemsId(idProductoFK, idCarritoFK);
            Optional<MCarritoItems> registroEncontrado = iCarritoItems.findById(id);
            if (registroEncontrado.isPresent()) {
                iCarritoItems.deleteById(id);
                return true;
            } else {
                throw new Exception("No se puede eliminar porque el carritoItem no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
