package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Eps;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;

import java.util.List;

public interface ClinicaServicio {

    List<Ciudad> listarCiudades();

    List<Eps> listarEps();

    List<TipoSangre> listarTipoSangre();

    List<Especialidad> listarEspecialidades();
}
