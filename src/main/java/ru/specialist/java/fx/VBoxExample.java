package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * stage.show*() - запуск окна
 */
public class VBoxExample extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(
                new Button("1"),
                new Button("2"),
                new Button("3"),
                new Button("4"),
                new Button("5")
        );

        root.setAlignment(Pos.CENTER);
        root.setSpacing(15);
        root.setPadding(new Insets(50,10,100,200));

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My first fx");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}
//Last lecture 1.41