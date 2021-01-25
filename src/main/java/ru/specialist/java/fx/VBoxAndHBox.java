package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VBoxAndHBox extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBox1 = new HBox(new Button("1"),new Button("2"));
        hBox1.setAlignment(Pos.BOTTOM_LEFT);
        hBox1.setSpacing(10);

        HBox hBox2 = new HBox(new Label("3"));
        hBox2.setAlignment(Pos.CENTER);
        hBox2.setSpacing(10);

        HBox hBox3 = new HBox(new Label("4"), new Button("5"),
                new Text("6"));
        hBox3.setAlignment(Pos.CENTER_RIGHT);
        hBox3.setSpacing(10);


        VBox root = new VBox(hBox1,hBox2,hBox3);
        root.setSpacing(10);
        root.setAlignment(Pos.BASELINE_RIGHT);


        Scene scene = new Scene(root, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("HBox and VBox");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
