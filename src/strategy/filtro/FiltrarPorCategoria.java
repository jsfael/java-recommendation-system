package strategy.filtro;

import model.Item;
import model.Usuario;

import java.util.List;
import java.util.Objects;

public class FiltrarPorCategoria implements FiltroStrategy {

    private final String categoria;

    public FiltrarPorCategoria(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("Categoria inválida");
        }
        this.categoria = categoria.trim().toLowerCase();
    }

    @Override
    public List<Item> filtrar(Usuario usuario, List<Item> candidatos) {
        return candidatos.stream()
                .filter(item -> item.getCategoria().toLowerCase().equals(categoria))
                .toList();
    }
}