package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.dto.otro.HorarioDTO;
import co.edu.uniquindio.clinica.dto.otro.MedicoPostDTO;
import co.edu.uniquindio.clinica.modelo.entidades.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HorarioRepo extends JpaRepository<Horario, Integer> {


    void deleteByMedicoId(@Param("codigoMedico") int codigoMedico);

    @Query("select h FROM Horario h WHERE h.medico.codigo = :codigoMedico")
    Optional<Horario> findByMedicoId(@Param("codigoMedico") int codigoMedico);
}
