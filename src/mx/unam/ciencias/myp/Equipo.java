package mx.unam.ciencias.myp;

public class Equipo{
    private String imagen;
    private String nombre;
    private int añoFundacion;
    private String liga;

    public void setImagen(String imagen){
        this.imagen=imagen;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setAñoFundacion(int añoFundacion){
        this.añoFundacion=añoFundacion;
    }

    public void setLiga(String liga){
        this.liga=liga;
    }

    public String toString(){
        return nombre.toString();
    }
}
