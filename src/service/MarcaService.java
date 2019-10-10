package service;

import model.Marca;
import dao.MarcaDAO;

public class MarcaService {

  MarcaDAO dao = new MarcaDAO();

  public int criar(Marca marca) {
    return dao.criar(marca);
  }

  public void atualizar(Marca marca) {
    dao.atualizar(marca);
  }

  public void excluir(int id) {
    dao.excluir(id);
  }

  public Marca carregar(int id) {
    return dao.carregar(id);
  }
}
