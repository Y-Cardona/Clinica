package co.edu.uniquindio.clinica.dto.otro;
import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        int codigoCita,
        EstadoCita estadoCita,
        String paciente,
        LocalDateTime fecha
        // va la lista de lo que quiero mostrar ahí
) {
}
