package co.edu.uniquindio.clinica.dto.otro;


public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {

}
