package mx.unam.ciencias.myp;

/** Clase equipo para facilitar el uso de la base de datos.
  * @author Iker Lissarrague
  * @version 1
  */
public class Equipo{
    private String imagen;
    private String nombre;
    private int añoFundacion;
    private String liga;

    /** Metodo setImagen
      *Setter de imagen
      * @param args String ruta de la imagen..
      */
    public void setImagen(String imagen){
        this.imagen=imagen;
    }

    /** Metodo setNombre
      *Setter de nombre
      * @param args String de el nombre..
      */
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    /** Metodo setAñoFundacion
      *Setter de añoFudacion
      * @param args int el añoFundacion..
      */
    public void setAñoFundacion(int añoFundacion){
        this.añoFundacion=añoFundacion;
    }

    /** Metodo setLiga
      *Setter de liga
      * @param args String el nombre de la liga..
      */
    public void setLiga(String liga){
        this.liga=liga;
    }
}
