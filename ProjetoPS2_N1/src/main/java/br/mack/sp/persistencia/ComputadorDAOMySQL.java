package br.mack.sp.persistencia;

import br.mack.sp.entities.Computador;
import br.mack.sp.entities.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorDAOMySQL implements ComputadorDAO {
    private String createSQL = "INSERT INTO computador (marca, processador, qtde_ram, tmn_discoGB) VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM computador;";
    private String updateSQL = "UPDATE computador SET marca = ?, processador = ?, qtde_ram = ?, tmn_discoGB = ? WHERE id_computador = ?";
    private String deleteSQL = "DELETE FROM computador WHERE id_computador = ?";

    private final MySQLConnection mySQL = new MySQLConnection();

    @Override
    public boolean create(Computador computador) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(createSQL);
            pstm.setString(1, computador.getMarca());
            pstm.setString(2, computador.getProcessador());
            pstm.setInt(3, computador.getQtde_ram());
            pstm.setInt(4, computador.getTmn_disco());

            int registros = pstm.executeUpdate(); //retorna quantas linhas foram alteradas
            //pstm.executeQuery --> não altera nada; read (SELECT * FROM) ;
            return (registros > 0);
        } catch (SQLException e) {
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
    public List<Computador> read() {
        Connection conn = mySQL.getConnection();
        List<Computador> computadores = new ArrayList<>();

        try {
            PreparedStatement pstm = conn.prepareStatement(readSQL);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Computador computador = new Computador();
                computador.setId_computador(rs.getLong("id_computador"));
                computador.setMarca(rs.getString("marca"));
                computador.setProcessador(rs.getString("processador"));
                computador.setQtde_ram(rs.getInt("qtde_ram"));
                computador.setTmn_disco(rs.getInt("tmn_discoGB"));
                computadores.add(computador);
            }
            return computadores;

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
        return computadores;
    }

    @Override
    public boolean update(Computador computador) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(updateSQL);

            pstm.setString(1, computador.getMarca());
            pstm.setString(2, computador.getProcessador());
            pstm.setInt(3, computador.getQtde_ram());
            pstm.setInt(4, computador.getTmn_disco());
            pstm.setLong(5, computador.getId_computador());

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
    public boolean delete(Computador computador) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(deleteSQL);
            pstm.setLong(1, computador.getId_computador());
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
