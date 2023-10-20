package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record PqrDTOAdmin(
        int codigo,
        int estadoPqr,
        String nombrePaciente,
        LocalDateTime fecha
){

}
