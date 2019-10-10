package model;

public class Produto {
  private int id;
  private String nome;
  private double preco;
  private int quantidade;
  private String descricao;
  private int tamanho;


  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setTamanho(int tamanho){
    this.tamanho = tamanho;
  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public double getPreco() {
    return preco;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public String getDescricao() {
    return descricao;
  }

  public int getTamanho(){
    return tamanho;
  }
}
