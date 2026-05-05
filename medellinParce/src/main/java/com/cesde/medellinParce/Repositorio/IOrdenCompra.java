package com.cesde.medellinParce.Repositorio;

import com.cesde.medellinParce.Modelo.MOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenCompra extends JpaRepository<MOrdenCompra,String> {
}