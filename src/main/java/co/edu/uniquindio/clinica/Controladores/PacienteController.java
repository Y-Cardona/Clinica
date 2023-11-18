package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.dto.otro.ItemPQRSDTO;
import co.edu.uniquindio.clinica.dto.otro.MensajeDTO;
import co.edu.uniquindio.clinica.dto.paciente.*;
import co.edu.uniquindio.clinica.excepciones.Excepciones;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "bearerAuth")
@RequestMapping("api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PutMapping
    public ResponseEntity<MensajeDTO<String>> editarPerfil(@Valid @RequestBody DetallePacienteDTO detallePacienteDTO) throws Exception {
        pacienteServicio.editarPerfil(detallePacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente editado correctamente") );

    }

    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<MensajeDTO<String>> eliminarCuenta(@PathVariable int codigo) throws
            Exception{
        pacienteServicio.eliminarCuenta(codigo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente eliminado correctamete")
        );
    }

    @GetMapping
    public ResponseEntity<MensajeDTO<String>> enviarLinkRecuperacion(@RequestParam String correo) throws Exception{
        pacienteServicio.enviarLinkRecuperacion(correo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se ha enviado un link a su correo electrónico para recuperar su contraseña") );

    }

    @GetMapping("/listaMedicosDisponibles")
    public ResponseEntity<MensajeDTO<List<MedicosDisponiblesGetDTO>>> medicosDisponibles(@Valid @RequestBody MedicosDisponiblesDTO medicosDisponiblesDTO) throws Excepciones {
        List<MedicosDisponiblesGetDTO> medicosDisponiblesGetDTOS = pacienteServicio.mostrarMedicosDisponibles(medicosDisponiblesDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, medicosDisponiblesGetDTOS));
    }

    @PostMapping("/cita")
    public int agendarCita(@Valid @RequestBody RegistroCitaDTO registroCitaDTO) throws Exception{
        return  pacienteServicio.agendarCita(registroCitaDTO);
    }

    @PostMapping("/pqrs")
    public void crearPQRS(@Valid @RequestBody RegistroPQRSDTO registroPQRSDTO) throws Exception{
        pacienteServicio.crearPQRS(registroPQRSDTO);
    }

    @Operation(summary = "Detalle paciente", description = "Permite acceder a todos los atributos del paciente dado su código")
    @GetMapping("/detalle/{codigo}")
    public DetallePacienteDTO verDetallePaciente(@PathVariable int codigo) throws Exception{
        return pacienteServicio.verDetallePaciente(codigo);
    }
    @GetMapping("/listar-pqrs/{codigo}")
    public List<ItemPQRSDTO> listarPQRSPaciente(@PathVariable int codigo) throws Exception{
        return pacienteServicio.listarPQRSPaciente(codigo);
    }

}