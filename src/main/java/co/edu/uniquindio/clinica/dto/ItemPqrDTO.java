package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.modelo.enums.EstadoPqr;

import java.time.LocalDate;

public record ItemPqrDTO(int codigo,
                         EstadoPqr estado,
                         String motivo,
                         LocalDate fecha,
                         String nombrePaciente){
}
