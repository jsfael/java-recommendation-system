package model;

import java.util.Objects;

public record Recomendacao(Item item, double score) {
    public Recomendacao {
        Objects.requireNonNull(item, "Item não pode ser nulo");
        if (score < 0) throw new IllegalArgumentException("Score não pode ser negativo");
    }
}
