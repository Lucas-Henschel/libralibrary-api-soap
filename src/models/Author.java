package models;

public class Author {
  private Long id;
  private String name;
  private String birthDate;
  private String nationality;
  private String biography;

  public Author() {
  }
  
  public Author(String name, String birthDate, String nationality, String biography) {
    setName(name);
    setBirthDate(birthDate);
    setNationality(nationality);
    setBiography(biography);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
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
    Author other = (Author) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Author [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", nationality=" + nationality
        + ", biography=" + biography + "]";
  }
}
