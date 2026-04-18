package service;

import model.Usuario;
import strategy.SimilaridadeStrategy;

import java.util.HashMap;
import java.util.Map;

public class SistemaRecomendacao {

    private final SimilaridadeStrategy strategy;
    private final Map<String, Usuario> usuarios;

    public SistemaRecomendacao(SimilaridadeStrategy strategy){
        this.strategy = strategy;
        usuarios = new HashMap<>();
    }

    public void adicionarUsuario(String nome){
        usuarios.putIfAbsent(nome, new Usuario(nome));
    }

}
