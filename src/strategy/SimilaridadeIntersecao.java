package strategy;

import model.Item;
import model.Usuario;

import java.util.HashSet;
import java.util.Set;

public class SimilaridadeIntersecao implements SimilaridadeStrategy{

    @Override
    public double calcular(Usuario a, Usuario b) {
        return a.getItensCurtidos()
                .stream()
                .filter(b.getItensCurtidos()::contains)
                .count();
    }

}
