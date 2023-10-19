package co.edu.uniquindio.clinica.repositorios;
import co.edu.uniquindio.clinica.modelo.entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, Integer>{


}
