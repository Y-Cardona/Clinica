package co.edu.uniquindio.clinica.dto.admin;

import co.edu.uniquindio.clinica.modelo.enums.Especialidad;

import java.time.LocalTime;

public record ItemMedicoDTO(
        int cedula,
        String nombre,
        String urlFoto,
        Especialidad especialidad,
        LocalTime horaInicio,
        LocalTime horaFin) {
}

