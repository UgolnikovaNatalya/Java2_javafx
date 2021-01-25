package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 * stage.show*() - запуск окна
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        /**
         * То, что выведется в окне (сцена)
         * label.setFont(new Font("Sitka Heading Bold Italic", 20)) - размен и стиль текста
         * label.setAlignment(Pos.CENTER) - выравнивание
         * Font.getFontNames() - узнать какие есть тексты
         * root.setSpacing(20) - расстояние между элементами
         */
        Label label = new Label("Hello JavaFX");
        label.setFont(new Font("Sitka Heading Bold Italic", 25));

        /**
         * Создание кнопки
         * button.setOnAction() - передача действия кнопке
         * button.setOnMouseClicked() - действие при нажиме мышкой
         */
        Button button = new Button("Change Label name");
        button.setOnMouseClicked(mouseEvent -> label.setText("Button clicked!"));

        Button button1 = new Button("Pressed Button");
        button1.setOnMousePressed(mouseEvent -> label.setText("Button pressed!"));

        Button button2 = new Button("My event");
        button2.setOnMouseClicked(new MyEventHandler(label));

        VBox root = new VBox(label, button, button1, button2);
//        root.getChildren().addAll(label, button); //То же самое что и сверху
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

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
        stage.setTitle("My first fx");
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}