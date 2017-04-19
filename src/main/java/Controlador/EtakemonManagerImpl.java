package Controlador;
import Modelo.Objetos;
import Modelo.Usuarios;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by BrunoGarcia on 19/4/17.
 */
public class EtakemonManagerImpl implements EtakemonManager{

private static EtakemonManagerImpl instance;
private HashMap<String, Usuarios> HashMapUsuarios;
final static Logger logger = Logger.getLogger(EtakemonManagerImpl.class);

private EtakemonManagerImpl(){
    HashMapUsuarios = new HashMap<String, Usuarios>();
    logger.info("se ha creado correctamente la lista de usuarios");
}

public static EtakemonManagerImpl getInstance(){
    if (instance==null) instance= new EtakemonManagerImpl();
    return instance;
}

public void AnyadirUsuario(Usuarios usuarioxraanyadir) {
    String nombre = usuarioxraanyadir.getNombre();
    HashMapUsuarios.put(nombre, usuarioxraanyadir);
    logger.info("se ha anyadido"+nombre);

}
    public void  AnyadirObjetoaUsuario(Usuarios usuario, Objetos objeto){
    Usuarios usuariodummy = HashMapUsuarios.get(usuario.getNombre());
    usuariodummy.AnyadirObjeto(objeto);
    usuario.AnyadirObjeto(objeto);
    logger.info("se ha anyadido"+ objeto.getNombre());

    }
    public void ActualizarUsuario(String nombre,String nuevonombre){
        Usuarios nuevouser = HashMapUsuarios.get(nombre);
        nuevouser.setNombre(nuevonombre);
        HashMapUsuarios.remove(nombre);
        HashMapUsuarios.put(nuevonombre,nuevouser);
        logger.info("el usuario ha sido actualizado por: "+nuevonombre);
    }

    public String infoUsuario(String nombre){
        int i = HashMapUsuarios.get(nombre).numeroObjetos();
        String cantidad = "El usuario" +nombre+ " tiene "+i+" objetos";
        logger.info("cantidad");
        return cantidad;

    }

    public List<Objetos> ObjetosUsuarios(Usuarios nombre){
        logger.info("se ha devuelto la lista de objetos");

        return HashMapUsuarios.get(nombre.getNombre()).devolverListaUsuarios();

    }


    public ArrayList<Usuarios> ListaUsuarios(){//ordenar
        ArrayList<Usuarios> milista = new ArrayList<Usuarios>();
        int i=0;
        for (String key: HashMapUsuarios.keySet()) {
            milista.add(HashMapUsuarios.get(key));
            i++;
        }
        logger.info("Se devuelven "+i+ " usuarios");
        return milista;


    }

}
