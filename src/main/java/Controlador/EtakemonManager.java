package Controlador;

import Modelo.Objetos;
import Modelo.Usuarios;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B on 19/4/17.
 */
public interface EtakemonManager {
    List<Usuarios> ListaUsuarios();
    void  AnyadirUsuario(Usuarios usuarioxraanyadir);
    void ActualizarUsuario(String nombre,String nuevonombre);
    String infoUsuario(String nombre);
    List<Objetos> ObjetosUsuarios(Usuarios nombre);
    void  AnyadirObjetoaUsuario(Usuarios usuario, Objetos objeto);



}
