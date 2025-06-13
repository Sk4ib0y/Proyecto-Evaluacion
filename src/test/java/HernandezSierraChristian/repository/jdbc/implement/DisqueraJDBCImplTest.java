package HernandezSierraChristian.repository.jdbc.implement;

import HernandezSierraChristian.model.Disquera;
import HernandezSierraChristian.repository.jdbc.DisqueraJDBC;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraJDBCImplTest {

    @Test
    void getInstance() {assertNotNull(DisqueraJDBCImpl.getInstance());    }

    @Test
    void findAll() {
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        List<Disquera> list = disqueraJDBC.findAll();
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
        Disquera disquera = new Disquera();
        boolean res = false;
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        disquera.setNombre("Sony");
        res = disqueraJDBC.save(disquera);
        assertEquals(true, res);
    }

    @Test
    void update() {
        Disquera disquera = new Disquera();
        boolean res = false;
        disquera.setNombre("Universal");
        disquera.setId(1);
        DisqueraJDBC disqueraJDBC = DisqueraJDBCImpl.getInstance();
        res = disqueraJDBC.update(disquera);
        assertEquals(true, res);
    }

}