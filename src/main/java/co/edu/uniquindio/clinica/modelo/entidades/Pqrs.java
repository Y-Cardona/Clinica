package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.EstadoPQRS;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    private String motivo;

    @Column(nullable = false)
    private EstadoPQRS estado;

    @ManyToOne
    private Cita cita;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensaje;

}
