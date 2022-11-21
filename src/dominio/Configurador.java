package dominio;

public interface Configurador {
    public Boolean agregarUsuario(Long idUsuario, Long idAlarma, String codConfiguration) throws CodigoAlarmaIncorrectoException;

    public Boolean agregarSensor(Long idAlarma, String codconfiguration, Sensor sensor) throws CodigoAlarmaIncorrectoException, SensorDuplicadoException;

    public Boolean activarSensor(Long idSensor, Long idAlarma, String codconfiguration) throws CodigoAlarmaIncorrectoException;
}
