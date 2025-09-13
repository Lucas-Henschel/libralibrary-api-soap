package book;

import javax.xml.ws.Endpoint;

public class BookServerPublisher {
  public static void main(String[] args) {
    Endpoint.publish("http://127.0.0.1:3000/api/book", new BookServerImpl());
    System.out.println("Servico do Livro publicado\n");
  }
}
