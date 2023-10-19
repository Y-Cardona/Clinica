package co.edu.uniquindio.clinica.dto;
import jakarta.validation.constraints.NotBlank;
public record TokenDTO (
        @NotBlank
        String token
){
}
