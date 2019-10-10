package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Marca;

public class MarcaDAO {

    public int criar(Marca marca) {
        String sqlInsert = "INSERT INTO Marca(nome, modelo) VALUES (?, ?)";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
            stm.setString(1, marca.getNome());
            stm.setString(2, marca.getModelo());
            stm.execute();
            String sqlQuery = "SELECT LAST_INSERT_ID()";
            try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
                    ResultSet rs = stm2.executeQuery();) {
                if (rs.next()) {
                    marca.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return marca.getId();
    }

    public void atualizar(Marca marca) {
        String sqlUpdate = "UPDATE marca SET nome=?, modelo=? WHERE id=?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
            stm.setString(1, marca.getNome());
            stm.setString(2, marca.getModelo());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluir(int id) {
        String sqlDelete = "DELETE FROM marca WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
            stm.setInt(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Marca carregar(int id) {
        Marca marca = new Marca();
        marca.setId(id);
        String sqlSelect = "SELECT nome, modelo FROM marca WHERE id = ?";
        // usando o try with resources do Java 7, que fecha o que abriu
        try (Connection conn = ConnectionFactory.obtemConexao();
                PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
            stm.setInt(1, marca.getId());
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    marca.setNome(rs.getString("nome"));
                    marca.setModelo(rs.getString("Modelo"));
                } else {
                    marca.setId(-1);
                    marca.setNome(null);
                    marca.setModelo(null);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e1) {
            System.out.print(e1.getStackTrace());
        }
        return marca;
    }

}
