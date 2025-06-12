package org.repository.jdbc;

import org.model.Artista;

import java.util.List;

public interface ArtistaJDBC
{
    List<Artista> findAll();
    Artista findById(Integer id);
    boolean save(Artista artista);
    boolean update(Artista artista);
    boolean delete(Artista artista);
}
