
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import author.AuthorServer;
import author.AuthorServerPublisher;
import book.BookServer;
import book.BookServerPublisher;

public class App {
    public App() {
        initPublisher();
    }

    private void initPublisher() {
        AuthorServerPublisher.main(null);
        BookServerPublisher.main(null);
    }

    private AuthorServer getAuthorServer() throws Exception {
        URL url = new URL("http://127.0.0.1:3000/api/author?wsdl");
        QName qName = new QName("http://author/", "AuthorServerImplService");

        Service ws = Service.create(url, qName);

        return ws.getPort(AuthorServer.class);
    }

    private BookServer getBookServer() throws Exception {
        URL url = new URL("http://127.0.0.1:3000/api/book?wsdl");
        QName qName = new QName("http://book/", "BookServerImplService");

        Service ws = Service.create(url, qName);

        return ws.getPort(BookServer.class);
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
