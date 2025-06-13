package HernandezSierraChristian.gui.consola;

import HernandezSierraChristian.model.Disquera;
import HernandezSierraChristian.model.Genero;
import HernandezSierraChristian.repository.jdbc.DisqueraJDBC;
import HernandezSierraChristian.repository.jdbc.GeneroJDBC;
import HernandezSierraChristian.repository.jdbc.implement.DisqueraJDBCImpl;
import HernandezSierraChristian.repository.jdbc.implement.GeneroJDBCImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroCatalogoTest {

    @Test
    void getInstance() {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        assertNotNull(generoCatalogo);
    }

    @Test
    void newT() {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        Genero genero = generoCatalogo.newT();
        assertNotNull(genero);
    }

    @Test
    void processNewT() {
        Genero genero= new Genero();
        boolean res = false;
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        genero.setDescripcion("Metal");
        res = generoJDBC.save(genero);
        assertEquals(true, res);
    }

    @Test
    void processEditT() {
        Genero genero = new Genero();
        boolean res = false;
        genero.setDescripcion("Sony");
        genero.setId(1);
        GeneroJDBC generoJDBC = GeneroJDBCImpl.getInstance();
        res = generoJDBC.update(genero);
        assertEquals(true, res);
    }

    @Test
    void processList() {
        GeneroCatalogo generoCatalogo = GeneroCatalogo.getInstance();
        List<Genero> generos =  generoCatalogo.processList( );
        generos.forEach(System.out::println);
    }
}