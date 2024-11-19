package com.parcial.web.modelos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Identificador;

    private double valor;

    private String nombre_contratante;

    private String documento_contratante;

    private String nombre_contratantista;

    private String documento_contratantista;

    private LocalDate fecha_inicial;

    private LocalDate fecha_final;
    
}
