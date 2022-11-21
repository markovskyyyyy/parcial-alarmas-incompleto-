package dominio;

import java.time.LocalDate;

public class Accion {
    private Long id;
    private Alarma alarma;
    private Usuario usuario;
    private LocalDate fecha;
    private TIPO_OPERACION tipoOperacion;
}
