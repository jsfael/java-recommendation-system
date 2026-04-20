package strategy.filtro;

import model.Item;
import model.TipoItem;
import model.Usuario;

import java.util.List;

public class FiltroTipo implements FiltroStrategy {

    private final TipoItem tipo;

    public FiltroTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    @Override
    public List<Item> filtrar(Usuario usuario, List<Item> candidatos) {
        return candidatos.stream()
                .filter(item -> item.getTipo() == tipo)
                .toList();
    }

}