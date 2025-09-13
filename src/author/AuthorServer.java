package author;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import models.Author;

@WebService
@SOAPBinding
public interface AuthorServer {
    @WebMethod
    List<Author> getAllAuthors();

    @WebMethod
    Author getById(Long id);

    @WebMethod
    Author createAuthor(Author author);

    @WebMethod
    Author updateAuthor(Long id, Author author) throws IllegalArgumentException;

    @WebMethod
    void deleteAuthor(Long id) throws IllegalArgumentException;
}
