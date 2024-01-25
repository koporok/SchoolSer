package com.example.demo1.window;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.example.demo1.enity.Student;
import com.example.demo1.server.ServerConnectionStudent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
    private TextField fullName_students;
    @FXML
    private TextField number_group;
    @FXML
    private TextField phone_number;

    @FXML
    void initialize() {
        displayingDataInATable();
        dell_button.setOnAction(event -> {
            Student selectedStudent = table.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                int studentId = selectedStudent.getId(); // Получение ID выбранного студента
                deleteStudentFromServer(studentId); // Вызов метода для удаления студента с выбранным ID
            }
            displayingDataInATable();
            clearTextField();
        });
        // Установка слушателя событий для выбора строки в таблице
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Получение данных из ново выбранной строки
                String fullName = newSelection.getFullName();
                String phoneNumber = newSelection.getContactInformation();
                String date = newSelection.getDateOfBirth();
                int numberGroup = newSelection.getGroupId();
                String sportType = newSelection.getSportType();

                // Отображение данных в соответствующих текстовых полях или других элементах интерфейса
                fullName_students.setText(fullName);
                phone_number.setText(phoneNumber);
                data.setText(date);
                number_group.setText(String.valueOf(numberGroup));
                Sport.setText(sportType);

            }
        });
        applications.setOnAction(event -> {});
    }


    public void displayingDataInATable() {
        List<Student> students = ServerConnectionStudent.getStudentsData();

        // Создание ObservableList из студентов
        ObservableList<Student> data = FXCollections.observableArrayList(students);

        // Привязка полей TableView к свойствам объекта Student
        fullName_table.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        phone_number_table.setCellValueFactory(new PropertyValueFactory<>("contactInformation"));
        data_table.setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        login_table1.setCellValueFactory(new PropertyValueFactory<>("login"));
        number_group_table.setCellValueFactory(new PropertyValueFactory<>("groupId"));
        type_sport.setCellValueFactory(new PropertyValueFactory<>("sportType"));

        // Фильтрация данных для отображения только записей, где login не равен null
        FilteredList<Student> filteredData = new FilteredList<>(data, student -> student.getLogin() != "null");

        // Применение фильтра к TableView
        table.setItems(filteredData);
    }

    private void deleteStudentFromServer(int studentId) {
        try {
            String urlString = "http://localhost:8081/martial-arts-school/students/" + studentId;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Успешно удалено");
            } else {
                // Обработка ошибки
            }

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void clearTextField() {
        fullName_students.clear();
        phone_number.clear();
        data.clear();
        number_group.clear();
        Sport.clear();

    }
}
