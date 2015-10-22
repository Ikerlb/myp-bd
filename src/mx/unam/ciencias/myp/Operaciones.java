package mx.unam.ciencias.myp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operaciones extends Thread{

    private Connection conexion;
    private Statement sm;
    private ResultSet rs;
    private String instruccion;
    private Boolean update;

    public Operaciones(){
        try{
            Class.forName("org.sqlite.JDBC");
            conexion=DriverManager.getConnection("jdbc:sqlite:football.db");
            sm=conexion.createStatement();
        }
        catch(Exception e){System.out.println(e);}
    }


    public void setInstruccion(String instruccion){
        this.instruccion=instruccion;
    }


    @Override public void run(){
        try{
            if(update)
                sm.executeUpdate(instruccion);
            else
                sm.executeQuery(instruccion);
        }catch(Exception e){System.out.println(e);}
        finally{
            try{
                sm.closeOnCompletion();
            }catch(Exception e){System.out.println(e);}
        }
    }

    public ResultSet query(String instruccion){
        this.instruccion=instruccion;
        start();
        return rs;
    }

    public void agrega(String instruccion){
        this.instruccion=instruccion;
        update=true;
        start();
        update=false;
    }

    public void cerrarConexion(){
        try{
          if(conexion!=null)
            conexion.close();
        }
        catch(SQLException e){System.err.println(e);}
    }

}
