package ru.specialist.java.fx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Класс для работы с helloworld-controller
 * Все теги, что есть там, создаются здесь отдельными классами с такими же именами
 * @FXML - это аннотация, которая показывает к чему привязаться
 * Чтобы данный класс работал (тк он не в основной папке) необходимо
 * прописать в module: и так для каждого класса, который не лежит в папках
 * с открытым доступом
 * opens ru.specialist.java.fx.controller;
 * exports ru.specialist.java.fx.controller to javafx.fxml;
 */

public class ButtonController {
    @FXML
    private Label myLabel;

    @FXML
    public void onButtonClick(){
        myLabel.setText("Changed from Controller");
    }

}
