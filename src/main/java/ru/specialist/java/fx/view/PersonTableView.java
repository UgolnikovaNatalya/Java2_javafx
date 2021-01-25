package ru.specialist.java.fx.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.specialist.java.fx.App;

import java.sql.*;
import java.util.Properties;

/**
 * nameColumn.setCellFactory(new Properties()) - то откуда будет брать свойства
 */
public class PersonTableView extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Person> people = FXCollections.observableArrayList(
                new Person("Ivan", 25),
                new Person("Masha", 27),
                new Person("Masha", 34),
                new Person("Sergey", 50));
        TableView<Person> tableView = new TableView<>(people);
        tableView.setPrefSize(400, 250);

        /**
         * Привязка колонок к свойствам
         * nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
         * откуда берутся свойства (Берутся из класса Person  свойство name)
         * tableView.getColumns().add(nameColumn); - добавление в сцену
         */
        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().add(nameColumn);

        TableColumn<Person, String> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        tableView.getColumns().add(ageColumn);

        VBox root = new VBox( tableView);
        root.setSpacing(10);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("FXML Hello!");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

