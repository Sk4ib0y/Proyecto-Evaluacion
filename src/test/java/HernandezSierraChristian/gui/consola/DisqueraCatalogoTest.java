package HernandezSierraChristian.gui.consola;

import HernandezSierraChristian.model.Artista;
import HernandezSierraChristian.model.Disco;
import HernandezSierraChristian.model.Disquera;
import HernandezSierraChristian.repository.jdbc.ArtistaJDBC;
import HernandezSierraChristian.repository.jdbc.DisqueraJDBC;
import HernandezSierraChristian.repository.jdbc.implement.ArtistaJDBCImpl;
import HernandezSierraChristian.repository.jdbc.implement.DisqueraJDBCImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraCatalogoTest {

    @Test
    void getInstance() {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        assertNotNull(disqueraCatalogo);
    }

    @Test
    void newT() {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        Disquera disquera = disqueraCatalogo.newT();
        assertNotNull(disquera);
    }

    @Test
    void processNewT() {
        Disquera disquera = new Disquera();
        boolean res = false;
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        disquera.setNombre("Sony");
        res = disqueraJDBC.save(disquera);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setNombre("Sony");
        disquera.setId(1);
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        res = disqueraJDBC.update(disquera);
        assertEquals(true, res);
    }

    @Test
    void processList() {
        DisqueraCatalogo disqueraCatalogo = DisqueraCatalogo.getInstance();
        List<Disquera> disqueras =  disqueraCatalogo.processList( );
        disqueras.forEach(System.out::println);
    }
}