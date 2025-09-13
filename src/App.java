import java.time.LocalDate;
import java.util.List;

import author.AuthorServerPublisher;
import book.BookServerPublisher;
import library.LibraryServer;
import library.LibraryServerImpl;
import library.LibraryServerPublisher;

import author.AuthorServer;
import author.AuthorServerImpl;
import book.BookServer;
import book.BookServerImpl;
import models.Book;
import models.Author;

public class App {
  public App() {
    initPublisher();
    initTests();
  }

  private void initPublisher() {
    AuthorServerPublisher.main(null);
    BookServerPublisher.main(null);
    LibraryServerPublisher.main(null);
  }

  private void initTests() {
    try {
      Book book = handleBookTests();
      Author author = handleAuthorTests();

      handleLibraryTests(book, author);

      removeAllInformationFromLibrary(book.getId(), author.getId());
    } catch (Exception e) {
      System.err.println("ERRO: " + e.getMessage());
    }
  }

  private Book handleBookTests() {
    BookServer bookServer = BookServerImpl.getBookServer();

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

    return getBook;
  }

  private Author handleAuthorTests() {
    AuthorServer authorServer = AuthorServerImpl.getAuthorServer();

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

    System.out.println();

    return getAuthor;
  }

  private void handleLibraryTests(Book book, Author author) {
    LibraryServer libraryServer = LibraryServerImpl.getLibraryServer();

    System.out.println("=== Associando Livro ao Autor ===");
    libraryServer.addAuthorToBook(book.getId(), author.getId());
    System.out.printf("Livro com id %d associado ao autor com id %d com sucesso!\n\n", book.getId(), author.getId());

    System.out.println("=== Obtendo Livros do Autor ===");
    List<Book> booksByAuthor = libraryServer.getBooksFromAuthor(author.getId());
    booksByAuthor.forEach(b -> System.out.println("Livro: " + b));
    System.out.println();

    System.out.println("=== Obtendo Autores do Livro ===");
    List<Author> authorsByBook = libraryServer.getAuthorsFromBook(book.getId());
    authorsByBook.forEach(a -> System.out.println("Autor: " + a));
    System.out.println();
  }

  private void removeAllInformationFromLibrary(Long bookId, Long authorId) {
    BookServer bookServer = BookServerImpl.getBookServer();
    AuthorServer authorServer = AuthorServerImpl.getAuthorServer();
    LibraryServer libraryServer = LibraryServerImpl.getLibraryServer();

    System.out.println("=== Excluindo Livro ===");
    bookServer.deleteBook(bookId);
    System.out.printf("Livro com id %d excluído com sucesso!", bookId);

    System.out.println("\n");

    System.out.println("=== Excluindo Autor ===");
    authorServer.deleteAuthor(authorId);
    System.out.printf("Autor com id %d excluído com sucesso!", authorId);

    System.out.println("\n");

    System.out.println("=== Excluindo vínculo do Livro e Autor ===");
    libraryServer.removeAuthorFromBook(bookId, authorId);
    System.out.printf("Vínculo do authorId %d e do bookId excluído com sucesso!", authorId, bookId);
  }

  public static void main(String[] args) throws Exception {
    new App();
  }
}
