package dominio;

public class Sensor {
    private Integer id;
    private Boolean estado;

    public Sensor(Integer id) {
        this.id = id;
    }

    public Sensor(int id, boolean estado) {
        this.id = id;
        this.setEstado(estado);
    }

    public Integer getId() {
        return id;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
