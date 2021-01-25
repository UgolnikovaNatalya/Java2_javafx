module ru.specialist.java.fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ru.specialist.java.fx to javafx.fxml;
    opens ru.specialist.java.fx.controller;
    opens ru.specialist.java.fx.labs;
    opens ru.specialist.java.fx.view;
    opens ru.specialist.java.fx.view.hw;

    exports ru.specialist.java.fx;
    exports ru.specialist.java.fx.labs;
    exports ru.specialist.java.fx.controller;
    exports ru.specialist.java.fx.view;
    exports ru.specialist.java.fx.view.hw;
}