package mx.uam.cua.tysi.integracion.becas.entity;

import jakarta.persistence.*;

@Entity
@Table(name="becas_externas")
public class BecaExterna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_becas_externas")
    private Long idBecasExternas;

    private String nombre;
    private String tipoBeca;

    @Column(name = "monto_total")
    private float montoTotal;

    private float mensualidad;

    @Column(name = "duracion_meses")
    private int duracionMeses;

    @Column(name = "estado_convocatoria")
    private String estadoConvocatoria;

    private String periodicidad;

    public Long getIdBecasExternas() {
        return idBecasExternas;
    }

    public void setIdBecasExternas(Long idBecasExternas) {
        this.idBecasExternas = idBecasExternas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoBeca() {
        return tipoBeca;
    }

    public void setTipoBeca(String tipoBeca) {
        this.tipoBeca = tipoBeca;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public float getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(float mensualidad) {
        this.mensualidad = mensualidad;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public void setDuracionMeses(int duracionMeses) {
        this.duracionMeses = duracionMeses;
    }

    public String getEstadoConvocatoria() {
        return estadoConvocatoria;
    }

    public void setEstadoConvocatoria(String estadoConvocatoria) {
        this.estadoConvocatoria = estadoConvocatoria;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }
}