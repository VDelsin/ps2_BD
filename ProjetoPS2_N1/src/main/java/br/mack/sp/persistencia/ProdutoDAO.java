package br.mack.sp.persistencia;

import br.mack.sp.entities.Produto;

import java.util.List;

public interface ProdutoDAO {
    boolean create(Produto produto);
    List<Produto> read();
    boolean update(Produto produto);
    boolean delete (Produto produto);
}
