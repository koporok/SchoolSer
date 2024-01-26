package com.example.demo1.window;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AdminTrainer {

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> fioFullname_table;
    @FXML
    private TableColumn<?, ?> number_table;
    @FXML
    private TableColumn<?, ?> login_table;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea Information;

    @FXML
    private Button add_button;

    @FXML
    private Button back_button;

    @FXML
    private Button dell_button;

    @FXML
    private TextField fioFullname_trainer;

    @FXML
    private Button login_button;

    @FXML
    private TextField login_trainer;

    @FXML
    private TextField number_trainer;

    @FXML
    void setBack_button(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert Information != null : "fx:id=\"Information\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert add_button != null : "fx:id=\"add_button\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert back_button != null : "fx:id=\"back_button\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert dell_button != null : "fx:id=\"dell_button\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert fioFullname_table != null : "fx:id=\"fioFullname_table\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert fioFullname_trainer != null : "fx:id=\"fioFullname_trainer\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert login_button != null : "fx:id=\"login_button\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert login_table != null : "fx:id=\"login_table\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert login_trainer != null : "fx:id=\"login_trainer\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert number_table != null : "fx:id=\"number_table\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert number_trainer != null : "fx:id=\"number_trainer\" was not injected: check your FXML file 'AdminTrainer.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'AdminTrainer.fxml'.";

    }



}
