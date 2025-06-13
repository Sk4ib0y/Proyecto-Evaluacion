package HernandezSierraChristian.gui.consola;

import HernandezSierraChristian.model.Artista;
import HernandezSierraChristian.model.Disco;
import HernandezSierraChristian.model.Disquera;
import HernandezSierraChristian.model.Genero;
import HernandezSierraChristian.repository.jdbc.DiscoJDBC;
import HernandezSierraChristian.repository.jdbc.implement.ArtistaJDBCImpl;
import HernandezSierraChristian.repository.jdbc.implement.DiscoJDBCImpl;
import HernandezSierraChristian.repository.jdbc.implement.DisqueraJDBCImpl;
import HernandezSierraChristian.repository.jdbc.implement.GeneroJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoCatalogoTest {

    @Test
    void getInstance() {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        assertNotNull(discoCatalogo);
    }

    @Test
    void newT() {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        Disco disco = discoCatalogo.newT();
        assertNotNull(disco);
    }

    @Test
    void processNewT() {
        Disco disco = new Disco();
        boolean res = false;
        Artista artista=ArtistaJDBCImpl.getInstance().findById(1);
        Disquera disquera=DisqueraJDBCImpl.getInstance().findById(1);
        Genero genero=GeneroJDBCImpl.getInstance().findById(1);
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        disco.setTitulo("Heaven & Hell");
        disco.setPrecio(12.75F);
        disco.setExistencia(3590);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("1998-10-24").toLocalDate());
        disco.setImagen("imagen1");
        disco.setArtista(artista);
        disco.setDisquera(disquera);
        disco.setGenero(genero);
        res = discoJDBC.save(disco);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Disco disco = new Disco();
        boolean res = false;
        Artista artista=ArtistaJDBCImpl.getInstance().findById(1);
        Disquera disquera=DisqueraJDBCImpl.getInstance().findById(1);
        Genero genero=GeneroJDBCImpl.getInstance().findById(1);
        DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
        disco.setTitulo("Heaven & Hell");
        disco.setPrecio(12.75F);
        disco.setExistencia(3590);
        disco.setDescuento(0);
        disco.setFecha(Date.valueOf("1998-10-24").toLocalDate());
        disco.setImagen("imagen2");
        disco.setArtista(artista);
        disco.setDisquera(disquera);
        disco.setGenero(genero);
        disco.setId(1);
        res = discoJDBC.update(disco);
        assertEquals(true, res);
    }

    @Test
    void processList() {
        DiscoCatalogo discoCatalogo = DiscoCatalogo.getInstance();
        List<Disco> disco =  discoCatalogo.processList( );
        disco.forEach(System.out::println);
    }


}