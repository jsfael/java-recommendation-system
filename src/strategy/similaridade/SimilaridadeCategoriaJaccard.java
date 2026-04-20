package strategy.similaridade;

import model.Usuario;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SimilaridadeCategoriaJaccard implements SimilaridadeStrategy {

    @Override
    public double calcular(Usuario a, Usuario b) {

        Set<String> categoriasA = a.getItensCurtidos()
                .stream()
                .map(item -> item.getCategoria().toLowerCase())
                .collect(Collectors.toSet());

        Set<String> categoriasB = b.getItensCurtidos()
                .stream()
                .map(item -> item.getCategoria().toLowerCase())
                .collect(Collectors.toSet());

        if (categoriasA.isEmpty() && categoriasB.isEmpty()) {
            return 0;
        }

        Set<String> intersecao = new HashSet<>(categoriasA);
        intersecao.retainAll(categoriasB);

        Set<String> uniao = new HashSet<>(categoriasA);
        uniao.addAll(categoriasB);

        return (double) intersecao.size() / uniao.size();
    }
}