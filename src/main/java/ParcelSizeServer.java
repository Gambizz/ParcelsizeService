import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

import javax.swing.*;
import java.io.IOException;

public class ParcelSizeServer {
    public static void main(String[] args){
        System.out.println("Hello Parcelservice!");
        HttpServer server = null;
        try {
            server = HttpServerFactory.create("http://localhost:8081/rest");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Starte Parcelservice HTTP!");
        assert server != null;
        server.start();

        JOptionPane.showMessageDialog( null, "Ende" );
        System.out.println("Beende Parcelservice HTTP!");
    }
}
