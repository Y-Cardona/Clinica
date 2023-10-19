package co.edu.uniquindio.clinica.dto;

import java.time.LocalDateTime;

public record PQRSDTOAdmin(
        int codigo,
        int estadoPQRS,
        String nombrePaciente,
        LocalDateTime fecha
){

}
