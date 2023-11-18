package co.edu.uniquindio.clinica.dto.otro;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

public record MedicoPostDTO(
        String nombreMedico,
        Especialidad especialidad
) {
}
