package ru.specialist.java.fx.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;

/**
 *  ObservableList <String> - как и ArrayList
 *  langs.addListener(); - то что будет реагировать на события
 *  ListView <String> - для отображения на сцене в виде списка
 *  listView.getSelectionModel().selectedItemProperty().addListener(
 *  (o, s, t1) -> label.setText(t1)); - обрабатывает запрос
 */
public class BooksListViewExample extends Application {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "UgolnikoVa77792";


    @Override
    public void start(Stage stage) throws Exception {
        ObservableList <String> books = getBooksList();
        

        ListView <String> listView = new ListView<>(books);
        listView.setPrefSize(400,250);
        Label label = new Label();

        VBox root = new VBox( listView, label);
        root.setSpacing(10);
        root.setAlignment(Pos.TOP_CENTER);


        listView.getSelectionModel().selectedItemProperty().addListener(
                (o, s, t1) -> label.setText(t1));

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("List View app");
        stage.show();
    }

    private ObservableList<String> getBooksList() {
        ObservableList <String> books = FXCollections.observableArrayList();

        try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery("select title from books");

            while (set.next()) {
                books.add(set.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return books;
    }

    public static void main(String[] args) {

        launch();
    }
}
