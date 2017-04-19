import Controlador.EtakemonManager;
import Controlador.EtakemonManagerImpl;
import Modelo.Objetos;
import Modelo.Usuarios;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by valentinamoncada on 19/4/17.
 */
public class Main {
    // ESTE CODIGO ES PARA LA PARTE 2
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://localhost:8080/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in edu.upc.dsa package
        final ResourceConfig rc = new ResourceConfig().packages("dsa");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }


    /**
     * Main method.
     * @param args
     * @throws IOException
     */

    public static void main(String[] args) throws Exception {
        // PARTE 1
        EtakemonManagerImpl controlador = EtakemonManagerImpl.getInstance();
        Usuarios user1 = new Usuarios("Bruno");
        Usuarios user2 = new Usuarios("Valentina");
        controlador.AnyadirUsuario(user1);
        controlador.AnyadirUsuario(user2);
        Objetos objeto1 = new Objetos("objeto321");
        controlador.AnyadirObjetoaUsuario(user1,objeto1);
        controlador.AnyadirObjetoaUsuario(user2,objeto1);
        controlador.ListaUsuarios();
        controlador.infoUsuario("Bruno");

        // ESTE CODIGO ES PARA LA PARTE 2
        final HttpServer server = startServer();
        StaticHttpHandler staticHttpHandler = new StaticHttpHandler("./public/");
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");


        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));

        System.in.read();
        server.stop();
    }

}
