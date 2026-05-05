package com.cesde.medellinParce.Repositorio;

import com.cesde.medellinParce.Modelo.MCarritoItems;
import com.cesde.medellinParce.Modelo.MCarritoItemsId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICarritoItems extends JpaRepository<MCarritoItems, MCarritoItemsId> {
}
