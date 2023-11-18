package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.HistorialConsultas;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RespuestaDTO;
import co.edu.uniquindio.clinica.dto.otro.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.otro.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.otro.MedicoDTO;
import co.edu.uniquindio.clinica.dto.paciente.ItemPacienteDTO;

import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO)throws Exception;

    int actualizarMedico(DetalleMedicoDTO detalleMedicoDTO)throws Exception;

    void eliminarMedico(int codigo)throws Exception;

    List<ItemMedicoDTO> listarMedicos()throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo)throws Exception;

    List<ItemPQRSDTO> listarPQRS()throws Exception;

    DetallePQRSDTO verDetallePQRS (int codigo) throws Exception;

    void responderPQRS(RespuestaDTO respuestaDTO)throws Exception;

    List<ItemCitaAdminDTO> listarCitas()throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS)throws Exception;

    public List<HistorialConsultas> verHistorialDeConsultas();

    public List<HistorialConsultas> verHistorialDeConsultasMedico(int codigoMedico);

    List<ItemPacienteDTO> listarTodos(); // Método para listar las citas médicas agendadas por el paciente.

}
