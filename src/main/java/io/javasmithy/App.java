package io.javasmithy;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.Parent;

public class App extends Application {

    private static Scene scene;

    public void start(Stage stage) throws IOException {
        scene = new Scene( loadFXML("app") );

        stage.setScene(scene);
        stage.setTitle("Weather-App-v1.0.1");
        stage.show();
    }

    public Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader( App.class.getResource("fxml/"+ fxml + ".fxml") );
        return loader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
