package author;

import javax.xml.ws.Endpoint;

public class AuthorServerPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:3000/api/author", new AuthorServerImpl());
        System.out.println("Servico do Autor publicado");
    }
}
