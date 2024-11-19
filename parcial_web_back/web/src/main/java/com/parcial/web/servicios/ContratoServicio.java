package com.parcial.web.servicios;

import java.util.List;
import java.util.Optional;

import com.parcial.web.dto.ContratoDTO;
import com.parcial.web.modelos.Contrato;
import com.parcial.web.repositorios.ContratoRepositorio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratoServicio {

    @Autowired
    private ContratoRepositorio contratoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    public List<ContratoDTO> obtenerTodosLosContratos() {
        List<Contrato> contratos = contratoRepositorio.findAll();
        return contratos.stream()
                .map(contrato -> modelMapper.map(contrato, ContratoDTO.class))
                .toList();
    }

    public ContratoDTO obtenerContratoPorId(Long id) {
        Optional<Contrato> contrato = contratoRepositorio.findById(id);
        return contrato.map(c -> modelMapper.map(c, ContratoDTO.class)).orElse(null);
    }

    public ContratoDTO guardarContrato(ContratoDTO contratoDTO) {
        Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
        Contrato contratoGuardado = contratoRepositorio.save(contrato);
        return modelMapper.map(contratoGuardado, ContratoDTO.class);
    }

    public ContratoDTO actualizarContrato(Long id, ContratoDTO contratoDTO) {
        Optional<Contrato> contratoExistente = contratoRepositorio.findById(id);
        if (contratoExistente.isPresent()) {
            Contrato contrato = modelMapper.map(contratoDTO, Contrato.class);
            contrato.setId(id);
            Contrato contratoActualizado = contratoRepositorio.save(contrato);
            return modelMapper.map(contratoActualizado, ContratoDTO.class);
        }
        return null;
    }

    public void eliminarContrato(Long id) {
        contratoRepositorio.deleteById(id);
    }
}
