package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.dto.MensajeDTO;
import co.edu.uniquindio.clinica.dto.paciente.MedicosDisponiblesDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroCitaDTO;
import co.edu.uniquindio.clinica.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paciente")
@AllArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PostMapping("/registro")
    public ResponseEntity<MensajeDTO> crearPaciente(@Valid @RequestBody RegistroPacienteDTO registroPacienteDTO) {
        try {
            pacienteServicio.registrarse(registroPacienteDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                    false, "Paciente creado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeDTO(
                    true, e.getMessage()));
        }
    }

    @PostMapping("/cita")
    public ResponseEntity<MensajeDTO> agendarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO){
        try {
            pacienteServicio.agendarCita(registroCitaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MensajeDTO(
                    false, "Cita agendada correctamente"));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeDTO(
                    true, e.getMessage()));
        }
    }

    /*@GetMapping("/listaMedicosDisponibles")
    public ResponseEntity<MensajeDTO> medicosDisponibles(@Valid @RequestBody  MedicosDisponiblesDTO medicosDisponiblesDTO){
        System.out.println("pasa");
        try {
            List<MedicosDisponiblesDTO> medicoPostDTOList=pacienteServicio.mostrarMedicosDisponibles(medicosDisponiblesDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(
                    false, medicoPostDTOList ));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensajeDTO(
                    true, e.getMessage()));
        }
    }*/
}
