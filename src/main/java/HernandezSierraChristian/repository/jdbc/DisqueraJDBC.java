package HernandezSierraChristian.repository.jdbc;

import HernandezSierraChristian.model.Disquera;

import java.util.List;

public interface DisqueraJDBC
{

        List<Disquera> findAll();
        Disquera findById(Integer id);
        boolean save(Disquera disquera);
        boolean update(Disquera disquera);
        boolean delete(Disquera disquera);

}
