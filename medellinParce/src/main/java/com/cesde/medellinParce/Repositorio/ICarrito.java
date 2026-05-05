package com.cesde.medellinParce.Repositorio;

import com.cesde.medellinParce.Modelo.MCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarrito extends JpaRepository<MCarrito,String> {
}
