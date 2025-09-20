package book;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import exceptions.LibraryValidationException;
import models.Book;

@WebService
@SOAPBinding
public interface BookServer {
  @WebMethod
  List<Book> getAllBooks();

  @WebMethod
  Book getById(Long id);

  @WebMethod
  Book createBook(Book book);

  @WebMethod
  Book updateBook(Long id, Book book) throws IllegalArgumentException;

  @WebMethod
  void deleteBook(Long id) throws IllegalArgumentException, LibraryValidationException;
}
