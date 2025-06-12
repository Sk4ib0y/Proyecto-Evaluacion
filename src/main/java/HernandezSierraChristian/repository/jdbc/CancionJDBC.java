package HernandezSierraChristian.repository.jdbc;

import HernandezSierraChristian.model.Cancion;

import java.util.List;

public interface CancionJDBC {
    List<Cancion> findAll();
    Cancion findById(Integer id);
    boolean save(Cancion cancion);
    boolean update(Cancion cancion);
    boolean delete(Cancion cancion);
}