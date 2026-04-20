package strategy.filtro;

import model.Item;
import model.Recomendacao;
import model.Usuario;

import java.util.List;

public class FiltroNenhum implements FiltroStrategy {

    @Override
    public List<Recomendacao> filtrar(Usuario usuario, List<Recomendacao> candidatos) {
        return candidatos;
    }
}
