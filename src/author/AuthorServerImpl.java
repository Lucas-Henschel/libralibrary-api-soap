package author;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.jws.WebService;

import models.Author;

@WebService(endpointInterface = "author.AuthorServer")
public class AuthorServerImpl implements AuthorServer {
    private final Map<Long, Author> authors = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

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
