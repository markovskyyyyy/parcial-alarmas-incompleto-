package dominio;

public interface Administrador {
    public Boolean agregarAlarma(Central central,Alarma alarma);


    public Boolean agregarUsuario(Central central, Usuario usuario);

    public void agregarUsuarioAUnaAlarma(Central central,Integer dniUsuarioAAgregar, Integer
            idAlarma, String codigoConfiguracionAlarma) throws CodigoAlarmaIncorrectoException;

    public Boolean agregarSensorAAlarma(Central central, Integer idAlarma, String
            codigoConfiguracionAlarma, Sensor sensor,Integer idUsuarioConfigurador) throws SensorDuplicadoException;



    public Boolean activarSensorDeAlarma(Central central,Integer idSensor, Integer idAlarma,
                                         String codigoActivacionAlarma);

    public Boolean activarDesactivarAlarma(Central central,Integer idAlarma, String
            codigoActivacionAlarma, Configurador usuario);



}
