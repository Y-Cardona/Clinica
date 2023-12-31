package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.dto.otro.MensajeDTO;
import co.edu.uniquindio.clinica.modelo.enums.Ciudad;
import co.edu.uniquindio.clinica.modelo.enums.Eps;
import co.edu.uniquindio.clinica.modelo.enums.Especialidad;
import co.edu.uniquindio.clinica.modelo.enums.TipoSangre;
import co.edu.uniquindio.clinica.servicios.interfaces.ClinicaServicio;
import co.edu.uniquindio.clinica.servicios.interfaces.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clinica")
@RequiredArgsConstructor
public class ClinicaController {
    private final ClinicaServicio clinicaServicio;


    private final PacienteServicio pacienteServicio;
    @GetMapping("/ciudades")
    public ResponseEntity<MensajeDTO<List<Ciudad>>> listarCiudades(){

        List<Ciudad> ciudades = clinicaServicio.listarCiudades();

        return ResponseEntity.ok().body(new MensajeDTO<>(false, ciudades));
    }

    @GetMapping("/eps")
    public ResponseEntity<MensajeDTO<List<Eps>>> listarEps(){

        List<Eps> eps = clinicaServicio.listarEps();

        return ResponseEntity.ok().body(new MensajeDTO<>(false, eps));
    }

    @GetMapping("/tipo-sangre")
    public ResponseEntity<MensajeDTO<List<TipoSangre>>> listarTipoSangre(){

        List<TipoSangre> tipoSangre = clinicaServicio.listarTipoSangre();

        return ResponseEntity.ok().body(new MensajeDTO<>(false, tipoSangre));
    }

    @GetMapping ("/lista-especialidades")
    public ResponseEntity<MensajeDTO<List<Especialidad>>> listarEspecialidades(){

        List<Especialidad> especialidades = clinicaServicio.listarEspecialidades();

        return ResponseEntity.ok().body(new MensajeDTO<>(false, especialidades));
    }

    @GetMapping
    public ResponseEntity<MensajeDTO<String>> enviarLinkRecuperacion(@RequestParam String correo) throws Exception{
        pacienteServicio.enviarLinkRecuperacion(correo);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Se ha enviado un link a su correo electrónico para recuperar su contraseña") );

    }


}
