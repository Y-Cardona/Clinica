package co.edu.uniquindio.clinica.modelo.enums;

public enum EstadoPqr {

    NUEVO("Nuevo"),
    EN_PROCESO("En proceso"),
    RESUELTO("Resuelto"),
    ARCHIVADO("Archivado");

    private String nombre;

    EstadoPqr(String nombre) {this.nombre = nombre;}
}
