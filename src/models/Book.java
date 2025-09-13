package models;

public class Book {
  private Long id;
  private String title;
  private String description;
  private double price;
  private int pages;
  private String language;
  
  public Book(
    Long id, 
    String title, 
    String description, 
    double price, 
    int pages, 
    String language
  ) {
    setId(id);
    setTitle(title);
    setDescription(description);
    setPrice(price);
    setPages(pages);
    setLanguage(language);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
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
