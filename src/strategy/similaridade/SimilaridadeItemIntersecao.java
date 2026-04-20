package strategy.similaridade;

import model.Usuario;

public class SimilaridadeItemIntersecao implements SimilaridadeStrategy{

    @Override
    public double calcular(Usuario a, Usuario b) {
        return a.getItensCurtidos()
                .stream()
                .filter(b.getItensCurtidos()::contains)
                .count();
    }

}
