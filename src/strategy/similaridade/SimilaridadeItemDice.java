package strategy.similaridade;

import model.Item;
import model.Usuario;

import java.util.Set;

public class SimilaridadeItemDice implements SimilaridadeStrategy {
    @Override
    public double calcular(Usuario a, Usuario b) {
        Set<Item> setA = a.getItensCurtidos();
        Set<Item> setB = b.getItensCurtidos();

        if (setA.isEmpty() || setB.isEmpty()) return 0.0;

        long intersecao = setA.stream()
                .filter(setB::contains)
                .count();

        return (2.0 * intersecao) / (setA.size() + setB.size());
    }
}
