package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.dto.admin.ItemCitaAdminDTO;
import co.edu.uniquindio.clinica.dto.admin.DetalleMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.HistorialConsultas;
import co.edu.uniquindio.clinica.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.clinica.dto.admin.RespuestaDTO;
import co.edu.uniquindio.clinica.dto.otro.DetallePQRSDTO;
import co.edu.uniquindio.clinica.dto.otro.EstadoDTO;
import co.edu.uniquindio.clinica.dto.otro.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.otro.MedicoDTO;
import co.edu.uniquindio.clinica.dto.paciente.ItemPacienteDTO;
import co.edu.uniquindio.clinica.excepciones.Excepciones;
import co.edu.uniquindio.clinica.modelo.entidades.*;
import co.edu.uniquindio.clinica.repositorios.*;
import co.edu.uniquindio.clinica.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicioImpl implements AdministradorServicio {

    private final MedicoRepo medicoRepo;
    private final PqrsRepo pqrsRepo;
    private final CitaRepo citaRepo;
    private final MensajeRepo mensajeRepo;
    private final HorarioRepo horarioRepo;
    private final PacienteRepo pacienteRepo;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public int crearMedico(MedicoDTO medicoDTO) throws Exception {

        if (estaRepetidaCedula_2(medicoDTO.cedula())) {
            Medico medicoBuscado = medicoRepo.findByCedula(medicoDTO.cedula()).get();
            if(!medicoBuscado.isEstado()) {
                medicoBuscado.setEstado(true);
                medicoBuscado.setCodigo(medicoBuscado.getCodigo());
                medicoBuscado.setCedula(medicoBuscado.getCedula());

                Optional<Horario> horarioBuscado = horarioRepo.findByMedicoId(medicoBuscado.getCodigo());
                if (horarioBuscado.isEmpty()) {
                    Horario horario = new Horario();
                    horario.setMedico(medicoBuscado);
                    horario.setHoraInicio(medicoDTO.horaInicioJornada());
                    horario.setHoraFin(medicoDTO.horaFinJornada());
                    horarioRepo.save(horario);
                } else {
                    horarioBuscado.get().setMedico(medicoBuscado);
                    horarioBuscado.get().setHoraInicio(medicoDTO.horaInicioJornada());
                    horarioBuscado.get().setHoraFin(medicoDTO.horaFinJornada());
                    horarioRepo.save(horarioBuscado.get());
                }

                medicoRepo.save(medicoBuscado);
                return medicoBuscado.getCodigo();

            }
            throw new Excepciones("La cédula ya se encuentra registrado");
        }

        if (estaRepetidoCorreo(medicoDTO.correo())) {
            throw new Excepciones("El correo ya se encuentra registrado");
        }


        Medico medico = new Medico();
        medico.setCedula(medicoDTO.cedula());
        medico.setTelefono(medicoDTO.telefono());
        medico.setNombre(medicoDTO.nombre());
        medico.setEspecialidad(medicoDTO.especialidad());
        medico.setCiudad(medicoDTO.ciudad());
        String passwordEncriptada = passwordEncoder.encode(medicoDTO.password());
        medico.setPassword(passwordEncriptada);
        medico.setFoto(medicoDTO.urlFoto());
        medico.setCorreo(medicoDTO.correo());
        medico.setEstado(true);

        Medico medicoNuevo = medicoRepo.save(medico);

        Optional<Horario> horarioBuscado = horarioRepo.findByMedicoId(medicoNuevo.getCodigo());
        if(horarioBuscado.isEmpty()){
            Horario horario=new Horario();
            horario.setMedico(medicoNuevo);
            horario.setHoraInicio(medicoDTO.horaInicioJornada());
            horario.setHoraFin(medicoDTO.horaFinJornada());
            horarioRepo.save(horario);
        }else{
            horarioBuscado.get().setMedico(medicoNuevo);
            horarioBuscado.get().setHoraInicio(medicoDTO.horaInicioJornada());
            horarioBuscado.get().setHoraFin(medicoDTO.horaFinJornada());
            horarioRepo.save(horarioBuscado.get());
        }
        return medicoNuevo.getCodigo();
    }

    @Override
    public int actualizarMedico(DetalleMedicoDTO detalleMedicoDTO) throws Exception {
        Optional<Medico> buscado = medicoRepo.findByCedula(detalleMedicoDTO.cedula());
        Optional<Horario> horarioBuscado = horarioRepo.findByMedicoId(buscado.get().getCodigo());

        if (buscado.isEmpty()) {
            throw new Exception("El código " + detalleMedicoDTO.cedula() + " no existe");
        }

        if (!buscado.get().isEstado()) {
            throw new Exception("El cóodigo " + detalleMedicoDTO.cedula() + " no existe");
        }

        Medico medico = buscado.get();
        medico.setCedula(detalleMedicoDTO.cedula());
        medico.setTelefono(detalleMedicoDTO.telefono());
        medico.setNombre(detalleMedicoDTO.nombre());
        medico.setEspecialidad(detalleMedicoDTO.especialidad());
        medico.setCiudad(detalleMedicoDTO.ciudad());
        medico.setCorreo(detalleMedicoDTO.correo());
        medico.setFoto(detalleMedicoDTO.urlFoto());
        horarioBuscado.get().setHoraInicio(detalleMedicoDTO.horaInicio());
        horarioBuscado.get().setHoraFin(detalleMedicoDTO.horaFin());

        Medico medicoEditado = medicoRepo.save(medico);
        horarioRepo.save(horarioBuscado.get());

        // emailServicio.enviarCorreo(new EmailDTO("Asunto", "Cuerpo mensaje", "Correo destino"));

        return medicoEditado.getCodigo();

    }

    @Override
    public DetalleMedicoDTO obtenerMedico(int codigo) throws Exception {
        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if (buscado.isEmpty()) {
            throw new Exception("El código " + codigo + " no existe");
        }
        if (!buscado.get().isEstado()) {
            throw new Exception("El cóodigo " + codigo + " no existe");
        }
        Medico obtenido = buscado.get();

        DetalleMedicoDTO detalleMedicoDTO = new DetalleMedicoDTO(

                obtenido.getNombre(),
                obtenido.getCedula(),
                obtenido.getCiudad(),
                obtenido.getEspecialidad(),
                obtenido.getTelefono(),
                obtenido.getCorreo(),
                obtenido.getFoto(),
                obtenido.getHorario().getHoraInicio(),
                obtenido.getHorario().getHoraFin()
        );

        return detalleMedicoDTO;

    }
    @Transactional
    @Override
    public void eliminarMedico(int codigo) throws Exception {

        Optional<Medico> buscado = medicoRepo.findById(codigo);

        if (buscado.isEmpty()) {
            throw new Exception("El cóodigo " + codigo + " no existe");
        }

        //medicoRepo.delete( buscado.get() );
        Medico obtenido = buscado.get();
        if (!obtenido.isEstado()) {
            throw new Exception("El cóodigo " + codigo + " no existe");
        }
        obtenido.setEstado(false);
        obtenido.setCorreo(Integer.toString(codigo) + "@inexistente.com");
        medicoRepo.save(obtenido);
        horarioRepo.deleteHorarioByMedico_Codigo(obtenido.getCodigo());


    }

    @Override
    public List<ItemMedicoDTO> listarMedicos() throws Exception {

        List<Medico> medicos = medicoRepo.findAll();
        List<ItemMedicoDTO> respuesta = new ArrayList<>();

        for (Medico medico : medicos) {
            if (medico.isEstado()) {
                respuesta.add(new ItemMedicoDTO(
                        medico.getCedula(),
                        medico.getNombre(),
                        medico.getFoto(),
                        medico.getEspecialidad(),
                        medico.getHorario().getHoraInicio(),
                        medico.getHorario().getHoraFin()));
            }
        }
        return respuesta;
    }

    @Override
    public void responderPQRS(RespuestaDTO respuestaDTO) throws Exception {

        Mensaje mensajeNuevo = new Mensaje();
        Optional<Mensaje> mensajeAnterior = mensajeRepo.findById(respuestaDTO.codigoMensaje());

        List<Mensaje> todos = mensajeRepo.findAll();

        System.out.println(todos.get(0).getCodigo());

        if (mensajeAnterior.isEmpty()){
            throw new Excepciones("No se encontró el mensaje anterior");
        }
        System.out.println("pasa" + mensajeAnterior.get().getCodigo());
        mensajeNuevo.setFecha(LocalDate.now());
        mensajeNuevo.setContenido(respuestaDTO.mensaje());
        mensajeNuevo.setMensaje(mensajeAnterior.get());
        mensajeNuevo.setPqrs(mensajeAnterior.get().getPqrs());

        mensajeRepo.save(mensajeNuevo);
    }

    @Override
    public List<ItemPQRSDTO> listarPQRS() throws Exception {

        List<Pqrs> listaPqrs = pqrsRepo.findAll(); //select * from pqrs
        List<ItemPQRSDTO> respuesta = new ArrayList<>();

        for (Pqrs p : listaPqrs) {
            respuesta.add(new ItemPQRSDTO(
                    p.getCodigo(),
                    p.getEstado(),
                    p.getMotivo(),
                    p.getFechaCreacion(),
                    p.getCita().getPaciente().getNombre(),
                    p.getCita().getMedico().getNombre()
            ));
        }

        return respuesta;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigo) throws Exception {
        Optional<Pqrs> opcional = pqrsRepo.findById(codigo);

        if (opcional.isEmpty()) {
            throw new Exception("El código" + codigo + " no está asociado a ningún PQRS");
        }

        Pqrs pqrs = opcional.get();

        return new
                DetallePQRSDTO(
                pqrs.getCodigo(),
                pqrs.getEstado(),
                pqrs.getMotivo(),
                pqrs.getCita().getPaciente().getNombre(),
                pqrs.getCita().getMedico().getNombre(),
                pqrs.getCita().getMedico().getEspecialidad(),
                pqrs.getFechaCreacion(),
                new ArrayList<>() //Falta meter los mensajes del pqrs
        );
    }

    @Override
    public List<ItemCitaAdminDTO> listarCitas() throws Exception {
        List<Cita> listaCitas = citaRepo.findAll();
        List<ItemCitaAdminDTO> respuesta = new ArrayList<>();

        for (Cita c : listaCitas
        ) {
            respuesta.add(new ItemCitaAdminDTO(
                    c.getCodigo(),
                    c.getPaciente().getCedula(),
                    c.getPaciente().getNombre(),
                    c.getMedico().getNombre(),
                    c.getMedico().getEspecialidad(),
                    c.getEstadoCita(),
                    c.getFechaCreacion()
            ));
        }
        return respuesta;
    }

    @Override
    public void cambiarEstadoPQRS( EstadoDTO estadoDTO) throws Exception {

        Optional<Pqrs> opcional = pqrsRepo.findById(estadoDTO.codigoPQRS());

        if (opcional.isEmpty()) {
            throw new Exception("El código" + estadoDTO.codigoPQRS() + " no está asociado a ningún PQRS");
        }
        Pqrs pqrs = opcional.get();
        pqrs.setEstado(estadoDTO.estadoPQRS());
        pqrsRepo.save(pqrs);

    }

    @Override
    public List<ItemPacienteDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepo.findAll();
        List<ItemPacienteDTO> repuesta = new ArrayList<>();
//Hacemos un mapeo de cada uno de los objetos de tipo Paciente a objetos de tipo ItemPacienteDTO
        for (Paciente paciente : pacientes) {
            repuesta.add(new ItemPacienteDTO(paciente.getCedula(),
                    paciente.getNombre(), paciente.getCiudad()));
        }
        return repuesta;
    }

    public List<HistorialConsultas> verHistorialDeConsultas() {
        List<Cita> citas = citaRepo.listarCitasFinalizadas();
        List<HistorialConsultas> historialConsultas = new ArrayList<>();
        for (Cita cita : citas) {
            historialConsultas.add(new HistorialConsultas(
                    cita.getFechaCita(),
                    cita.getMedico().getCedula(),
                    cita.getMedico().getNombre(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre()));
        }
        return historialConsultas;
    }

    public List<HistorialConsultas> verHistorialDeConsultasMedico(int codigoMedico) {
        List<Cita> citas = citaRepo.listarCitasFinalizadasPorMedico(codigoMedico);
        List<HistorialConsultas> historialConsultas = new ArrayList<>();
        for (Cita cita : citas) {
            historialConsultas.add(new HistorialConsultas(
                    cita.getFechaCita(),
                    cita.getMedico().getCedula(),
                    cita.getMedico().getNombre(),
                    cita.getPaciente().getCedula(),
                    cita.getPaciente().getNombre()));
        }
        return historialConsultas;
    }

    public boolean estaRepetidaCedula(String cedula) {
        Optional<Medico> medicoBuscado = medicoRepo.findByCedula(cedula);
        if (!medicoBuscado.isEmpty()) {
            if (!medicoBuscado.get().isEstado()) {
                return false;
            }
            return true;
        }
        return medicoRepo.existsByCedula(cedula);
    }

    public boolean estaRepetidaCedula_2(String cedula) {
        Optional<Medico> medicoBuscado = medicoRepo.findByCedula(cedula);
        if (!medicoBuscado.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean estaRepetidoCorreo(String correo) {
        Optional<Medico> medico = medicoRepo.findByCorreo(correo);

        return medico.isPresent();
    }
}
