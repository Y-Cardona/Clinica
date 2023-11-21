package co.edu.uniquindio.clinica.Controladores;

import co.edu.uniquindio.clinica.dto.otro.MensajeDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.CloudinaryServicio;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/imagenes")
@RequiredArgsConstructor
@AllArgsConstructor
public class ImagenesController {
    public List<String> url;
    private CloudinaryServicio cloudinaryServicio;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws Exception {

        File file=cloudinaryServicio.convertir(multipartFile);
        if(file == null){
            return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO( false, "error al subir la imagen") );
        }
        Map datos = cloudinaryServicio.subirImagen(file,"s");
        return ResponseEntity.status(HttpStatus.CREATED).body( new MensajeDTO( false, datos ) );

    }

}