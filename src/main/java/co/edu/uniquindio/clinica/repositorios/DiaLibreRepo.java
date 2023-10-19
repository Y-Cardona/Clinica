package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.DiaLibre;
import co.edu.uniquindio.clinica.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DiaLibreRepo extends JpaRepository<DiaLibre, Integer> {

    @Query("SELECT d from DiaLibre d where d.medico.cedula=:codigoMedico and d.dia > current_date ")
    Optional<DiaLibre> findByMedico(int codigoMedico);
}
