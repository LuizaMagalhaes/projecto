package service;

import model.Endereco;
import dao.EnderecoDAO;

public class EnderecoService {

    EnderecoDAO dao = new EnderecoDAO();

    public int criar(Endereco endereco) {
        return dao.criar(endereco);
    }

    public void atualizar(Endereco endereco) {
        dao.atualizar(endereco);
    }

    public void excluir(int id) {
        dao.excluir(id);
    }

    public Endereco carregar(int id) {
        return dao.carregar(id);
    }

}
