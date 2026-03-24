package mx.uam.cua.tysi.integracion.becas.dto;

import java.util.Date;

public class SolicitudBecaDTO {

    private Long id;
    private Date fechaSolicitud;
    private String estado;
    private Long idAlumno;
    private Long idBecaUAM;
    private Long idBecaExterior;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
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