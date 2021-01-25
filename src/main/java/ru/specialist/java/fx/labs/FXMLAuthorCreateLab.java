package ru.specialist.java.fx.labs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Подключение файла helloworld.fxml
 * Parent root = loader.load(); - дает админские права на загрузку файла
 */

public class FXMLAuthorCreateLab extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getResource("labauthors.fxml");
        loader.setLocation(fxmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("FXML Hello!");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch();
    }
}
