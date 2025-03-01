package sample;

import javafx.application.Application;  
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 
 * @author LEJEUNE Clement
 *
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fenetreGraphicEditorV2.fxml"));
        primaryStage.setTitle("Graphical editor (LEJEUNE clement)");
        primaryStage.setScene(new Scene(root, 800, 575));
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}