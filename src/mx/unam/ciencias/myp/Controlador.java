package mx.unam.ciencias.myp;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.File;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import java.util.LinkedList;
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

    @FXML private Button btn1; //busqueda rapida
    //@FXML private Button btn2; //abrir busqueda avanzada
    @FXML private Button addOpen;  //boton para abrir la ventana para agregar
    @FXML private TextField tf1;  //text field de busqueda rapida
    private ScrollPane scrollPane;  //text field de busqueda rapida
    private LinkedList<Jugador> busquedaRapida;



    private void mensajeErrorEntradaVacia(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Entrada vacia");
        alert.setContentText("Intentaste hacer una busqueda con una entrada\n vacia. Prueba de nuevo");
        alert.showAndWait();
    }

    public void manejaBotonCerrar(){
        Platform.exit();
    }


    public void abrirVentanaResultados() throws Exception{
        if(tf1.getText().trim().equals("")){
            mensajeErrorEntradaVacia();
            tf1.setText("");
        }
        else{
            Stage stage=new Stage();
            ClassLoader cl=getClass().getClassLoader();
            FXMLLoader loader = new FXMLLoader(cl.getResource("sbquerry.fxml"));
            Parent root = (Parent) loader.load();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(btn1.getScene().getWindow());
            stage.setResizable(false);
            stage.setTitle("Querry");
            try{busquedaRapida=OperacionesDB.consultaRapida("select * from Jugador where Nombre like '%"+tf1.getText()+"%'");}
            catch(Exception e){System.out.println(e);}
            if(!busquedaRapida.isEmpty()){
                scrollPane=new ScrollPane();
                scrollPane.setPrefSize(750,500);
                scrollPane.setFitToWidth(true);
                stage.setScene(new Scene(scrollPane));
                int i=0;
                VBox vbox=new VBox();
                for(Jugador j:busquedaRapida)
                    llenaPane(new TitledPane(),j,vbox);
            }
            stage.showAndWait();
        }
    }

    private void llenaPane(TitledPane tp,Jugador jug,VBox v){
        HBox hbox=new HBox();
        tp.setText(jug.getNombre());
        Image image = new Image(new File(jug.getImagen()).toURI().toString());
        ImageView iv1 = new ImageView();
        iv1.setImage(image);
        iv1.setFitWidth(125);
        iv1.setFitHeight(125);
        VBox vbox=new VBox();
        Label label=new Label("   Nombre: "+jug.getNombre());
        Label label2=new Label("\n\n   Año de nacimiento: "+jug.getAñoNacimiento());
        Label label3=new Label("\n\n   Pais de nacimiento: "+jug.getPais());
        vbox.getChildren().addAll(label,label2,label3);
        VBox vbox2=new VBox();
        Label label4=new Label("\t\t\tPosicion: "+jug.getPosicion());
        Label label5=new Label("\n\n\n\n\n\t\t\tEquipo Actual: "+jug.getEquipoActual());
        vbox2.getChildren().addAll(label4,label5);
        hbox.getChildren().addAll(iv1,vbox,vbox2);
        tp.setContent(hbox);
        v.getChildren().addAll(tp);
        scrollPane.setContent(v);
    }

    public void abrirAgrega() throws Exception{
        Stage stage=new Stage();
        ClassLoader cl=getClass().getClassLoader();
        FXMLLoader loader = new FXMLLoader(cl.getResource("sbagregar.fxml"));
        Parent root = (Parent) loader.load();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(addOpen.getScene().getWindow());
        stage.setResizable(false);
        stage.setTitle("Agregar");
        stage.showAndWait();
    }


}
