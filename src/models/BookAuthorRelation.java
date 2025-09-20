package models;

public class BookAuthorRelation {
  private Long bookId;
  private Long authorId;

  public BookAuthorRelation() {}

  public BookAuthorRelation(Long bookId, Long authorId) {
    setBookId(bookId);;
    setAuthorId(authorId);
  }

  public Long getBookId() {
    return bookId;
  }

  public void setBookId(Long bookId) throws IllegalArgumentException {
    if (bookId == null) {
      throw new IllegalArgumentException("O ID do livro não pode ser nulo.");
    }

    this.bookId = bookId;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) throws IllegalArgumentException {
    if (authorId == null) {
      throw new IllegalArgumentException("O ID do autor não pode ser nulo.");
    }

    this.authorId = authorId;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
    result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BookAuthorRelation other = (BookAuthorRelation) obj;
    if (bookId == null) {
      if (other.bookId != null)
        return false;
    } else if (!bookId.equals(other.bookId))
      return false;
    if (authorId == null) {
      if (other.authorId != null)
        return false;
    } else if (!authorId.equals(other.authorId))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "BookAuthorRelation [bookId=" + bookId + ", authorId=" + authorId + "]";
  }
}
