package Controlador;

import Modelo.Objetos;
import Modelo.Usuarios;

import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by B on 19/4/17.
 *
 */



@Path("/json")
@Singleton
public class JSONService {

    // README please:
    /*
    Los comentarios que he hecho del GET y POST los he realizado, para asi poder ejecutar el programa sin errores
    * */
    protected List<Usuarios> usuarios;
    public JSONService(){
        usuarios = new ArrayList<Usuarios>();
        Usuarios a = new Usuarios();
        a.setNombre("Bruno"); // Para probar
        usuarios.add(a);

    }
    /*
    List<Usuarios> ListaUsuarios();
    void  AnyadirUsuario(Usuarios usuarioxraanyadir);
    void ActualizarUsuario(String nombre,String nuevonombre);
    String infoUsuario(String nombre);
    List<Objetos> ObjetosUsuarios(Usuarios nombre);
    void  AnyadirObjetoaUsuario(Usuarios usuario, Objetos objeto);
    */

    @GET
    @Path("/ListaUsuarios/{nombre}") // dame el usuario
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> getList(@PathParam("nombre") String nombre){
        List<Usuarios>a=new ArrayList<Usuarios>();
        //a.add(usuarios.get(nombre));
        return a;
    }

    @POST
    @Path("/anyadirusuario")
    @Produces(MediaType.TEXT_PLAIN)
    public Response AnyadirUsuario(Usuarios user){
        String result = "Usuario : " + user;
        return Response.status(201).entity(result).build();
    }
    /*@POST
    @Path("/actualizarUsuario/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    @PathParam("nombre") String nombre;
    String nuevonombre1 = "sedeberiapedirporPOSTMAN";
    public void ActualizarUsuario(String nombre, String nuevonombre1){};
}*/
    @GET
    @Path("/infoUsuario/{nombre1}") // dame el usuario
    @Produces(MediaType.APPLICATION_JSON)
    public String infoUsuario(@PathParam("nombre1") String nombre){
        List<Usuarios>a=new ArrayList<Usuarios>();
        return infoUsuario(nombre);
    }
    /*@POST
    @Path("/AnyadirObjetoaUsuario/{nombre3}/{nombre4}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response AnyadirObjetoaUsuario(@PathParam("nombre3") String nombre3, @PathParam("nombre4") String nombre4){
        usuarios = new ArrayList<Usuarios>();
        Usuarios a = new Usuarios();
        Usuarios userbusqueda = usuarios.get(nombre3);  // se que esta parte no funciona, xq deberia pasarle un User/int
        userbusqueda.AnyadirObjeto(nombre4);
        String result = "Usuario : " + userbusqueda;
        return Response.status(201).entity(result).build();
    }*/







}
