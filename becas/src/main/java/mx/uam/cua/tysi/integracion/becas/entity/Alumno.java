package mx.uam.cua.tysi.integracion.becas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlumno;
    private String nombre;
    private String matricula;
    private String carrera;
    private Double promedio;

    public Alumno() {
    }

    public Alumno(Integer idAlumno, String nombre, String matricula, String carrera, Double promedio) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.matricula = matricula;
        this.carrera = carrera;
        this.promedio = promedio;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

}
