package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.otro.ItemCitaDTO;
import co.edu.uniquindio.clinica.dto.medico.*;
import co.edu.uniquindio.clinica.dto.paciente.DetalleCita;
import co.edu.uniquindio.clinica.modelo.entidades.Cita;

import java.util.List;

public interface MedicoServicio {

    List<ItemCitaDTO> listarCitasPendientesDia(CitasFechaDTO listaCitasFechaDTO) ;

    List<Cita> listarCitasPendientes(int codigoMedico) ;

    DetalleAtencionMedicaDTO atenderCita(int codigoCita)throws Exception;

    List<DetalleCita> listarHistorialMedico(int codigoPaciente); //Historial médico

    void agendarDiaLibre(AgendarDiaLibre agendarDiaLibre) throws Exception;

    List<AtencionMedica> listarCitasRealizadasMedico(int codigoMedico);

    void finalizarCita(FinalizarCitaDTO finalizarCitaDTO) throws Exception;
}