package com.cesde.medellinParce.Repositorio;

import com.cesde.medellinParce.Modelo.MUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface IUsuario extends JpaRepository<MUsuario,String> {

    List<MUsuario> findByNombreCliente(String nombreCliente);

    List<MUsuario> findByActivoTrue();

    Optional<MUsuario> findByCorreoElectronico(String correoElectronico);

}
