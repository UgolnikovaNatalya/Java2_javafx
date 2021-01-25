package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class StackPaneExample extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("stonehenge.jpg"));
        Image image1 = new Image(getClass().getResourceAsStream("grand_canyon.jpg"));
        ImageView imageView = new ImageView(image);

        Button button = new Button("Change picture");
        button.setOnMouseClicked(mouseEvent -> imageView.setImage(
                imageView.getImage() == image ? image1 : image));


        /**
         * Stack - наслаивание одного на другое. (хорошо подходит для картинок)
         */
        StackPane root = new StackPane(imageView, button);

        /**
         * Настройка окна
         * stage.setScene(scene) - вывод сцены в окне
         * stage.setResizable(false) - изменение размера окна (можно/нельзя)
         * stage.setTitle("My first fx") - название окна
         * stage.show() - вывод окна
         */
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My JavaFX app");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
