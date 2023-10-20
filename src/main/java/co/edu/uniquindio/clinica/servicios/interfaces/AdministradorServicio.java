package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.*;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.HistorialConsultas;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RespuestaDTO;
import co.edu.uniquindio.clinica.modelo.enums.EstadoPqr;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(MedicoDTO medicoDTO)throws Exception;

    int actualizarMedico(DetalleMedicoDTO detalleMedicoDTO)throws Exception;

    void eliminarMedico(int codigo)throws Exception;

    List<ItemMedicoDTO> listarMedicos()throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo)throws Exception;

    List<ItemPqrDTO> listarPQRS()throws Exception;

    DetallePqrDTO verDetallePQRS (int codigo) throws Exception;

    void responderPQRS(RespuestaDTO respuestaDTO)throws Exception;

    PqrDTOAdmin verDetallePQRS()throws Exception;

    List<ItemCitaAdminDTO> listarCitas()throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPqr estadoPQRS)throws Exception;

    boolean estaRepetidaCedula(int id);

    boolean estaRepetidoCorreo(String correo);

    public List<HistorialConsultas> verHistorialDeConsultas();

    public List<HistorialConsultas> verHistorialDeConsultasMedico(int codigoMedico);

}
