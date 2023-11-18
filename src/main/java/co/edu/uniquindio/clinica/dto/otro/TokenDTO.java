package co.edu.uniquindio.clinica.dto.otro;
import jakarta.validation.constraints.NotBlank;
public record TokenDTO (
        @NotBlank
        String token
){
}
