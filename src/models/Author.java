package models;

public class Author {
  private Long id;
  private String name;
  private String birthDate;
  private String nationality;
  private String biography;

  public Author() {
  }

  public Author(
    String name, 
    String birthDate, 
    String nationality, 
    String biography
  ) throws IllegalArgumentException {
    setName(name);
    setBirthDate(birthDate);
    setNationality(nationality);
    setBiography(biography);
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

  public String getName() {
    return name;
  }

  public void setName(String name) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("O nome não pode ser nulo.");
    }

    this.name = name;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) throws IllegalArgumentException {
    if (birthDate == null) {
      throw new IllegalArgumentException("A data de nascimento não pode ser nula.");
    }

    this.birthDate = birthDate;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) throws IllegalArgumentException {
    if (nationality == null) {
      throw new IllegalArgumentException("A nacionalidade não pode ser nula.");
    }

    this.nationality = nationality;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) throws IllegalArgumentException {
    if (biography == null) {
      throw new IllegalArgumentException("A biografia não pode ser nula.");
    }
    
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
