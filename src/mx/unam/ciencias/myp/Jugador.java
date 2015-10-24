package mx.unam.ciencias.myp;

/** Clase jugador para facilitar el uso de la base de datos.
  * @author Iker Lissarrague
  * @version 1
  */
public class Jugador{
    private String imagen;
    private String nombre;
    private int añoNacimiento;
    private String pais;
    private String posicion;
    private String equipoActual;

    /** Metodo getImagen
      *Getter de imagen
      @param imagen la ruta de la imagen
      @param nombre el nombre de el jugador
      @param añoNacimiento el año de nacimiento
      @param pais de origen
      @param posicion la posicion que ocupa el jugador en el campo
      @param equipoActual el equipo en donde milita actualmente el jugador
      */
    public Jugador(String imagen,String nombre,int añoNacimiento,String pais,String posicion,String equipoActual){
        this.imagen=imagen;
        this.nombre=nombre;
        this.añoNacimiento=añoNacimiento;
        this.pais=pais;
        this.posicion=posicion;
        this.equipoActual=equipoActual;
    }

    /** Metodo getImagen
      *Getter de imagen
      * @return String ruta de la imagen..
      */
    public String getImagen(){
        return imagen;
    }

    /** Metodo getNombre
      *Getter de nombre
      * @return String nombre del jugador..
      */
    public String getNombre(){
        return nombre;
    }

    /** Metodo getAñoNacimiento
      *Getter de añoNacimiento
      * @return int el año de nacimiento del jugador..
      */
    public int getAñoNacimiento(){
        return añoNacimiento;
    }

    /** Metodo getPais
      *Getter de pais
      * @return String pais de nacimiento..
      */
    public String getPais(){
        return pais;
    }

    /** Metodo getPosicion
      *Getter de la posicion del jugador
      * @return String posicion del jugador..
      */
    public String getPosicion(){
        return posicion;
    }

    /** Metodo getEquipoActual
      *Getter de el equipo actual
      * @return String el equipo actual del jugador..
      */
    public String getEquipoActual(){
        return equipoActual;
    }

}
