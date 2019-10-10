package model;

public class Marca {
  private int id;
  private String nome;
  private String modelo;

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getModelo() {
    return modelo;
  }
}
