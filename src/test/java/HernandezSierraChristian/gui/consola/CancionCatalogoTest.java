package HernandezSierraChristian.gui.consola;

import HernandezSierraChristian.model.Cancion;
import HernandezSierraChristian.model.Disco;
import HernandezSierraChristian.repository.jdbc.CancionJDBC;
import HernandezSierraChristian.repository.jdbc.implement.CancionJDBCImpl;
import HernandezSierraChristian.repository.jdbc.implement.DiscoJDBCImpl;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class CancionCatalogoTest {

    @Test
    void getInstance() {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        assertNotNull(cancionCatalogo);
    }

    @Test
    void newT() {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        Cancion cancion = cancionCatalogo.newT();
        assertNotNull(cancion);
    }

    @Test
    void processNewT() {
        Cancion cancion = new Cancion();
        Disco disco= DiscoJDBCImpl.getInstance().findById(1);
        boolean res = false;
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        cancion.setTitulo("Pompeji");
        cancion.setDuracion(Time.valueOf("00:02:32"));
        cancion.setDisco(disco);
        res = cancionJDBC.save(cancion);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Cancion cancion = new Cancion();
        Disco disco= DiscoJDBCImpl.getInstance().findById(1);
        boolean res = false;
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        cancion.setTitulo("Fade to Black");
        cancion.setDuracion(Time.valueOf("00:02:32"));
        cancion.setDisco(disco);
        res = cancionJDBC.save(cancion);
        assertEquals(true, res);
    }

    @Test
    void processList() {
        CancionCatalogo cancionCatalogo = CancionCatalogo.getInstance();
        List<Cancion> cancion =  cancionCatalogo.processList( );
        cancion.forEach(System.out::println);
    }
}