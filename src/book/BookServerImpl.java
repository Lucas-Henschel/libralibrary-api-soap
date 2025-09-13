package book;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import models.Book;

@WebService(endpointInterface = "book.BookServer")
public class BookServerImpl implements BookServer {
  private final Map<Long, Book> books = new HashMap<>();
  private final AtomicLong idGenerator = new AtomicLong(1);

  public static BookServer getBookServer() {
    try {
      URL url = new URL("http://127.0.0.1:3000/api/book?wsdl");
      QName qName = new QName("http://book/", "BookServerImplService");

      Service ws = Service.create(url, qName);

      return ws.getPort(BookServer.class);
    } catch (Exception ex) {
      throw new RuntimeException("Erro ao conectar ao BookServer: " + ex.getMessage());
    }
  }

  @Override
  public List<Book> getAllBooks() {
    return new ArrayList<>(books.values());
  }

  @Override
  public Book getById(Long id) {
    return books.get(id);
  }

  @Override
  public Book createBook(Book book) {
    book.setId(idGenerator.getAndIncrement());
    books.put(book.getId(), book);

    return book;
  }

  @Override
  public Book updateBook(Long id, Book bookUpdated) {
    Book book = getById(id);

    if (book == null) {
      throw new IllegalArgumentException("Livro não existe.");
    }

    books.put(id, bookUpdated);

    return bookUpdated;
  }

  @Override
  public void deleteBook(Long id) {
    Book book = getById(id);

    if (book == null) {
      throw new IllegalArgumentException("Livro não existe.");
    }

    books.remove(id);
  }
}
