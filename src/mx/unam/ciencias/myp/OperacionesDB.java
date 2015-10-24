package mx.unam.ciencias.myp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/** Clase que se encarga de todo el contacto con la base de datos
  * maneja todas las consultas y agregaciones
  * @author Iker Lissarrague
  * @version 1
  */
public class OperacionesDB{

    /** Metodo consultaColumna.
      * @param instruccion a consultar.
      * @return LinkedList<String> varias instancias con una sola columna.
      * @throws error en la conexion con la base de datos
      */
    public static LinkedList<String> consultaColumna(String instruccion,String columna)throws Exception{
        LinkedList<String> lista=new LinkedList<String>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        ResultSet rs=null;
        try {
          // create a database connection
          connection=DriverManager.getConnection("jdbc:sqlite:football.db");   //RUTA A LA BASE
          Statement statement=connection.createStatement();
          statement.setQueryTimeout(30);
          rs = statement.executeQuery(instruccion);
          while(rs.next())
            lista.add(rs.getString(columna));
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            System.err.println(e);
          }
        }
        return lista;
    }

    /** Metodo consultaRapida.
      * @param instruccion a consultar.
      * @return LinkedList<Jugador> varias instancias de la clase jugador.
      * @throws error en la conexion con la base de datos
      */
    public static LinkedList<Jugador> consultaRapida(String instruccion)throws Exception{
        LinkedList<Jugador> lista=new LinkedList<Jugador>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        ResultSet rs=null;
        try {
          // create a database connection
          connection=DriverManager.getConnection("jdbc:sqlite:football.db");   //RUTA A LA BASE
          Statement statement=connection.createStatement();
          statement.setQueryTimeout(30);
          rs = statement.executeQuery(instruccion);
          while(rs.next())
            lista.add(new Jugador(rs.getString("Imagen"),rs.getString("Nombre"),rs.getInt("FechaNacimiento"),rs.getString("Pais"),rs.getString("Posicion"),rs.getString("EquipoActual")));
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            System.err.println(e);
          }
        }
        return lista;
    }


    /** Metodo agregaGeneral.
      * @param instruccion a agregar.
      * @return boolean hubo exito o no.
      * @throws error en la conexion con la base de datos
      */
    public static boolean agregaGeneral(String instruccion)throws Exception{
        Class.forName("org.sqlite.JDBC");
        Connection connection = null;
        ResultSet rs=null;
        try {
          // create a database connection
          connection=DriverManager.getConnection("jdbc:sqlite:football.db");   //RUTA A LA BASE
          Statement statement=connection.createStatement();
          statement.setQueryTimeout(30);
          statement.executeUpdate(instruccion);
        }
        catch(SQLException e)
        {
          System.err.println(e.getMessage());
          return false;
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            System.err.println(e);
            return false;
          }
        }
        return true;
    }


}
