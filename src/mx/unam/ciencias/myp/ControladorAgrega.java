package mx.unam.ciencias.myp;

import javafx.stage.Stage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import java.util.LinkedList;
import java.sql.SQLException;
import java.sql.ResultSet;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.File;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.StackPane;
import javafx.scene.input.DragEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

/** Controlador para agregar equipos/jugadores.
  * maneja todos los eventos que ocurren al agregar
  * @author Iker Lissarrague
  * @version 1
  */
public class ControladorAgrega{

    //PESTANIA AGREGAR JUGADOR
    @FXML private StackPane stackPane1;
    @FXML private TextField nombreJugador;
    @FXML private TextField datePickerJugador;
    @FXML private ComboBox<String> comboPais;
    @FXML private ComboBox<String> comboPosicion;
    @FXML private ComboBox<String> comboEquipoActual;
    @FXML private ListView<String> columnaEquipos;
    @FXML private ComboBox<String> comboAgregarEquipo;
    @FXML private Button botonAgregarEquipoATabla;
    @FXML private Button botonAgregarJugador;
    private String rutaImagenJugador;

    //PESTANIA AGREGAR EQUIPO
    @FXML private StackPane stackPane2;
    @FXML private TextField nombreEquipo;
    @FXML private TextField datePickerEquipo;
    @FXML private ComboBox<String> comboTrofeos;
    @FXML private ComboBox<String> comboLiga;
    @FXML private ListView<String> columnaTrofeos;
    @FXML private Button botonAgregarTrofeo;
    @FXML private Button botonAgregarEquipo;
    private String rutaImagenEquipo;

    public void initialize(){
        getLigas();
        getPosiciones();
        getTrofeos();
        getEquipos();
        getPaises();
    }

        /**
     * Metodo onDragEnteredJugador
     * Maneja el evento de arrastrar una imagen de un jugador
     *
     */
    public void onDragEnteredJugador(DragEvent e){
        final Dragboard db = e.getDragboard();
        if(db.hasFiles()&&(db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg"))){
            final File file = db.getFiles().get(0);
            try {
                if(!stackPane2.getChildren().isEmpty())
                    stackPane2.getChildren().remove(0);
                String absPath=file.getAbsolutePath();
                Path src=Paths.get(absPath);
                rutaImagenJugador="dbimages/"+file.getName();
                Path targ=Paths.get("dbimages/"+file.getName());
                Files.copy(src,targ);
                Image img = new Image(new FileInputStream(absPath));
                System.out.println(file.getAbsolutePath());
                ImageView imageView = new ImageView();
                imageView.setFitWidth(200);
                imageView.setFitHeight(200);
                imageView.setImage(img);
                stackPane1.getChildren().add(imageView);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        e.consume();
        stackPane2.setStyle("-fx-border-color: #00FF00;");
    }

    /**
    * Metodo onDragExitedJugador
    * Maneja el evento despues de agregar una imagen de un jugador
    *
    */
    public void onDragExitedJugador(){
        stackPane1.setStyle("-fx-border-color: #000000;");
    }

    /**
    * Metodo onDragExitedJugador
    * Maneja el evento despues de agregar una imagen de un equipo
    *
    */
    public void onDragExitedEquipo(){
        stackPane2.setStyle("-fx-border-color: #000000;");
    }


    /**
    * Metodo onDragEnteredJugador
    * Maneja el evento para agregar una imagen arrastrada de un equipo
    *
    */
    public void onDragEnteredEquipo(DragEvent e){
        final Dragboard db = e.getDragboard();
        if(db.hasFiles()&&(db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg"))){
            final File file = db.getFiles().get(0);
            try {
                if(!stackPane2.getChildren().isEmpty())
                    stackPane2.getChildren().remove(0);
                String absPath=file.getAbsolutePath();
                Path src=Paths.get(absPath);
                rutaImagenEquipo="dbimages/"+file.getName();
                Path targ=Paths.get("dbimages/"+file.getName());
                Files.copy(src,targ);
                Image img = new Image(new FileInputStream(absPath));
                System.out.println(file.getAbsolutePath());
                ImageView imageView = new ImageView();
                imageView.setFitWidth(200);
                imageView.setFitHeight(200);
                imageView.setImage(img);
                stackPane2.getChildren().add(imageView);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        e.consume();
        stackPane2.setStyle("-fx-border-color: #00FF00;");
    }

    private void getEquipos(){
        try{
        LinkedList<String> rs=OperacionesDB.consultaColumna("select Nombre from Equipo","Nombre");
        for(String s:rs){
            comboEquipoActual.getItems().addAll(s);
            comboAgregarEquipo.getItems().addAll(s);
        }
        }catch(Exception e){System.out.println(e);}
    }

    private void getLigas(){
        try{
        LinkedList<String> rs=OperacionesDB.consultaColumna("select * from Liga","NombreLiga");
        for(String s:rs)
            comboLiga.getItems().addAll(s);
        }catch(Exception e){System.out.println(e);}
    }

    private void getPosiciones(){
        try{
        LinkedList<String> rs=OperacionesDB.consultaColumna("select * from Posicion","NombrePosicion");
        for(String s:rs)
            comboPosicion.getItems().addAll(s);
        }catch(Exception e){System.out.println(e);}
    }

    private void getPaises(){
        try{
        LinkedList<String> rs=OperacionesDB.consultaColumna("select * from Pais","NombrePais");
        for(String s:rs)
            comboPais.getItems().addAll(s);
        }catch(Exception e){System.out.println(e);}
    }

    private void getTrofeos(){
        try{
        LinkedList<String> rs=OperacionesDB.consultaColumna("select * from Trofeo","NombreTrofeo");
        for(String s:rs)
            comboTrofeos.getItems().addAll(s);
        }catch(Exception e){System.out.println(e);}
    }

    private void mensajeErrorEntradaVacia(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Hay algun campo vacio");
        alert.setContentText("Intentaste agregar un equipo con\n una entrada vacia. Prueba de nuevo");
        alert.showAndWait();
    }

    private void mensajeExito(String cadena){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Exito");
        alert.setHeaderText(null);
        alert.setContentText("Se agrego el "+cadena+" de manera exitosa\n");
        alert.showAndWait();
    }

    private void mensajeError(String cadena){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Hubo error");
        alert.setContentText("Hubo un problema agregando el "+cadena);
        alert.showAndWait();
    }

    /**
    * Metodo agregarTrofeos
    * Maneja el evento de agregar un trofeo a la lista de trofeos ganados por un equipo
    *
    */
    public void agregarTrofeos(){
        String s=comboTrofeos.getValue();
        ObservableList<String> names;
        if(s!=null){
            names=FXCollections.observableArrayList(s);
            columnaTrofeos.getItems().addAll(names);
        }
        else
            mensajeErrorEntradaVacia();
        comboTrofeos.setValue(null);
    }

    /**
    * Metodo agregarEquiposALista
    * Maneja el evento de agregar un equipo en el que un jugador ha jugado
    *
    */
    public void agregarEquiposALista(){
        String s=comboAgregarEquipo.getValue();
        ObservableList<String> names;
        if(s!=null){
            names=FXCollections.observableArrayList(s);
            columnaEquipos.getItems().addAll(names);
        }
        else
            mensajeErrorEntradaVacia();
        comboAgregarEquipo.setValue(null);
    }

    /**
    * Metodo agregarJugador
    * Maneja el evento de agregar un jugador a la base de datos
    *
    *@throws error en la conexion de la base de datos
    */
    public void agregarJugador() throws Exception{
         boolean exito=false;
         if(!nombreJugador.getText().trim().equals("")&&datePickerEquipo.getText()!=null
         &&comboPais.getValue()!=null&&comboPosicion.getValue()!=null&&comboEquipoActual.getValue()!=null&&rutaImagenJugador!=null&&!columnaEquipos.getItems().isEmpty()){
            //System.out.println("insert into Equipo(Imagen,Nombre,FechaFundacion,Liga) values("+rutaImagenEquipo+","+nombreEquipo.getText()+","+Integer.parseInt(datePickerEquipo.getText())+","+comboLiga.getValue()+")");
            exito=OperacionesDB.agregaGeneral("insert into Jugador(Imagen,Nombre,FechaNacimiento,Pais,Posicion,EquipoActual) values('"+rutaImagenJugador+"','"+nombreJugador.getText()+"',"+Integer.parseInt(datePickerJugador.getText())+",'"+comboPais.getValue()+"','"+comboPosicion.getValue()+"','"+comboEquipoActual.getValue()+"')");
            for(String s:columnaEquipos.getItems())
                OperacionesDB.agregaGeneral("insert into ha_jugado_en(Jugador,Equipo) values('"+nombreJugador.getText()+"','"+s+"')");
            if(exito){
                Stage stage=(Stage)stackPane1.getScene().getWindow();
                stage.close();
                mensajeExito("jugador");
            }
            else
                mensajeError("jugador");
        }
        else
            mensajeErrorEntradaVacia();
    }

    /**
    * Metodo agregarTrofeos
    * Maneja el evento de agregar un equipos a la base de datos
    *
    @throws error en la conexion con la base de datos
    */
    public void agregarEquipo() throws Exception{
         boolean exito=false;
         if(!nombreEquipo.getText().trim().equals("")&&datePickerEquipo.getText()!=null
         &&comboLiga.getValue()!=null&&rutaImagenEquipo!=null){
            System.out.println("insert into Equipo(Imagen,Nombre,FechaFundacion,Liga) values("+rutaImagenEquipo+","+nombreEquipo.getText()+","+Integer.parseInt(datePickerEquipo.getText())+","+comboLiga.getValue()+")");
            exito=OperacionesDB.agregaGeneral("insert into Equipo(Imagen,Nombre,FechaFundacion,Liga) values('"+rutaImagenEquipo+"','"+nombreEquipo.getText()+"',"+Integer.parseInt(datePickerEquipo.getText())+",'"+comboLiga.getValue()+"')");
            for(String s:columnaTrofeos.getItems())
                OperacionesDB.agregaGeneral("insert into ha_ganado(Equipo,Trofeo) values('"+nombreEquipo.getText()+"','"+s+"')");
            if(exito){
                Stage stage=(Stage)stackPane1.getScene().getWindow();
                stage.close();
                mensajeExito("equipo");
            }
            else
                mensajeError("equipo");
        }
        else
            mensajeErrorEntradaVacia();
    }
}
