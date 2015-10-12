package mx.unam.ciencias.myp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Proyecto2 extends Application{

    public void start(Stage primaryStage) throws Exception{
        ClassLoader cl=getClass().getClassLoader();
        Parent root=FXMLLoader.load(cl.getResource("sbhome.fxml"));
        primaryStage.setTitle("Proyecto2");
        primaryStage.setScene(new Scene(root,800,500));
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
