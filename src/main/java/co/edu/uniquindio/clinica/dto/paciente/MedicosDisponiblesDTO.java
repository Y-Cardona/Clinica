package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MedicosDisponiblesDTO(

    LocalDate fecha,
    Especialidad especialidad
) {
}
