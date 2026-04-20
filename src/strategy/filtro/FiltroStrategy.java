package strategy.filtro;

import model.Item;
import model.Recomendacao;
import model.Usuario;

import java.util.List;

public interface FiltroStrategy {
    List<Recomendacao> filtrar(Usuario usuario, List<Recomendacao> candidatos);
}
