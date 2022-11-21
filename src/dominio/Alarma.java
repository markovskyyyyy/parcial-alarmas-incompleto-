package dominio;

import dominio.Accion;
import dominio.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Alarma {
    private Integer id;
    private String codActivacion;
    private String codConfiguracion;
    private String nombre;
    private Boolean estado;
    private List<Usuario> listaUsuarios;
    private List<Accion> listaDeAcciones;
    private List<Sensor> listaDeSensores;

    public Alarma(Integer id, String codActivacion, String codConfiguracion, String nombre) {
        this.id = id;
        this.codActivacion = codActivacion;
        this.codConfiguracion = codConfiguracion;
        this.nombre = nombre;
        this.estado = false;
        this.listaUsuarios = new ArrayList<>();
        this.listaDeAcciones = new ArrayList<>();
        this.listaDeSensores = new ArrayList<>();
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Sensor buscarSensor(Integer idSensor){
        Sensor sensorEncontrado = null;
        for (Sensor sensor: listaDeSensores) {
            if (sensor.getId().equals(idSensor)){
                sensorEncontrado = sensor;
            }
        }
        return sensorEncontrado;
    }

    public List<Sensor> getListaDeSensores() {
        return listaDeSensores;
    }

    public Integer getId() {
        return id;
    }

    public String getCodActivacion() {
        return codActivacion;
    }

    public String getCodConfiguracion() {
        return codConfiguracion;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Accion> getListaDeAcciones() {
        return listaDeAcciones;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodActivacion(String codActivacion) {
        this.codActivacion = codActivacion;
    }

    public void setCodConfiguracion(String codConfiguracion) {
        this.codConfiguracion = codConfiguracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setListaDeAcciones(List<Accion> listaDeAcciones) {
        this.listaDeAcciones = listaDeAcciones;
    }
}
