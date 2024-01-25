package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Trainer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add_button;

    @FXML
    private Button back_button;

    @FXML
    private Button dell_button;

    @FXML
    private TableColumn<?, ?> fioFullname_table;

    @FXML
    private TextField fioFullname_trainer;

    @FXML
    private Button login_button;

    @FXML
    private TableColumn<?, ?> login_table;

    @FXML
    private TextField login_trainer;

    @FXML
    private TableColumn<?, ?> number_table;

    @FXML
    private TextField number_trainer;

    @FXML
    void initialize() {
    }
    @FXML
    void setBack_button(){
        back_button.getScene().getWindow().hide();
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource("choice.fxml"));
    try {
        loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Parent root = loader.getRoot();
    Stage stage = new Stage();
    stage.setScene(new Scene(root));
    stage.show();
}
}
