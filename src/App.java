import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import author.AuthorServer;
import author.AuthorServerPublisher;
import book.BookServer;
import book.BookServerPublisher;
import models.Author;
import models.Book;

public class App {
    public App() {
        initPublisher();
        initTests();
    }

    private void initPublisher() {
        AuthorServerPublisher.main(null);
        BookServerPublisher.main(null);
    }

    private AuthorServer getAuthorServer() {
        try {
            URL url = new URL("http://127.0.0.1:3000/api/author?wsdl");
            QName qName = new QName("http://author/", "AuthorServerImplService");

            Service ws = Service.create(url, qName);

            return ws.getPort(AuthorServer.class);
        }  catch (Exception ex) {
            throw new RuntimeException("Erro ao conectar ao AuthorServer: " + ex.getMessage());
        }
    }

    private BookServer getBookServer() {
        try {
            URL url = new URL("http://127.0.0.1:3000/api/book?wsdl");
            QName qName = new QName("http://book/", "BookServerImplService");

            Service ws = Service.create(url, qName);

            return ws.getPort(BookServer.class);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao conectar ao BookServer: " + ex.getMessage());
        }
    }

    private void initTests() {
        try {
            handleBookTests();
            handleAuthorTests();
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }

    private void handleBookTests() {
        BookServer bookServer = getBookServer();

        System.out.println("=== Criando Livro ===");
        Book book = new Book(
            "1984", 
            "Romance distópico", 
            59.90, 
            328, 
            "PT-BR"
        );

        Book createdBook = bookServer.createBook(book);
        System.out.println("Livro criado: " + createdBook + "\n");

        System.out.println("=== Atualizando Livro ===");
        createdBook.setPages(123);

        Book updatedBook = bookServer.updateBook(createdBook.getId(), createdBook);
        System.out.println("Livro atualizado: " + updatedBook + "\n");

        System.out.println("=== Obtendo Livro por Id ===");
        Book getBook = bookServer.getById(createdBook.getId());
        System.out.println("Livro obtido: " + getBook + "\n");

        System.out.println("=== Listando Livros ===");
        List<Book> books = bookServer.getAllBooks();
        books.forEach(b -> System.out.println("Livro: " + b));

        System.out.println("");

        System.out.println("=== Excluindo Livro ===");
        bookServer.deleteBook(createdBook.getId());
        System.out.printf("Livro com id %d excluído com sucesso!", createdBook.getId());

        System.out.println("\n\n");
    }

    private void handleAuthorTests() {
        AuthorServer authorServer = getAuthorServer();

        System.out.println("=== Criando Autor ===");
        Author author = new Author(
            "George Orwell", 
            LocalDate.of(1980, 5, 20).toString(), 
            "Inglês", 
            "Autor de 1984 e A Revolução dos Bichos"
        );

        Author createdAuthor = authorServer.createAuthor(author);
        System.out.println("Autor criado: " + createdAuthor + "\n");

        System.out.println("=== Atualizando Autor ===");
        createdAuthor.setNationality("Brasileiro");

        Author updatedAuthor = authorServer.updateAuthor(createdAuthor.getId(), createdAuthor);
        System.out.println("Autor atualizado: " + updatedAuthor + "\n");

        System.out.println("=== Obtendo Autor por Id ===");
        Author getAuthor = authorServer.getById(createdAuthor.getId());
        System.out.println("Autor obtido: " + getAuthor + "\n");

        System.out.println("=== Listando Autores ===");
        List<Author> authors = authorServer.getAllAuthors();
        authors.forEach(a -> System.out.println("Autor: " + a));

        System.out.println("");

        System.out.println("=== Excluindo Autor ===");
        authorServer.deleteAuthor(createdAuthor.getId());
        System.out.printf("Autor com id %d excluído com sucesso!", createdAuthor.getId());

        System.out.println("\n\n");
    }

    public static void main(String[] args) throws Exception {
        new App();
    }
}
