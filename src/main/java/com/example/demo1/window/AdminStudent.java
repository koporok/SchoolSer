package com.example.demo1.window;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo1.enity.Student;
import com.example.demo1.server.ServerConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class AdminStudent {

    @FXML
    private TableView<Student> table;
    @FXML
    private TableColumn<Student,String> fullName_table;
    @FXML
    private TableColumn<Student, String> phone_number_table;
    @FXML
    private TableColumn<Student, Date> data_table;
    @FXML
    private TableColumn<Student, String> login_table1;
    @FXML
    private TableColumn<Student, String> number_group_table;
    @FXML
    private TableColumn<Student, String> type_sport;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Sport;

    @FXML
    private Button applications;

    @FXML
    private Button back_button;

    @FXML
    private TextField data;

    @FXML
    private Button dell_button;

    @FXML
    private Button edit_button;

    @FXML
    private TextField fullName_students;

    @FXML
    private TextField number_group;

    @FXML
    private TextField phone_number;

    @FXML
    void setBack_button(MouseEvent event) {

    }

    @FXML
    void initialize() {

        displayingDataInATable();
    }


    public void displayingDataInATable(){

        List<Student> students = ServerConnection.getStudentsData();


        fullName_table.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phone_number_table.setCellValueFactory(new PropertyValueFactory<>("contactInformation"));
        data_table.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        login_table1.setCellValueFactory(new PropertyValueFactory<>("login"));
        number_group_table.setCellValueFactory(new PropertyValueFactory<>("groupId"));
        type_sport.setCellValueFactory(new PropertyValueFactory<>("sportType"));

        // Создание ObservableList из списка студентов
        ObservableList<Student> data = FXCollections.observableArrayList(students);

        // Установка данных в TableView
        table.setItems(data);
    }
}
