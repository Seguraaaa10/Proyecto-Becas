package mx.uam.cua.tysi.integracion.becas.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SolicitudBeca")
public class SolicitudBeca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitudBeca;

    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;

    private String estado;

    // RELACIÓN CON ALUMNO
    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    // RELACIÓN CON BECA UAM
    @Column(nullable = true)
    private Long idBecaUAM;

    // RELACIÓN CON BECA EXTERIOR
    @Column(nullable = true)
    private Long idBecaExterior;

    public Long getIdSolicitudBeca() {
        return idSolicitudBeca;
    }

    public void setIdSolicitudBeca(Long idSolicitudBeca) {
        this.idSolicitudBeca = idSolicitudBeca;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Long getIdBecaUAM() {
        return idBecaUAM;
    }

    public void setIdBecaUAM(Long idBecaUAM) {
        this.idBecaUAM = idBecaUAM;
    }

    public Long getIdBecaExterior() {
        return idBecaExterior;
    }

    public void setIdBecaExterior(Long idBecaExterior) {
        this.idBecaExterior = idBecaExterior;
    }
}