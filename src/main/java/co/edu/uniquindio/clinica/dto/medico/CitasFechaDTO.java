package co.edu.uniquindio.clinica.dto.medico;

import java.time.LocalDate;

public record CitasFechaDTO(
        int codigoMedico,
        LocalDate fecha
){
}
