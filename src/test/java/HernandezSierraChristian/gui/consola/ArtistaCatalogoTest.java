package HernandezSierraChristian.gui.consola;

import HernandezSierraChristian.model.Artista;
import HernandezSierraChristian.repository.jdbc.ArtistaJDBC;
import HernandezSierraChristian.repository.jdbc.implement.ArtistaJDBCImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArtistaCatalogoTest {

    @Test
    void getInstance()
    {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        assertNotNull(artistaCatalogo);
    }

    @Test
    void newT() {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        Artista artista = artistaCatalogo.newT();
        assertNotNull(artista);
    }

    @Test
    void processNewT() {
        Artista artista = new Artista();
        boolean res = false;
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        artista.setNombre("Megadeth");
        res = artistaJDBC.save(artista);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Artista artista = new Artista();
        boolean res = false;
        artista.setNombre("Nirvana");
        artista.setId(1);
        ArtistaJDBC artistaJDBC = ArtistaJDBCImpl.getInstance();
        res = artistaJDBC.update(artista);
        assertEquals(true, res);
    }

    @Test
    void processList()
    {
        ArtistaCatalogo artistaCatalogo = ArtistaCatalogo.getInstance();
        List<Artista> artista =  artistaCatalogo.processList( );
        artista.forEach(System.out::println);
    }

}