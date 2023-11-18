package co.edu.uniquindio.clinica.dto.medico;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Eps;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;

public record DetalleAtencionMedicaDTO(

        String cedulaPaciente,
        String nombrePaciente,
        String telefono,
        Eps eps,
        TipoSangre tipoSangre,
        Ciudad ciudad,

        Especialidad especialidad,
        String nombreMedico,
        String Motivo

) {
}