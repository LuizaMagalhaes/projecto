package service;

import model.Vendedor;
import dao.VendedorDAO;

public class VendedorService {

  VendedorDAO dao = new VendedorDAO();

  public int criar(Vendedor vendedor) {
    return dao.criar(vendedor);
  }

  public void atualizar(Vendedor vendedor) {
    dao.atualizar(vendedor);
  }

  public void excluir(int id) {
    dao.excluir(id);
  }

  public Vendedor carregar(int id) {
    return dao.carregar(id);
  }
}
