package mx.unam.ciencias.myp;
public class Jugador{
    private String imagen;
    private String nombre;
    private int añoNacimiento;
    private String pais;
    private String posicion;
    private String equipoActual;

    public Jugador(String imagen,String nombre,int añoNacimiento,String pais,String posicion,String equipoActual){
        this.imagen=imagen;
        this.nombre=nombre;
        this.añoNacimiento=añoNacimiento;
        this.pais=pais;
        this.posicion=posicion;
        this.equipoActual=equipoActual;
    }

    public String toString(){
        return nombre.toString();
    }

    public String getImagen(){
        return imagen;
    }

    public String getNombre(){
        return nombre;
    }

    public int getAñoNacimiento(){
        return añoNacimiento;
    }

    public String getPais(){
        return pais;
    }

    public String getPosicion(){
        return posicion;
    }

    public String getEquipoActual(){
        return equipoActual;
    }

}
