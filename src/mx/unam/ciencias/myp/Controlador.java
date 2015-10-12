package mx.unam.ciencias.myp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Controlador {

    public void prueba(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }
}
