package org.gui.consola;

import org.ReadUtil.ReadUtil;
import org.model.Disquera;
import org.repository.jdbc.DisqueraJDBC;
import org.repository.jdbc.implement.DisqueraJDBCImpl;

import java.util.List;

public class DisqueraCatalogo extends Catalogos<Disquera>
{
    private static DisqueraCatalogo disqueraCatalogo;
    private static DisqueraJDBC disqueraJDBC;

    public DisqueraCatalogo() {
        super();
    }

    public static DisqueraCatalogo getInstance(){
        if (disqueraCatalogo==null){
            disqueraCatalogo=new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT() {
        return new Disquera();
    }

    @Override
    public boolean processNewT(Disquera disquera) {
        System.out.println("Teclee una disquera");
        disquera.setNombre(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Disquera disquera)
    {
        System.out.println("-------------------");
        System.out.println("Id de la disquera "+disquera.getId());
        System.out.println("Disquera a editar: " + disquera.getNombre());
        System.out.println("Teclee el valor nuevo de la disquera");
        System.out.println("-------------------");
        disquera.setNombre(ReadUtil.read());
    }

    @Override
    public List<Disquera> processList()
    {
        if(disqueraJDBC==null)
        {
            if(!loadDisqueraJDBC())
            {
                System.out.println("Error al cargar DisqueraJDBC");
            }
        }
        return disqueraJDBC.findAll();
    }

    private boolean loadDisqueraJDBC()
    {
        disqueraJDBC= DisqueraJDBCImpl.getInstance();
        return disqueraJDBC!=null;
    }
}
