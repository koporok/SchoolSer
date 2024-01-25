package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Application {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Group_number;

    @FXML
    private TableColumn<?, ?> Group_number_table;

    @FXML
    private TextField TrainerID;

    @FXML
    private TableColumn<?, ?> TrainerID_table;

    @FXML
    private MenuButton age;

    @FXML
    private TableColumn<?, ?> age_table;

    @FXML
    private Button back_button;

    @FXML
    private DatePicker class_date;

    @FXML
    private TableColumn<?, ?> class_date_table;

    @FXML
    private TextField class_time;

    @FXML
    private TableColumn<?, ?> class_time_table;

    @FXML
    private Button create_button;

    @FXML
    private Button dell_button;

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
