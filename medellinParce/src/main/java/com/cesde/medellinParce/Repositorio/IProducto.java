package com.cesde.medellinParce.Repositorio;

import com.cesde.medellinParce.Modelo.MProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IProducto extends JpaRepository<MProducto,String> {

    List<MProducto> findByNombreProducto(String nombreProducto);

}
