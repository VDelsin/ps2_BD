package br.mack.sp.persistencia;

import br.mack.sp.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOMySQL implements ProdutoDAO {
    private String createSQL = "INSERT INTO produto (descricao, marca, preco) VALUES (?, ?, ?)";
    private String readSQL = "SELECT * FROM produto;";
    private String updateSQL = "UPDATE produto SET descricao = ?, marca = ?, preco = ? WHERE id = ?";
    private String deleteSQL = "DELETE FROM produto WHERE id = ?";

    private final MySQLConnection mySQL = new MySQLConnection();

    @Override
    public boolean create(Produto produto) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(createSQL);

            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getMarca());
            pstm.setDouble(3, produto.getPreco());

            int registros = pstm.executeUpdate();

            return (registros > 0);

        } catch (SQLException e) {
            System.out.println("Falha de conexão com a base de dados");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Produto> read() {
        Connection conn = mySQL.getConnection();
        List<Produto> produtos = new ArrayList<>();

        try {
            PreparedStatement pstm = conn.prepareStatement(readSQL);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setMarca(rs.getString("marca"));
                produto.setPreco(rs.getDouble("preco"));
                produtos.add(produto);
            }
            return produtos;

        } catch (final SQLException e) {
            System.out.println("Falha de conexão com a base de dados");
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
        return produtos;
    }

    @Override
    public boolean update(Produto produto) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(updateSQL);

            pstm.setString(1, produto.getDescricao());
            pstm.setString(2, produto.getMarca());
            pstm.setDouble(3, produto.getPreco());
            pstm.setLong(4, produto.getId());

            int registros = pstm.executeUpdate();

            return (registros > 0);

        } catch (SQLException e) {
            System.out.println("Falha de conexão com a base de dados");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    @Override
    public boolean delete(Produto produto) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(deleteSQL);
            pstm.setLong(1, produto.getId());
            int registros = pstm.executeUpdate();
            return registros > 0;
        } catch (final SQLException e) {
            System.out.println("Falha de conexão com a base de dados");
            e.printStackTrace();
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
