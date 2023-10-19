package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.LoginDTO;
import co.edu.uniquindio.clinica.dto.TokenDTO;


public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
