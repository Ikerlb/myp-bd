package mx.unam.ciencias.myp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.fxml.FXML;

public class Controlador {

    private Operaciones op=new Operaciones();

    @FXML private Button btn2; //advanced search button

    public void prueba(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Look, an Information Dialog");
        alert.setContentText("I have a great message for you!");

        alert.showAndWait();
    }

    public void manejaBotonCerrar(){
        op.cerrarConexion();
        Platform.exit();
    }

    public void cerrarConexion(){
        op.cerrarConexion();
    }

    public void abrirBusquedaAvanzada() throws Exception{
        Stage stage=new Stage();
        ClassLoader cl=getClass().getClassLoader();
        Parent root=FXMLLoader.load(cl.getResource("sbadvs.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(btn2.getScene().getWindow());
        stage.showAndWait();
    }
}
