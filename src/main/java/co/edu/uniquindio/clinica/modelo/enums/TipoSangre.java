package co.edu.uniquindio.clinica.modelo.enums;

public enum TipoSangre {

    A_POSITIVO("A+"),
    A_NEGATIVO("A-"),
    B_POSITIVO("B+"),
    B_NEGATIVO("B-"),
    AB_POSITIVO("AB+"),
    AB_NEGATIVO("AB-"),
    O_POSITIVO("O+"),
    O_NEGATIVO("O-");

    private String nombre;

    TipoSangre(String nombre) {this.nombre = nombre;}
}
