package co.edu.uniquindio.clinica.dto.paciente;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        LocalDateTime fechaCita,
        String motivo,
        int idPaciente,
        int idMedico
) {
}
