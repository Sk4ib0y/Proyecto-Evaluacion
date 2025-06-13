package HernandezSierraChristian.repository.jdbc.implement;

import HernandezSierraChristian.model.Artista;
import HernandezSierraChristian.model.Disco;
import HernandezSierraChristian.model.Disquera;
import HernandezSierraChristian.model.Genero;
import HernandezSierraChristian.repository.jdbc.DiscoJDBC;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoJDBCImplTest {

        @Test
        void getInstance() { assertNotNull(DiscoJDBCImpl.getInstance()); }

        @Test
        void findAll() {
            DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
            List<Disco> list = discoJDBC.findAll();
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
            Disco disco = new Disco();
            boolean res = false;
            Artista artista=ArtistaJDBCImpl.getInstance().findById(1);
            Disquera disquera=DisqueraJDBCImpl.getInstance().findById(1);
            Genero genero=GeneroJDBCImpl.getInstance().findById(1);
            DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
            disco.setTitulo("Ohms");
            disco.setPrecio(24.75F);
            disco.setExistencia(490);
            disco.setDescuento(0);
            disco.setFecha(Date.valueOf("2020-04-20").toLocalDate());
            disco.setImagen("Mascara");
            disco.setArtista(artista);
            disco.setDisquera(disquera);
            disco.setGenero(genero);
            res = discoJDBC.save(disco);
            assertEquals(true, res);
        }

        @Test
        void update() {
            Disco disco = new Disco();
            boolean res = false;
            Artista artista=ArtistaJDBCImpl.getInstance().findById(1);
            Disquera disquera=DisqueraJDBCImpl.getInstance().findById(1);
            Genero genero=GeneroJDBCImpl.getInstance().findById(1);
            DiscoJDBC discoJDBC = DiscoJDBCImpl.getInstance();
            disco.setTitulo("White Pony");
            disco.setPrecio(53.24F);
            disco.setExistencia(90);
            disco.setDescuento(0);
            disco.setFecha(Date.valueOf("2000-09-04").toLocalDate());
            disco.setImagen("Pony");
            disco.setArtista(artista);
            disco.setDisquera(disquera);
            disco.setGenero(genero);
            disco.setId(1);
            res = discoJDBC.update(disco);
            assertEquals(true, res);
        }

    }