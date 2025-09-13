package author;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import models.Author;

@WebService(endpointInterface = "author.AuthorServer")
public class AuthorServerImpl implements AuthorServer {
  private final Map<Long, Author> authors = new HashMap<>();
  private final AtomicLong idGenerator = new AtomicLong(1);

  public static AuthorServer getAuthorServer() {
    try {
      URL url = new URL("http://127.0.0.1:3000/api/author?wsdl");
      QName qName = new QName("http://author/", "AuthorServerImplService");

      Service ws = Service.create(url, qName);

      return ws.getPort(AuthorServer.class);
    }  catch (Exception ex) {
      throw new RuntimeException("Erro ao conectar ao AuthorServer: " + ex.getMessage());
    }
  }

  @Override
  public List<Author> getAllAuthors() {
    return new ArrayList<>(authors.values());
  }

  @Override
  public Author getById(Long id) {
    return authors.get(id);
  }

  @Override
  public Author createAuthor(Author author) {
    author.setId(idGenerator.getAndIncrement());
    authors.put(author.getId(), author);

    return author;
  }

  @Override
  public Author updateAuthor(Long id, Author authorUpdated) {
    Author author = getById(id);

    if (author == null) {
      throw new IllegalArgumentException("Autor não existe.");
    }

    authors.put(id, authorUpdated);

    return authorUpdated;
  }

  @Override
  public void deleteAuthor(Long id) {
    Author author = getById(id);

    if (author == null) {
      throw new IllegalArgumentException("Autor não existe.");
    }

    authors.remove(id);
  }
}
