package co.edu.uniquindio.clinica.modelo.entidades;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Admin extends Cuenta implements Serializable {

}
