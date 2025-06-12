package HernandezSierraChristian.model;


import java.sql.Time;

public class Cancion extends Catalogo
{
    private String titulo;
    private Time duracion;
    private Disco disco;

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    public Cancion() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public Disco getDisco() {
        return disco;
    }

    public void setDisco(Disco disco) {
        this.disco = disco;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", duracion=" + duracion.getMinutes() +":"+ duracion.getSeconds()+
                ", id del disco=" + disco.getId()
                +", id Cancion="+id;
    }
}
