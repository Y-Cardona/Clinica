package co.edu.uniquindio.clinica.dto.paciente;

import java.time.LocalDate;

public record RegistroPQRSDTO(
        int CodigoCita,
        String movito,
        int codigoPaciente,
        String Detalle
) {
}
