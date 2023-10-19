package co.edu.uniquindio.clinica.dto.medico;

import java.time.LocalDateTime;

public record AtencionMedica(
        int codigoCita,
        String nombrePaciente,
        LocalDateTime fechaCita,
        String motivo
) {
}
