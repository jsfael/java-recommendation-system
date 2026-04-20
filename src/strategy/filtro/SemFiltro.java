package strategy.filtro;

import model.Item;
import model.Usuario;

import java.util.List;

public class SemFiltro implements FiltroStrategy{

    @Override
    public List<Item> filtrar(Usuario usuario, List<Item> candidatos) {
        return candidatos;
    }

}
