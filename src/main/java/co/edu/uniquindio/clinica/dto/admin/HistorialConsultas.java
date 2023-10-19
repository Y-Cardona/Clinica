package co.edu.uniquindio.clinica.dto.admin;

import java.time.LocalDateTime;

public record HistorialConsultas(
        LocalDateTime fecha,
        int codigoMedico,
        String medico,
        int codigoPaciente,
        String Nombrepaciente
) {
}
