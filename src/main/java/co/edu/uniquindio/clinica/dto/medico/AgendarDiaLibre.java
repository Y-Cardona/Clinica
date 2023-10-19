package co.edu.uniquindio.clinica.dto.medico;

import jakarta.validation.constraints.Future;

import java.time.LocalDate;

public record AgendarDiaLibre(
        int codigoMedico,
        @Future
        LocalDate fecha
) {
}
