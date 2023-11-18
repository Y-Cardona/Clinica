package co.edu.uniquindio.clinica.dto.otro;

import co.edu.uniquindio.clinica.dto.admin.RespuestaDTO;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

import java.time.LocalDate;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        EstadoPQRS estado,
        String motivo,
        String nombrePaciente,
        String medico,
        Especialidad especialidad,
        LocalDate fecha,
        List<RespuestaDTO> mensajes
) {
}
