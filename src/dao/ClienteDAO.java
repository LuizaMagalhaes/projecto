package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;

public class ClienteDAO {

    public int criar(Cliente cliente) {
        String sqlInsert = "INSERT INTO Cliente(nome, rg, cpf, telefone) VALUES (?, ?, ?, ?)";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, cliente.getNome());
            stm.setInt(2, cliente.getRg());
            stm.setInt(3, cliente.getCpf());
            stm.setInt(4, cliente.getTelefone());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
                    ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    cliente.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente.getId();
    }

    public void atualizar(Cliente cliente) {
        String sqlUpdate = "UPDATE cliente SET nome=?, rg=?, cpf=?, telefone=? WHERE id=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, cliente.getNome());
            stm.setInt(2, cliente.getRg());
            stm.setInt(3, cliente.getCpf());
            stm.setInt(4, cliente.getId());
            stm.setInt(5, cliente.getTelefone());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sqlDelete = "DELETE FROM cliente WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Cliente carregar(int id) {
        Cliente cliente = new Cliente();
        cliente.setId(id);
        String sqlSelect = "SELECT nome, rg, cpf, telefone FROM cliente WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, cliente.getId());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    cliente.setNome(rs.getString("nome"));
                    cliente.setRg(rs.getInt("RG"));
                    cliente.setCpf(rs.getInt("CPF"));
                    cliente.setTelefone(rs.getInt("telefone"));
                } else {
                    cliente.setId(-1);
                    cliente.setNome(null);
                    cliente.setRg(0);
                    cliente.setCpf(0);
                    cliente.setTelefone(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return cliente;
    }

}
