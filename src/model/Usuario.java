package model;

import java.util.HashSet;
import java.util.Set;

public class Usuario {

    private final String nome;
    private final Set<Item> itensCurtidos;

    public Usuario(String nome) {
        this.nome = nome;
        this.itensCurtidos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public Set<Item> getItensCurtidos() {
        return itensCurtidos;
    }

    public void curtirItem(Item item) {
        itensCurtidos.add(item);
    }
}