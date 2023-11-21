package co.edu.uniquindio.clinica.dto.paciente;

import java.time.LocalTime;

public record MedicosDisponiblesGetDTO (
        String nombreMedico,
        LocalTime horaDisponible,
        int codigoMedico
){
}