package ru.specialist.java.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

/**
 * Класс определяющий действие кнопки create
 * из лабораторной работы labauthors
 */
public class LabAuthorButton {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "UgolnikoVa77792";


    @FXML
    private Label bookId;
    @FXML
    private Label authorId;
    @FXML
    private TextField label_fn;
    @FXML
    private TextField label_sn;
    @FXML
    private TextField label_title;


    @FXML
    public void onButtonClick() throws SQLException{

            try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD))
            {
                int authorGen =0;
                int bookGen = 0;

                    PreparedStatement statement = c.prepareStatement("insert into authors\n"
                            + "(author_name, last_name)\n"
                            + "values (?, ?)", Statement.RETURN_GENERATED_KEYS);
                    String name = label_fn.getText();
                    String lastName = label_sn.getText();

                    if (name.isEmpty() || lastName.isEmpty())
                    {
                        throw new IllegalArgumentException("Wrong data");
                    }
                    statement.setString(1, name);
                    statement.setString(2, lastName);
                    statement.executeUpdate();

                    ResultSet set = statement.getGeneratedKeys();
                    while (set.next())
                    {
                        authorGen = set.getInt(1);
                        authorId.setText("" + authorGen + "");

                    }

                    statement = c.prepareStatement("insert into books"
                                    + "(title, author_id)\n"
                                    + "values (?, ?)",
                            Statement.RETURN_GENERATED_KEYS);
                    String titles = label_title.getText();
                    statement.setString(1,titles);
                    statement.setInt(2, authorGen);
                    statement.executeUpdate();

                    set = statement.getGeneratedKeys();
                    while (set.next())
                    {
                        bookGen = set.getInt(1);
                        bookId.setText("" + bookGen + "");
                    }

                }

                catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
    }
}
