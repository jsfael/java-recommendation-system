package strategy.filtro;

import model.Item;
import model.Recomendacao;
import model.Usuario;

import java.util.List;


public class FiltroCategoria implements FiltroStrategy {

    private final String categoria;

    public FiltroCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Categoria inválida");
        }
        this.categoria = categoria.trim().toLowerCase();
    }

    @Override
    public List<Recomendacao> filtrar(Usuario usuario, List<Recomendacao> candidatos) {
        return candidatos.stream()
                .filter(r -> r.item().getCategoria().toLowerCase().equals(categoria))
                .toList();
    }
}