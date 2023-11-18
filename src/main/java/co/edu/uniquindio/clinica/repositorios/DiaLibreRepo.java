package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.DiaLibre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiaLibreRepo extends JpaRepository<DiaLibre, Integer> {

    @Query("SELECT d from DiaLibre d where d.medico.codigo=:codigoMedico and d.dia > current_date ")
    Optional<DiaLibre> findByMedico(int codigoMedico);
}