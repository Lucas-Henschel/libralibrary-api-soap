package library;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import author.AuthorServer;
import author.AuthorServerImpl;
import book.BookServer;
import book.BookServerImpl;
import models.Author;
import models.Book;
import models.BookAuthorRelation;

@WebService(endpointInterface = "library.LibraryServer")
public class LibraryServerImpl implements LibraryServer {
  private final List<BookAuthorRelation> relations = new ArrayList<>();

  private final AuthorServer authorService = AuthorServerImpl.getAuthorServer();
  private final BookServer bookService = BookServerImpl.getBookServer();

  public static LibraryServer getLibraryServer() {
    try {
      URL url = new URL("http://127.0.0.1:3000/api/library?wsdl");
      QName qName = new QName("http://library/", "LibraryServerImplService");

      Service ws = Service.create(url, qName);

      return ws.getPort(LibraryServer.class);
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao conectar ao LibraryServer: " + ex.getMessage());
    }
  }

  @Override
  public BookAuthorRelation addAuthorToBook(Long bookId, Long authorId) {
    return relations.stream()
      .filter(r -> r.getBookId().equals(bookId) && r.getAuthorId().equals(authorId))
      .findFirst()
      .orElseGet(() -> {
        BookAuthorRelation newRelation = new BookAuthorRelation(bookId, authorId);
        relations.add(newRelation);
        
        return newRelation;
      });
  }

  @Override
  public void removeAuthorFromBook(Long bookId, Long authorId) {
    relations.removeIf(r -> 
      r.getBookId().equals(bookId) && r.getAuthorId().equals(authorId)
    );
  }

  @Override
  public List<Author> getAuthorsFromBook(Long bookId) {
    return relations.stream()
      .filter(r -> r.getBookId().equals(bookId))
      .map(r -> authorService.getById(r.getAuthorId()))
      .filter(Objects::nonNull)
      .collect(Collectors.toList());
  }

  @Override
  public List<Book> getBooksFromAuthor(Long authorId) {
    return relations.stream()
      .filter(r -> r.getAuthorId().equals(authorId))
      .map(r -> bookService.getById(r.getBookId()))
      .filter(Objects::nonNull)
      .collect(Collectors.toList());
  }
}
