package co.edu.uniquindio.clinica.dto.otro;
import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import jakarta.validation.constraints.*;

import java.time.LocalTime;

public record MedicoDTO(
        @NotBlank
        String nombre,

        @NotNull
        String cedula,

        @NotNull
        Ciudad ciudad,

        @NotNull
        Especialidad especialidad,

        @NotBlank
        String telefono,

        @NotBlank
        @Email
        String correo,

        @NotBlank
        String password,

        @NotNull
        LocalTime horaInicioJornada,

        @NotNull
        LocalTime horaFinJornada,

        @NotBlank
        String urlFoto

) {
}
