package co.edu.uniquindio.clinica.dto;

import co.edu.uniquindio.clinica.dto.admin.RespuestaDTO;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPqr;

import java.time.LocalDate;
import java.util.List;

public record DetallePqrDTO(
        int codigo,
        EstadoPqr estado,
        String motivo,
        String nombrePaciente,
        String medico,
        Especialidad especialidad,
        LocalDate fecha,
        List<RespuestaDTO> mensajes
) {
}
