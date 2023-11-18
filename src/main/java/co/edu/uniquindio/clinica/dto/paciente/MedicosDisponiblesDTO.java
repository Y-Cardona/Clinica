package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record MedicosDisponiblesDTO(
        @NotNull
        LocalDate fecha,
        @NotNull
        Especialidad especialidad
) {
}
