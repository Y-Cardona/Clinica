package co.edu.uniquindio.clinica.modelo.enums;

public enum Especialidad {

    CIRUGIA_GENERAL("Cirugía General"),
    MEDICINA_INTERNA("Medicina Interna"),
    CARDIOLOGIA("Cardiología"),
    NEUROLOGIA("Neurología"),
    RADIOLOGIA("Radiología"),
    ORTOPEDIA("Ortopedia"),
    ANESTESIOLOGIA("Anestesiología"),
    PSIQUIATRIA("Psiquiatría"),
    OFTALMOLOGIA("Oftamología"),
    DERMATOLOGIA("DERMATOLOGÍA"),
    GINECOLOGIA("GINECOLOGÍA"),
    PEDIATRIA("PEDIATRÍA"),
    UROLOGIA("UROLOGÍA"),
    ONCOLOGIA("ONCOLOGÍA"),
    ENDOCRINOLOGIA("eDOCRINOLOGÍA");

    private String nombre;

    Especialidad(String nombre) {this.nombre = nombre;}
}
