package app;

import model.Item;
import model.TipoItem;
import service.ItemCatalog;
import service.SistemaRecomendacao;
import strategy.filtro.FiltroCategoria;
import strategy.filtro.FiltroNenhum;
import strategy.filtro.FiltroTipo;
import strategy.similaridade.SimilaridadeCategoriaJaccard;
import strategy.similaridade.SimilaridadeItemDice;
import strategy.similaridade.SimilaridadeItemJaccard;

public class Main {

    public static void main(String[] args) {

        ItemCatalog catalog = new ItemCatalog();

        catalog.adicionarItem(new Item("1", "Inception",         TipoItem.FILME,  "ficcao",   1.0));
        catalog.adicionarItem(new Item("2", "Matrix",            TipoItem.FILME,  "acao",     1.0));
        catalog.adicionarItem(new Item("3", "Dunkirk",           TipoItem.FILME,  "guerra",   1.0));
        catalog.adicionarItem(new Item("4", "Bohemian Rhapsody", TipoItem.MUSICA, "rock",     1.0));
        catalog.adicionarItem(new Item("5", "Thriller",          TipoItem.MUSICA, "pop",      1.0));
        catalog.adicionarItem(new Item("6", "1984",              TipoItem.LIVRO,  "distopia", 1.0));
        catalog.adicionarItem(new Item("7", "Duna",              TipoItem.LIVRO,  "ficcao",   1.0));

        // jaccard sem filtro
        SistemaRecomendacao jaccard = new SistemaRecomendacao(new SimilaridadeItemJaccard(), new FiltroNenhum(), catalog);
        jaccard.adicionarUsuario("Ana");
        jaccard.adicionarUsuario("Bob");
        jaccard.adicionarUsuario("Carlos");

        jaccard.curtirItem("Ana", "1");
        jaccard.curtirItem("Ana", "2");

        jaccard.curtirItem("Bob", "1");
        jaccard.curtirItem("Bob", "2");
        jaccard.curtirItem("Bob", "3");
        jaccard.curtirItem("Bob", "4");

        jaccard.curtirItem("Carlos", "1");
        jaccard.curtirItem("Carlos", "6");
        jaccard.curtirItem("Carlos", "7");

        System.out.println("jaccard, sem filtro:");
        jaccard.recomendar("Ana").forEach(r ->
                System.out.printf("  %s — %.2f%n", r.item().getNome(), r.score()));

        // dice sem filtro
        SistemaRecomendacao dice = new SistemaRecomendacao(new SimilaridadeItemDice(), new FiltroNenhum(), catalog);
        dice.adicionarUsuario("Ana");
        dice.adicionarUsuario("Bob");
        dice.adicionarUsuario("Carlos");

        dice.curtirItem("Ana", "1");
        dice.curtirItem("Ana", "2");

        dice.curtirItem("Bob", "1");
        dice.curtirItem("Bob", "2");
        dice.curtirItem("Bob", "3");
        dice.curtirItem("Bob", "4");

        dice.curtirItem("Carlos", "1");
        dice.curtirItem("Carlos", "6");
        dice.curtirItem("Carlos", "7");

        System.out.println("\ndice, sem filtro:");
        dice.recomendar("Ana").forEach(r ->
                System.out.printf("  %s — %.2f%n", r.item().getNome(), r.score()));

        // jaccard, so filmes
        SistemaRecomendacao porTipo = new SistemaRecomendacao(new SimilaridadeItemJaccard(), new FiltroTipo(TipoItem.FILME), catalog);
        porTipo.adicionarUsuario("Ana");
        porTipo.adicionarUsuario("Bob");

        porTipo.curtirItem("Ana", "1");
        porTipo.curtirItem("Ana", "2");

        porTipo.curtirItem("Bob", "1");
        porTipo.curtirItem("Bob", "2");
        porTipo.curtirItem("Bob", "3");
        porTipo.curtirItem("Bob", "4");

        System.out.println("\njaccard, so filmes:");
        porTipo.recomendar("Ana").forEach(r ->
                System.out.printf("  %s — %.2f%n", r.item().getNome(), r.score()));

        // jaccard, categoria ficcao
        SistemaRecomendacao porCategoria = new SistemaRecomendacao(new SimilaridadeItemJaccard(), new FiltroCategoria("ficcao"), catalog);
        porCategoria.adicionarUsuario("Ana");
        porCategoria.adicionarUsuario("Bob");

        porCategoria.curtirItem("Ana", "1");
        porCategoria.curtirItem("Ana", "2");

        porCategoria.curtirItem("Bob", "1");
        porCategoria.curtirItem("Bob", "2");
        porCategoria.curtirItem("Bob", "3");
        porCategoria.curtirItem("Bob", "7");

        System.out.println("\njaccard, categoria ficcao:");
        porCategoria.recomendar("Ana").forEach(r ->
                System.out.printf("  %s — %.2f%n", r.item().getNome(), r.score()));

        // jaccard por categoria, sem filtro
        SistemaRecomendacao categoriaJaccard = new SistemaRecomendacao(new SimilaridadeCategoriaJaccard(), new FiltroNenhum(), catalog);
        categoriaJaccard.adicionarUsuario("Ana");
        categoriaJaccard.adicionarUsuario("Bob");

        categoriaJaccard.curtirItem("Ana", "1");
        categoriaJaccard.curtirItem("Ana", "2");

        categoriaJaccard.curtirItem("Bob", "1");
        categoriaJaccard.curtirItem("Bob", "3");
        categoriaJaccard.curtirItem("Bob", "7");

        System.out.println("\njaccard por categoria, sem filtro:");
        categoriaJaccard.recomendar("Ana").forEach(r ->
                System.out.printf("  %s — %.2f%n", r.item().getNome(), r.score()));
    }
}