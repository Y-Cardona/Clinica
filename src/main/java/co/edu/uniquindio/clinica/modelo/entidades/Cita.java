package co.edu.uniquindio.clinica.modelo.entidades;

import co.edu.uniquindio.clinica.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, unique = true)
    private LocalDateTime fechaCita;

    @Column(nullable = false)
    private String motivo;

    @Column(nullable = false, updatable = true)
    private EstadoCita estadoCita;

    @ManyToOne
    private Medico medico;

    @ManyToOne
    private Paciente paciente;

    @OneToOne(mappedBy = "cita")
    private Atencion atencion;

    @OneToOne(mappedBy = "citaAsignada")
    private Atencion atencionAsignada;

    @OneToMany(mappedBy = "cita")
    private List<Pqr> pqrList;

}
