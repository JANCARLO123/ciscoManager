package com.sonda.cisco.model;

import javax.persistence.*;

/**
 * Created by pedro.merino on 17/05/2016.
 */
@Entity
@Table(name = "Clima")
public class Clima {

    @Id
    private long id;

    @Column(name = "temperatura", length = 5,nullable = false)
    private String temperatura;
    @Column(name = "icon", length = 80, nullable = false)
    private String icon;

    @Column(name = "ciudad", length = 30, nullable = false)
    private String ciudad;

    @Column(name = "descripcion", length = 30, nullable = false)
    private String descripcion;

    @Column(name = "sensacion", length = 30, nullable = false)
    private String sensacion;

    @Column(name = "humedad", length = 30, nullable = false)
    private String humedad;



    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSensacion() {
        return sensacion;
    }

    public void setSensacion(String sensacion) {
        this.sensacion = sensacion;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }
}
