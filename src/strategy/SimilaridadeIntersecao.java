package strategy;

import model.Item;
import model.Usuario;

import java.util.HashSet;
import java.util.Set;

public class SimilaridadeIntersecao implements SimilaridadeStrategy{

    @Override
    public double calcular(Usuario a, Usuario b) {
        Set<Item> intersecao = new HashSet<>(a.getItensCurtidos());

        intersecao.retainAll(b.getItensCurtidos());

        return intersecao.size();
    }

}
