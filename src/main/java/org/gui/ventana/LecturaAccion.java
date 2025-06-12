package org.gui.ventana;

import org.ReadUtil.ReadUtil;
import org.negocio.Ejecutable;

public abstract class LecturaAccion implements Ejecutable
{
    protected Integer opcion;
    protected boolean flag;

    public LecturaAccion(){flag=true;}

    public abstract void despliegaMenu();
    public abstract int valorMinMenu();
    public abstract int valorMaxMenu();
    public abstract void procesaOpcion();

    @Override
    public void run()
    {
        while (flag)
        {
            despliegaMenu();
            opcion = ReadUtil.readInt();
            if(opcion>=valorMinMenu() && opcion<=valorMaxMenu())
            {
                if (opcion==valorMaxMenu())
                {
                    flag=false;
                }
                else
                {
                    procesaOpcion();
                }
            }
        }
    }

    @Override
    public void setFlag(boolean flag) {
        this.flag=flag;
    }
}
