package br.mack.sp.persistencia;

import br.mack.sp.entities.Computador;

import java.util.List;

public interface ComputadorDAO {
    boolean create(Computador computador);

    List<Computador> read();

    boolean update(Computador computador);

    boolean delete(Computador computador);
}
