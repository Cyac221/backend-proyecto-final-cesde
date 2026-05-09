package com.cesde.medellinParce.Servicio;

import com.cesde.medellinParce.Modelo.MUsuario;
import com.cesde.medellinParce.Repositorio.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SUsuario {
    @Autowired
    IUsuario iUsuario;

    public SUsuario(IUsuario iUsuario) {
        this.iUsuario = iUsuario;
    }

    // Adicionar usuario
    public MUsuario adicionarRegistroUsuario(MUsuario mUsuario) throws Exception {
        try {
            return iUsuario.save(mUsuario);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta general usuarios
    public List<MUsuario> consultaGeneralUsuario() throws Exception {
        try {
            return iUsuario.findByActivoTrue();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por ID
    public MUsuario consultaIndividualID(String idCliente) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(idCliente);
            if (registroEncontrado.isPresent())
                return registroEncontrado.get();
            else
                throw new Exception("Usuario no registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Consulta individual por nombre
    public List<MUsuario> consultaIndividualNombre(String nombreCliente) throws Exception {
        try {
            return iUsuario.findByNombreCliente(nombreCliente);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar usuario
    public MUsuario modificarUsuario(String idCliente, MUsuario mUsuario) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(idCliente);
            if (registroEncontrado.isPresent()) {
                MUsuario registroNuevo = registroEncontrado.get();
                registroNuevo.setIdCliente(mUsuario.getIdCliente());
                registroNuevo.setNombreCliente(mUsuario.getNombreCliente());
                registroNuevo.setCorreoElectronico(mUsuario.getCorreoElectronico());
                registroNuevo.setPassword(mUsuario.getPassword());
                registroNuevo.setDireccionEnvio(mUsuario.getDireccionEnvio());
                registroNuevo.setNumeroTelefono(mUsuario.getNumeroTelefono());
                return iUsuario.save(registroNuevo);
            } else
                throw new Exception("No se puede modificar porque el usuario no está registrado");
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar usuario
    public Boolean eliminarUsuario(String idCliente) throws Exception {
        try {
            Optional<MUsuario> registroEncontrado = iUsuario.findById(idCliente);
            if (registroEncontrado.isPresent()) {
                MUsuario usuario = registroEncontrado.get();
                usuario.setActivo(false);
                iUsuario.save(usuario);
                return true;
            } else {
                throw new Exception("No se puede eliminar porque el usuario no está registrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public List<MUsuario> consultaTodosUsuarios() throws Exception {
        try {
            return iUsuario.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
