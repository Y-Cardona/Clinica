package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.Semestre;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Aprendiz extends Usuario implements Serializable {

    @Column(nullable = false)
    private Semestre semestreActual;
}