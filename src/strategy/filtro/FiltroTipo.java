package strategy.filtro;

import model.Item;
import model.Recomendacao;
import model.TipoItem;
import model.Usuario;

import java.util.List;
import java.util.Objects;

public class FiltroTipo implements FiltroStrategy {

    private final TipoItem tipo;

    public FiltroTipo(TipoItem tipo) {
        Objects.requireNonNull(tipo, "Tipo não pode ser nulo");
        this.tipo = tipo;
    }

    @Override
    public List<Recomendacao> filtrar(Usuario usuario, List<Recomendacao> candidatos) {
        return candidatos.stream()
                .filter(r -> r.item().getTipo() == tipo)
                .toList();
    }
}
