package edu.ufp.esof.projeto_esoftware.services.filters;

import java.util.Set;

public interface FilterI<T> {
    Set<T> filter(Set<T> Entities);
}
