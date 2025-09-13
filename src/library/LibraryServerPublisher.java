package library;

import javax.xml.ws.Endpoint;

public class LibraryServerPublisher {
  public static void main(String[] args) {
    Endpoint.publish("http://127.0.0.1:3000/api/library", new LibraryServerImpl());
    System.out.println("Servico da Biblioteca publicado: http://127.0.0.1:3000/api/library?wsdl\n");
  }
}
