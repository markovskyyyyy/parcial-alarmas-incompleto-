package dominio;

import java.util.List;

public class Usuario implements Administrador, Activador, Configurador {
    private String name;
    private Integer id;

    public Usuario(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean activarDesactivarAlarma(Alarma alarma, String codigoActivacion) {
        return false;
    }

    @Override
    public Boolean agregarAlarma(Central central,Alarma alarma) {
        Boolean seAgregó;
        List<Alarma> alarmas = central.getAlarmas();
        seAgregó = alarmas.add(alarma);
        return seAgregó;
    }

    @Override
    public Boolean agregarUsuario(Central central, Usuario usuario) {
        Boolean seAgregó;
        List<Usuario> usuarios = central.getUsuarios();
        seAgregó = usuarios.add(usuario);
        return seAgregó;
    }

    @Override
    public void agregarUsuarioAUnaAlarma(Central central, Integer dniUsuarioAAgregar, Integer idAlarma, String codigoConfiguracionAlarma) throws CodigoAlarmaIncorrectoException{
            Usuario usuario = central.buscarUsuario(dniUsuarioAAgregar);
            Alarma alarma = central.buscarAlarma(idAlarma);
            List<Usuario> usuarios = alarma.getListaUsuarios();

            if (alarma.getCodConfiguracion().equals(codigoConfiguracionAlarma)){
                usuarios.add(usuario);
            }else {
                throw new CodigoAlarmaIncorrectoException("codigo incorrecto");
            }
    }

    @Override
    public Boolean agregarSensorAAlarma(Central central, Integer idAlarma, String codigoConfiguracionAlarma, Sensor sensor, Integer idUsuarioConfigurador) throws SensorDuplicadoException{

        Boolean seAgregó = false;
        Boolean sensorDuplicado = false;
        Alarma alarma = central.buscarAlarma(idAlarma);
        Usuario usuario = central.buscarUsuario(idUsuarioConfigurador);
        List<Sensor> sensores = alarma.getListaDeSensores();

        for (Sensor sensorDeLaLista : sensores) {
            if (sensor.getId().equals(sensorDeLaLista.getId())){
                throw new SensorDuplicadoException("Sensor duplicado");
            }
        }
        if (alarma.getCodConfiguracion().equals(codigoConfiguracionAlarma)){
            seAgregó = sensores.add(sensor);
        }

        return seAgregó;

    }

    @Override
    public Boolean activarSensorDeAlarma(Central central, Integer idSensor, Integer idAlarma, String codigoActivacionAlarma) {
        Boolean seActivó = false;
        Alarma alarma = central.buscarAlarma(idAlarma);
        Sensor sensor = alarma.buscarSensor(idSensor);

        if (alarma.getCodActivacion().equals(codigoActivacionAlarma)){
            sensor.setEstado(true);
            seActivó = true;
        }
        return seActivó;
    }

    @Override
    public Boolean activarDesactivarAlarma(Central central, Integer idAlarma, String codigoActivacionAlarma, Configurador usuario) {
        Boolean seActivó = false;
        Alarma alarma = central.buscarAlarma(idAlarma);
        Integer contador = 0;

        for (Sensor sensor : alarma.getListaDeSensores()) {
            if (sensor.getEstado() == true) {
                contador++;
            }
        }

        if (alarma.getCodActivacion().equals(codigoActivacionAlarma) && usuario instanceof Configurador && contador == alarma.getListaDeSensores().size()) {
            if (alarma.getEstado()== false){
                alarma.setEstado(true);
                seActivó = true;
            }else {
                alarma.setEstado(false);
                seActivó = true;
            }

        }
        return seActivó;
    }

    @Override
    public Boolean agregarUsuario(Long idUsuario, Long idAlarma, String codConfiguration) throws CodigoAlarmaIncorrectoException {
        return null;
    }

    @Override
    public Boolean agregarSensor(Long idAlarma, String codconfiguration, Sensor sensor) throws CodigoAlarmaIncorrectoException, SensorDuplicadoException {
        return null;
    }

    @Override
    public Boolean activarSensor(Long idSensor, Long idAlarma, String codconfiguration) throws CodigoAlarmaIncorrectoException {
        return null;
    }
}
