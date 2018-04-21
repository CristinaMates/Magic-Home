package ro.challenge.accepted.magichome.dao;

import java.util.List;

public interface AbstractDAO<T> {
    List<T> getAll();

    T create(T c);
}
