package service;

import model.Produto;
import dao.ProdutoDAO;

public class ProdutoService {

  ProdutoDAO dao = new ProdutoDAO();

  public int criar(Produto produto) {
    return dao.criar(produto);
  }

  public void atualizar(Produto produto) {
    dao.atualizar(produto);
  }

  public void excluir(int id) {
    dao.excluir(id);
  }

  public Produto carregar(int id) {
    return dao.carregar(id);
  }

public Produto carregarProdutoPorNome(String nomeProduto) {
	// TODO Auto-generated method stub
	return null;
}
}
