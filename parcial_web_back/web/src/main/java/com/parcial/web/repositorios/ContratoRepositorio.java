package com.parcial.web.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial.web.modelos.Contrato;


@Repository
public interface ContratoRepositorio extends JpaRepository<Contrato, Long> {
}
