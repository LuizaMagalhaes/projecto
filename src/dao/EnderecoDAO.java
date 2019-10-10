package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Endereco;

public class EnderecoDAO {

  public int criar(Endereco endereco) {
      String sqlInsert = "INSERT INTO Endereco(rua, cep, numero, uf, pais) VALUES (?, ?, ?, ?, ?)";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
          stm.setString(1, endereco.getRua());
          stm.setInt(2, endereco.getCep());
          stm.setInt(3, endereco.getNumero());
          stm.setString(4, endereco.getUf());
          stm.setString(5, endereco.getPais());
          stm.execute();
          String sqlQuery = "SELECT LAST_INSERT_ID()";
          try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
                  ResultSet rs = stm2.executeQuery();) {
              if (rs.next()) {
                  endereco.setId(rs.getInt(1));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return endereco.getId();
  }

  public void atualizar(Endereco endereco) {
      String sqlUpdate = "UPDATE endereco SET rua=?, cep=?, numero=?, uf=? pais=? WHERE id=?";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
          stm.setString(1, endereco.getRua());
          stm.setInt(2, endereco.getCep());
          stm.setInt(3, endereco.getNumero());
          stm.setInt(4, endereco.getId());
          stm.setString(5, endereco.getUf());
          stm.setString(6, endereco.getPais());
          stm.execute();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public void excluir(int id) {
      String sqlDelete = "DELETE FROM endereco WHERE id = ?";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
          stm.setInt(1, id);
          stm.execute();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public Endereco carregar(int id) {
      Endereco endereco = new Endereco();
      endereco.setId(id);
      String sqlSelect = "SELECT rua, cep, numero, uf, pais FROM endereco WHERE id = ?";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
          stm.setInt(1, endereco.getId());
          try (ResultSet rs = stm.executeQuery();) {
              if (rs.next()) {
                  endereco.setRua(rs.getString("rua"));
                  endereco.setCep(rs.getInt("CEP"));
                  endereco.setNumero(rs.getInt("Numero"));
                  endereco.setUf(rs.getString("uf"));
                  endereco.setPais(rs.getString("Pais"));
              } else {
                  endereco.setId(-1);
                  endereco.setRua(null);
                  endereco.setCep(0);
                  endereco.setNumero(0);
                  endereco.setUf(null);
                  endereco.setPais(null);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      } catch (SQLException e1) {
          System.out.print(e1.getStackTrace());
      }
      return endereco;
  }
}
