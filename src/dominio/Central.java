package dominio;

import java.util.ArrayList;
import java.util.List;

public class Central {
    private List<Alarma> alarmas;
    private List<Usuario> usuarios;

    public Central() {
        this.alarmas = new ArrayList<Alarma>();
        this.usuarios = new ArrayList<Usuario>();
    }

    public List<Alarma> getAlarmas() {
        return alarmas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Usuario buscarUsuario(Integer usuarioId) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios){
            if (usuario.getId().equals(usuarioId)){
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }

    public Alarma buscarAlarma(Integer alarmaId) {
        Alarma alarmaEncontrado = null;
        for (Alarma alarma : alarmas){
            if (alarma.getId().equals(alarmaId)){
                alarmaEncontrado = alarma;
            }
        }
        return alarmaEncontrado;
    }
}
