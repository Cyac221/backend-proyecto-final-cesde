package com.cesde.medellinParce.Repositorio;

import com.cesde.medellinParce.Modelo.MUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IUsuario extends JpaRepository<MUsuario,String> {

    List<MUsuario> findByNombreCliente(String nombreCliente);

    List<MUsuario> findByActivoTrue();

}
