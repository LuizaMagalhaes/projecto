package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO {

    public int criar(Produto produto) {
        String sqlInsert = "INSERT INTO Produto(nome, preco, quantidade, descricao, tamanho) VALUES (?, ?, ?, ?, ?)";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getPreco());
            stm.setInt(3, produto.getQuantidade());
            stm.setString(4, produto.getDescricao());
            stm.setInt(5, produto.getTamanho());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
                    ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    produto.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produto.getId();
    }

    public void atualizar(Produto produto) {
        String sqlUpdate = "UPDATE produto SET nome=?, preco=?, quantidade=?, descricao=? tamanho=? WHERE id=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, produto.getNome());
            stm.setDouble(2, produto.getPreco());
            stm.setInt(3, produto.getQuantidade());
            stm.setInt(4, produto.getId());
            stm.setString(5, produto.getDescricao());
            stm.setInt(6, produto.getTamanho());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sqlDelete = "DELETE FROM produto WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Produto carregar(int id) {
        Produto produto = new Produto();
        produto.setId(id);
        String sqlSelect = "SELECT nome, preco, quantidade, descricao, tamanho FROM produto WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, produto.getId());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    produto.setNome(rs.getString("nome"));
                    produto.setPreco(rs.getInt("Preco"));
                    produto.setQuantidade(rs.getInt("Quantidade"));
                    produto.setDescricao(rs.getString("Descricao"));
                    produto.setTamanho(rs.getInt("Tamanho"));
                } else {
                    produto.setId(-1);
                    produto.setNome(null);
                    produto.setPreco(0);
                    produto.setQuantidade(0);
                    produto.setDescricao(null);
                    produto.setTamanho(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return produto;
    }

}
