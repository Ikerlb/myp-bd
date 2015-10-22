package mx.unam.ciencias.myp;

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

public class ControladorAgrega{

    @FXML private StackPane stackPane1;
    @FXML private StackPane stackPane2;


    public void onDragEnteredJugador(DragEvent e){
        final Dragboard db = e.getDragboard();
        if(db.hasFiles()&&(db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg"))){
            final File file = db.getFiles().get(0);
            try {
                if(!stackPane1.getChildren().isEmpty())
                    stackPane1.getChildren().remove(0);
                Image img = new Image(new FileInputStream(file.getAbsolutePath()));
                System.out.println(file.getAbsolutePath());
                ImageView imageView = new ImageView();
                imageView.setImage(img);
                stackPane1.getChildren().add(imageView);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        e.consume();
        stackPane1.setStyle("-fx-border-color: #00FF00;");
    }

    public void onDragExitedJugador(){
        stackPane1.setStyle("-fx-border-color: #000000;");
    }

    public void onDragExitedEquipo(){
        stackPane2.setStyle("-fx-border-color: #000000;");
    }

    public void onDragEnteredEquipo(DragEvent e){
        final Dragboard db = e.getDragboard();
        if(db.hasFiles()&&(db.getFiles().get(0).getName().toLowerCase().endsWith(".png")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpeg")
                        ||db.getFiles().get(0).getName().toLowerCase().endsWith(".jpg"))){
            final File file = db.getFiles().get(0);
            try {
                if(!stackPane2.getChildren().isEmpty())
                    stackPane2.getChildren().remove(0);
                Image img = new Image(new FileInputStream(file.getAbsolutePath()));
                System.out.println(file.getAbsolutePath());
                ImageView imageView = new ImageView();
                imageView.setImage(img);
                stackPane2.getChildren().add(imageView);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        e.consume();
        stackPane2.setStyle("-fx-border-color: #00FF00;");
    }
}
