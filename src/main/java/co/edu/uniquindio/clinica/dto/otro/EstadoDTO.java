package co.edu.uniquindio.clinica.dto.otro;

import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

public record EstadoDTO(
        int codigoPQRS,
        EstadoPQRS estadoPQRS
) {
}