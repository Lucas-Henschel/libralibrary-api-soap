package models;

public class Book {
  private Long id;
  private String title;
  private String description;
  private double price;
  private int pages;
  private String language;

  public Book() {
  }
  
  public Book(
    String title, 
    String description, 
    double price, 
    int pages, 
    String language
  ) throws IllegalArgumentException {
    setTitle(title);
    setDescription(description);
    setPrice(price);
    setPages(pages);
    setLanguage(language);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) throws IllegalArgumentException {
    if (id == null) {
      throw new IllegalArgumentException("O ID não pode ser nulo.");
    }

    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) throws IllegalArgumentException {
    if (title == null) {
      throw new IllegalArgumentException("O título não pode ser nulo.");
    }

    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) throws IllegalArgumentException {
    if (description == null) {
      throw new IllegalArgumentException("A descrição não pode ser nula.");
    }

    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) throws IllegalArgumentException {
    if (price <= 0) {
      throw new IllegalArgumentException("O preço deve ser maior que zero.");
    }

    this.price = price;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) throws IllegalArgumentException {
    if (pages <= 0) {
      throw new IllegalArgumentException("O número de páginas deve ser maior que zero.");
    }

    this.pages = pages;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) throws IllegalArgumentException {
    if (language == null) {
      throw new IllegalArgumentException("O idioma não pode ser nulo.");
    }
    
    this.language = language;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
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
    Book other = (Book) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price + ", pages="
        + pages + ", language=" + language + "]";
  }


}
