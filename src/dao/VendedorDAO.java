package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Vendedor;

public class VendedorDAO {

  public int criar(Vendedor vendedor) {
      String sqlInsert = "INSERT INTO Vendedor(nome, rg, cpf, telefone, produtosVendidos) VALUES (?, ?, ?, ?, ?)";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
          stm.setString(1, vendedor.getNome());
          stm.setInt(2, vendedor.getRg());
          stm.setInt(3, vendedor.getCpf());
          stm.setInt(4, vendedor.getTelefone());
          stm.setInt(5, vendedor.getProdutosVendidos());
          stm.execute();
          String sqlQuery = "SELECT LAST_INSERT_ID()";
          try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
                  ResultSet rs = stm2.executeQuery();) {
              if (rs.next()) {
                  vendedor.setId(rs.getInt(1));
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return vendedor.getId();
  }

  public void atualizar(Vendedor vendedor) {
      String sqlUpdate = "UPDATE vendedor SET nome=?, rg=?, cpf=?, telefone=? produtosVendidos=? WHERE id=?";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
          stm.setString(1, vendedor.getNome());
          stm.setInt(2, vendedor.getRg());
          stm.setInt(3, vendedor.getCpf());
          stm.setInt(4, vendedor.getId());
          stm.setInt(5, vendedor.getTelefone());
          stm.setInt(6, vendedor.getProdutosVendidos());
          stm.execute();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public void excluir(int id) {
      String sqlDelete = "DELETE FROM vendedor WHERE id = ?";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
          stm.setInt(1, id);
          stm.execute();
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  public Vendedor carregar(int id) {
      Vendedor vendedor = new Vendedor();
      vendedor.setId(id);
      String sqlSelect = "SELECT nome, rg, cpf, telefone, produtosVendidos FROM vendedor WHERE id = ?";
      // usando o try with resources do Java 7, que fecha o que abriu
      try (Connection conn = ConnectionFactory.obtemConexao();
              PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
          stm.setInt(1, vendedor.getId());
          try (ResultSet rs = stm.executeQuery();) {
              if (rs.next()) {
                  vendedor.setNome(rs.getString("nome"));
                  vendedor.setRg(rs.getInt("RG"));
                  vendedor.setCpf(rs.getInt("CPF"));
                  vendedor.setTelefone(rs.getInt("telefone"));
                  vendedor.setProdutosVendidos(rs.getInt("Produtos vendidos"));
              } else {
                  vendedor.setId(-1);
                  vendedor.setNome(null);
                  vendedor.setRg(0);
                  vendedor.setCpf(0);
                  vendedor.setTelefone(0);
                  vendedor.setProdutosVendidos(0);
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      } catch (SQLException e1) {
          System.out.print(e1.getStackTrace());
      }
      return vendedor;
  }

}
