package model;

public class Endereco {
  private int id;
  private String rua;
  private int cep;
  private int numero;
  private String uf;
  private String pais;


  public void setId(int id) {
    this.id = id;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public void setCep(int cep) {
    this.cep = cep;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public void setPais(String pais){
    this.pais = pais;
  }

  public int getId() {
    return id;
  }

  public String getRua() {
    return rua;
  }

  public int getCep() {
    return cep;
  }

  public int getNumero() {
    return numero;
  }

  public String getUf() {
    return uf;
  }

  public String getPais(){
    return pais;
  }
}
