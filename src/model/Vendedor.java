package model;

public class Vendedor {
  private int id;
  private String nome;
  private int rg;
  private int cpf;
  private int telefone;
  private int produtoVendidos;

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setRg(int rg) {
    this.rg = rg;
  }

  public void setCpf(int cpf) {
    this.cpf = cpf;
  }

  public void setTelefone(int telefone) {
    this.telefone = telefone;
  }

  public void setProdutosVendidos(int produtoVendidos) {
    this.produtoVendidos = produtoVendidos;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public int getRg() {
    return rg;
  }

  public int getCpf() {
    return cpf;
  }

  public int getTelefone() {
    return telefone;
  }

  public int getProdutosVendidos() {
    return produtoVendidos;
  }
}
