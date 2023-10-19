package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;

public record FinalizarCitaDTO(
        int codigoCita,
        String diagnostico,
        String notas_medicas,
        String tratamiento
) {
}
