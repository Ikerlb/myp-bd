package mx.unam.ciencias.myp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Proyecto2 extends Application{

    private Controlador controller;

    public void start(Stage primaryStage) throws Exception{
        ClassLoader cl=getClass().getClassLoader();
        //Parent root=FXMLLoader.load(cl.getResource("sbhome.fxml"));
        FXMLLoader loader = new FXMLLoader(cl.getResource("sbhome.fxml"));
        Parent root = (Parent) loader.load();
        controller = loader.getController();
        primaryStage.setTitle("Proyecto2");
        primaryStage.setScene(new Scene(root,800,500));
        primaryStage.show();
    }

    public void stop(){
        controller.cerrarConexion();
        //System.out.println("Closing");
    }

    public static void main(String[] args){
        launch(args);
    }
}
