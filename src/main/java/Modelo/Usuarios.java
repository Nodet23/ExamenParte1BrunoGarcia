package Modelo;

import com.sun.prism.Texture;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by B on 19/4/17.
 */
public class Usuarios {
    private String nombre;
    ArrayList<Objetos> Lobjetos = new ArrayList<Objetos>();
    public Usuarios(String name){
        this.nombre= name;
    }

    /*List<Usuarios> ListaUsuarios();
    void  AnyadirObjeto(Usuarios usuarioxraanyadir);
    void ActualizarUsuario(String nombre,String nuevonombre);
    String infoUsuario(String nombre);
    List<Objetos> ObjetosUsuarios(Usuarios nombre);
    void  AnyadirObjetoaUsuario(Usuarios usuario, Objetos objeto);*/

    public void AnyadirObjeto(Objetos objetoxraanyadir) {
        Lobjetos.add(objetoxraanyadir);
    }

    public List<Objetos> devolverListaUsuarios(){
        return this.Lobjetos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int numeroObjetos(){return Lobjetos.size();}

    public Usuarios() {
    }
}
