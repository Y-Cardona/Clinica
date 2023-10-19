package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

public record DetalleMedicoDTO(
        String nombre,
        int cedula,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String urlFoto
) {
}

