package co.edu.uniquindio.clinica.dto.paciente;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Eps;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;

import java.time.LocalDate;

public record DetallePacienteDTO(
        int cedula,
        String nombre,
        String telefono,
        String urlFoto,
        Ciudad ciudad,
        LocalDate fechaNacimiento,
        String alergias,
        Eps eps,
        TipoSangre tipoSangre,
        String correo
) {

}