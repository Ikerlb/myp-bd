package mx.unam.ciencias.myp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

/** Inicializar vista.
  * Inicializa la vista del programa.
  * @author Iker Lissarrague
  * @version 1
  */
public class Proyecto2 extends Application{

    private Controlador controller;

    /** Metodo start.
      * @param Stage inicial.
      * @throws error abriendo un fxml
      */
    @Override public void start(Stage primaryStage) throws Exception{
        ClassLoader cl=getClass().getClassLoader();
        FXMLLoader loader = new FXMLLoader(cl.getResource("sbhome.fxml"));
        Parent root = (Parent) loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Proyecto2");
        primaryStage.setScene(new Scene(root,800,500));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
