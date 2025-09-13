package book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.jws.WebService;

import models.Book;

@WebService(endpointInterface = "book.BookServer")
public class BookServerImpl implements BookServer {
  private final Map<Long, Book> books = new HashMap<>();
  private final AtomicLong idGenerator = new AtomicLong(1);

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
