package co.edu.uniquindio.clinica.servicios.interfaces;

import co.edu.uniquindio.clinica.dto.otro.LoginDTO;
import co.edu.uniquindio.clinica.dto.otro.TokenDTO;


public interface AutenticacionServicio {
    TokenDTO login(LoginDTO loginDTO) throws Exception;
}
