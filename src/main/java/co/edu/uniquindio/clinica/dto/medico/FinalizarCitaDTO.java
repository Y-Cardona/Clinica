package co.edu.uniquindio.clinica.dto.medico;

public record FinalizarCitaDTO(
        int codigoCita,
        String diagnostico,
        String notas_medicas,
        String tratamiento
) {
}
