package dominio;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PruebaAlarmas {

    @Test
    public void queSePuedaRegistrarUnaAlarmaEnLaCentral(){

        //preparacion
        Central central = new Central();
        Administrador usuario = new Usuario("juan", 123);
        List<Usuario> usuarios =  central.getUsuarios();
        usuarios.add((Usuario) usuario);

        Alarma alarma = new Alarma(1, "abc123", "abc124", "alarma");

        //ejecucion
        usuario.agregarAlarma(central ,alarma);

        //comprobacion
        Integer valorEsperado = 1;

        assertEquals(valorEsperado, (Integer) central.getAlarmas().size());
    };

    @Test
    public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws CodigoAlarmaIncorrectoException {
        //preparacion
        Central central = new Central();
        Administrador usuario = new Usuario("juan", 123);
        List<Usuario> usuarios =  central.getUsuarios();
        usuarios.add((Usuario) usuario);
        Alarma alarma = new Alarma(1, "abc123", "abc124", "alarma");
        List<Alarma> alarmas =  central.getAlarmas();
        alarmas.add(alarma);
        Usuario usuario1 = new Usuario("jorge", 124);

        //ejecucion
        usuario.agregarUsuarioAUnaAlarma(central, 123, 1, "abc124");

        //comprobacion
        Integer valorEsperado = 1;

        assertEquals(valorEsperado, (Integer) alarma.getListaUsuarios().size());
    };

    @Test (expected = CodigoAlarmaIncorrectoException.class)
    public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmaInvalidoSeLanceCodigoAlarmaIncorrectoException() throws CodigoAlarmaIncorrectoException{
        //preparacion
        Central central = new Central();
        Administrador usuario = new Usuario("juan", 123);
        List<Usuario> usuarios =  central.getUsuarios();
        usuarios.add((Usuario) usuario);
        Alarma alarma = new Alarma(1, "abc123", "abc124", "alarma");
        List<Alarma> alarmas =  central.getAlarmas();
        alarmas.add(alarma);
        Usuario usuario1 = new Usuario("jorge", 124);

        //ejecucion
        usuario.agregarUsuarioAUnaAlarma(central, 123, 1, "abc121");

        //comprobacion
        Integer valorEsperado = 1;

        assertEquals(valorEsperado, (Integer) alarma.getListaUsuarios().size());
    };

    @Test   (expected = SensorDuplicadoException.class)
    public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException() throws SensorDuplicadoException {
        Central central = new Central();
        Administrador usuario = new Usuario("juan", 123);
        List<Usuario> usuarios =  central.getUsuarios();
        usuarios.add((Usuario) usuario);
        Alarma alarma = new Alarma(1, "abc123", "abc124", "alarma");
        List<Alarma> alarmas =  central.getAlarmas();
        alarmas.add(alarma);
        Sensor sensor = new Sensor(1);
        Sensor sensor1 = new Sensor(1);

        usuario.agregarSensorAAlarma(central, 1,"abc124",sensor, 123 );
        usuario.agregarSensorAAlarma(central, 1,"abc124",sensor1, 123 );



    };

    @Test
    public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDuplicadoException {

        //preparacion
        Central central = new Central();
        Administrador usuario = new Usuario("juan", 123);
        List<Usuario> usuarios =  central.getUsuarios();
        Configurador configurador = new Usuario("Jorge", 321);
        usuarios.add((Usuario) usuario);
        Alarma alarma = new Alarma(1, "abc123", "abc124", "alarma");
        List<Alarma> alarmas =  central.getAlarmas();
        alarmas.add(alarma);
        Sensor sensor = new Sensor(1, true);
        Sensor sensor1 = new Sensor(2, false);

        usuario.agregarSensorAAlarma(central, 1,"abc124",sensor, 123 );
        usuario.agregarSensorAAlarma(central, 1,"abc124",sensor1, 123 );

        //ejecucion

        Boolean funcionó = usuario.activarDesactivarAlarma(central,1,"abc123", configurador);
        //comprobacion
        assertFalse(funcionó);
    };

    @Test
    public void queParaUnaAlarmaDeterminadaSePuedaObtenerUnaColeccionOrdenadaDeAcccionesDeTipoConfiguracionOdenadasPorIdDeAccion(){

    };
}
