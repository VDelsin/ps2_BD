package br.mack.sp.persistencia;

import br.mack.sp.entities.Computador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ComputadorDAOMySQL implements ComputadorDAO{
    private String createSQL = "INSERT INTO computador (marca, processador, qtde_ram, tmn_discoGB) VALUES (?, ?, ?, ?)";
    private String readSQL = "SELECT * FROM computador;";
    private String updateSQL = "UPDATE computador SET marca = ?, processador = ?, qtde_ram = ?, tmn_discoGB = ? WHERE id = ?";
    private String deleteSQL = "DELETE FROM computador WHERE id = ?";

    private final MySQLConnection mySQL = new MySQLConnection();

    @Override
    public boolean create(Computador computador) {
        Connection conn = mySQL.getConnection();
        try {
            PreparedStatement pstm = conn.prepareStatement(createSQL);
            pstm.setString(1,computador.getMarca());
            pstm.setString(2,computador.getProcessador());
            pstm.setInt(3, computador.getQtde_ram());
            pstm.setInt(4,computador.getTmn_disco());

            int registros = pstm.executeUpdate(); //retorna quantas linhas foram alteradas
            //pstm.executeQuery --> não altera nada; read (SELECT * FROM) ;
            return (registros>0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
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
        return null;
    }

    @Override
    public boolean update(Computador computador) {
        return false;
    }

    @Override
    public boolean delete(Computador computador) {
        return false;
    }
}
