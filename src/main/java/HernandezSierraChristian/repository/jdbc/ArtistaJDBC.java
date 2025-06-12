package HernandezSierraChristian.repository.jdbc;

import HernandezSierraChristian.model.Artista;

import java.util.List;

public interface ArtistaJDBC
{
    List<Artista> findAll();
    Artista findById(Integer id);
    boolean save(Artista artista);
    boolean update(Artista artista);
    boolean delete(Artista artista);
}
