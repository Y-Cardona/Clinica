package co.edu.uniquindio.clinica.repositorios;

import co.edu.uniquindio.clinica.modelo.entidades.Pqr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PqrsRepo extends JpaRepository<Pqr, Integer> {

    @Query("SELECT pq FROM Pqr pq JOIN pq.cita c WHERE c.paciente.cedula = :codigoPaciente")
    List<Pqr> findByCodigoPaciente(@Param("codigoPaciente") int codigoPaciente);
}
