package co.edu.uniquindio.clinica.dto.otro;import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

import java.time.LocalDate;

public record ItemPQRSDTO(int codigo,
                          EstadoPQRS estado,
                          String motivo,
                          LocalDate fecha,
                          String paciente,
                          String medico){
}
