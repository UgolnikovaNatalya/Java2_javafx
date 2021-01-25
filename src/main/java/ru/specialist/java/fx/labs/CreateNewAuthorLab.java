package ru.specialist.java.fx.labs;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.*;



public class CreateNewAuthorLab extends Application {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "UgolnikoVa77792";

    @Override
    public void start(Stage stage) throws IOException {

        Label label = new Label("Create new author.");
        Label label_author = new Label();
        Label label_book = new Label();


        TextField fn = new TextField();
        fn.setPromptText("First name");
        TextField sn = new TextField();
        sn.setPromptText("Second name");
        TextField title = new TextField();
        title.setPromptText("Title");

        Button create = new Button("Create author");
        create.setOnMouseClicked(m ->
                {
                    try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {

                        c.setAutoCommit(false);

                        int authorId = 0;
                        int bookId = 0;

                        try {
                            PreparedStatement statement = c.prepareStatement("insert into authors\n" +
                                    "(author_name, last_name)\n" +
                                    "values (?, ?)", Statement.RETURN_GENERATED_KEYS);

                            statement.setString(1, fn.getText());
                            statement.setString(2, sn.getText());

                            statement.executeUpdate();
                            ResultSet set = statement.getGeneratedKeys();

                            while (set.next()) {
                                authorId = set.getInt(1);
                                label_author.setText("Generated author_id: " + authorId);
                            }

                            statement = c.prepareStatement("insert into books (title,author_id)\n" +
                                    "values (?, ?)", Statement.RETURN_GENERATED_KEYS);
                            statement.setString(1, title.getText());
                            statement.setInt(2, authorId);

                            statement.executeUpdate();

                            set = statement.getGeneratedKeys();
                            while (set.next()) {
                                bookId = set.getInt(1);
                                label_book.setText("Generated book_id: " + bookId);
                            }

                            c.commit();
                        } catch (SQLException throwable) {
                            throwable.printStackTrace();
                        }


                    } catch (SQLException throwable) {
                        throwable.printStackTrace();
                    }
                }

        );



        VBox root = new VBox(label, label_author,label_book, fn, sn, title, create);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(50, 50, 50, 50));

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My javaFX lab");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
//4.10

