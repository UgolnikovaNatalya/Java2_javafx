package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 * TilePane - выравнивание объектов по вертикали и горизонтали
 * {{setMinWidth(100);}} - создаем класс (переписываем) для объекта,
 * чтобы не плодить большое количество объектов
 * setMinWidth(100) - задаем размер кнопки
 */
public class TilePaneExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane root = new TilePane();
//        root.setOrientation(Orientation.VERTICAL);

                root.getChildren().addAll(
                new Button("1"){{setMinWidth(100);}},
                new Button("2"){{setMinWidth(10);}},
                new Button("3"){{setMinWidth(5);}},
                new Button("4"){{setMinWidth(10);}},
                new Button("5"){{setMinWidth(30);}},
                new Button("6"){{setMinWidth(50);}},
                new Button("7"){{setMinWidth(100);}},
                new Button("8"){{setMinWidth(50);}},
                new Button("9") {{setMinWidth(100);}}
                );

        root.setVgap(20);
        root.setHgap(50);
        root.setAlignment(Pos.CENTER);

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
//2.09