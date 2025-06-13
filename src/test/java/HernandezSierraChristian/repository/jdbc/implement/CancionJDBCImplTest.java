package HernandezSierraChristian.repository.jdbc.implement;

import HernandezSierraChristian.model.Cancion;
import HernandezSierraChristian.model.Disco;
import HernandezSierraChristian.repository.jdbc.CancionJDBC;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CancionJDBCImplTest {

    @Test
    void getInstance() {assertNotNull(CancionJDBCImpl.getInstance());
    }

    @Test
    void findAll() {
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        List<Cancion> list = cancionJDBC.findAll();
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
    void save() {
        Cancion cancion = new Cancion();
        boolean res = false;
        Disco disco=DiscoJDBCImpl.getInstance().findById(1);
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        cancion.setTitulo("Daddy");
        cancion.setDuracion(Time.valueOf("00:17:42"));
        cancion.setDisco(disco);
        res = cancionJDBC.save(cancion);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Cancion cancion = new Cancion();
        boolean res = false;
        Disco disco=DiscoJDBCImpl.getInstance().findById(1);
        cancion.setTitulo("Ghost");
        cancion.setDuracion(Time.valueOf("00:03:40"));
        cancion.setDisco(disco);
        cancion.setId(1);
        CancionJDBC cancionJDBC = CancionJDBCImpl.getInstance();
        res = cancionJDBC.update(cancion);
        assertEquals(true, res);
    }

}