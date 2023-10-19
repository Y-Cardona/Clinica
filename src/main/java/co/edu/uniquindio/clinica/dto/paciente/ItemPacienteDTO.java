package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;

public record ItemPacienteDTO(
        int cedula,
        String nombre,
        Ciudad ciudad
) {
}
