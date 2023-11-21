package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.dto.otro.HorarioDTO;
import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

import java.time.LocalTime;

public record DetalleMedicoDTO(
        String nombre,
        String cedula,
        Ciudad ciudad,
        Especialidad especialidad,
        String telefono,
        String correo,
        String urlFoto,
        LocalTime horaInicio,
        LocalTime horaFin
) {
}

