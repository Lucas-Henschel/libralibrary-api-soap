package library;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import models.Author;
import models.Book;
import models.BookAuthorRelation;

@WebService
@SOAPBinding
public interface LibraryServer {
  @WebMethod
  BookAuthorRelation addAuthorToBook(Long bookId, Long authorId);

  @WebMethod
  void removeAuthorFromBook(Long bookId, Long authorId);

  @WebMethod
  List<Author> getAuthorsFromBook(Long bookId);

  @WebMethod
  List<Book> getBooksFromAuthor(Long authorId);
}
