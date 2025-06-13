package HernandezSierraChristian.repository.jdbc.implement;

import HernandezSierraChristian.model.Artista;
import HernandezSierraChristian.repository.jdbc.ArtistaJDBC;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaJDBCImplTest {

    @Test
    void getInstance() {assertNotNull(ArtistaJDBCImpl.getInstance());}

    @Test
    void findAll() {
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        List<Artista> list = artistaJDBC.findAll();
        if(list == null || list.isEmpty())
        {
            System.out.println("No hay elementos");
            return;
        }
        list.stream().forEach( e-> System.out.println(e.toString()));
        assertNotNull(list);
        assertTrue(list.size() >= 1);

    }

    @Test
    void savetest() {
        Artista artista = new Artista();
        boolean res = false;
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        artista.setNombre("Radiohead");
        res = artistaJDBC.save(artista);
        assertEquals(true, res);
    }

    @Test
    void updatetest() {
        Artista artista = new Artista();
        boolean res = false;
        artista.setNombre("Pixies");
        artista.setId(1);
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        res = artistaJDBC.update(artista);
        assertEquals(true, res);
    }

}