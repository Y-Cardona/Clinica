package co.edu.uniquindio.clinica.servicios.impl;

import co.edu.uniquindio.clinica.servicios.interfaces.ImagenServicio;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImagenServicioImpl implements ImagenServicio {

    private final Cloudinary cloudinary;

    public ImagenServicioImpl(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "doedtu0gg");
        config.put("api_key", "633968693687733");
        config.put("api_secret", "y-Vvylhfre2ltao1e6Xsvz3Zl7_Jg");
        cloudinary = new Cloudinary(config);
    }

    @Override
    public Map subirImagen(MultipartFile imagen) throws Exception {
        File file = convertir(imagen);
        return cloudinary.uploader().upload(file, ObjectUtils.asMap("folder",
                "clinica"));
    }

    @Override
    public Map eliminarImagen(String idImagen) throws Exception {
        return cloudinary.uploader().destroy(idImagen, ObjectUtils.emptyMap());
    }

    public File convertir(MultipartFile imagen) throws IOException {
        File file = File.createTempFile(imagen.getOriginalFilename(), null);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagen.getBytes());
        fos.close();
        return file;
    }
}