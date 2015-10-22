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
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class Controlador {

    private Operaciones op=new Operaciones();

    @FXML private Button btn1; //busqueda rapida
    @FXML private Button btn2; //abrir busqueda avanzada
    @FXML private Button doQuerry2; //boton para buscar dentro de la busqueda avanzada
    @FXML private Button addOpen;  //boton para abrir la ventana para agregar
    @FXML private TextField tf1;  //text field de busqueda rapida
    @FXML private ComboBox cbpos;
    @FXML private ComboBox cbpais;
    @FXML private ComboBox cbmes;
    @FXML private ComboBox cbanio;

    private void mensajeErrorEntradaVacia(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Entrada vacia");
        alert.setContentText("Intentaste hacer una busqueda con una entrada\n vacia. Prueba de nuevo");
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
        stage.setResizable(false);
        stage.setTitle("Busqueda Avanzada");
        stage.showAndWait();
    }

    public void cambiarVentanaResultados() throws Exception{
        Stage stage=(Stage)doQuerry2.getScene().getWindow();
        ClassLoader cl=getClass().getClassLoader();
        Parent root=FXMLLoader.load(cl.getResource("sbquerry.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Querry");
        stage.show();
    }

    public void abrirVentanaResultados() throws Exception{
        if(tf1.getText().trim().equals("")){
            mensajeErrorEntradaVacia();
            tf1.setText("");
        }
        else{
            Stage stage=new Stage();
            ClassLoader cl=getClass().getClassLoader();
            Parent root=FXMLLoader.load(cl.getResource("sbquerry.fxml"));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(btn1.getScene().getWindow());
            stage.setResizable(false);
            stage.setTitle("Querry");
            stage.showAndWait();
        }
    }

    public void abrirAgrega() throws Exception{
        Stage stage=new Stage();
        ClassLoader cl=getClass().getClassLoader();
        Parent root=FXMLLoader.load(cl.getResource("sbagregar.fxml"));
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(addOpen.getScene().getWindow());
        stage.setResizable(false);
        stage.setTitle("Agregar");
        stage.showAndWait();
    }

}
