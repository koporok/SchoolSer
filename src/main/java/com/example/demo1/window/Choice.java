package com.example.demo1.window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.demo1.additionalMethods.SceneLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Choice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button groups_button;

    @FXML
    private Button students_button;

    @FXML
    private Button trainer_button;

    @FXML
    void initialize() {
        students_button.setOnAction(event -> {

        });
    }

}
