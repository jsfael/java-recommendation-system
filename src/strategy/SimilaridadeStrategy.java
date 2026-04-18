package strategy;

import model.Usuario;

public interface SimilaridadeStrategy {

    double calcular(Usuario a, Usuario b);

}