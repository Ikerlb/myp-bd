package mx.unam.ciencias.myp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Operaciones{

    private Connection conexion;
    private Statement sm;
    private ResultSet rs;

    public Operaciones(){
        try{
            Class.forName("org.sqlite.JDBC");
            conexion=DriverManager.getConnection("jdbc:sqlite:football.db");
            sm=conexion.createStatement();
        }
        catch(Exception e){System.out.println(e);}
    }

    public ResultSet buscaRapida(){
        return null;
    }

    public void cerrarConexion(){
        try{
          if(conexion!=null)
            conexion.close();
        }
        catch(SQLException e){System.err.println(e);}
    }

}
