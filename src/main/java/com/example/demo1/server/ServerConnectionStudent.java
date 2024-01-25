package com.example.demo1.server;

import com.example.demo1.enity.Student;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class ServerConnectionStudent {

    public static List<Student> getStudentsData() {
        List<Student> students = new ArrayList<>();

        try {
            String urlString = "http://localhost:8081/martial-arts-school/students";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseData = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    responseData.append(line);
                }

                JSONArray jsonArray = new JSONArray(responseData.toString());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonStudent = jsonArray.getJSONObject(i);
                    int id = jsonStudent.getInt("id");
                    String name = jsonStudent.getString("fullName");
                    String dateOfBirth;
                    if (jsonStudent.get("dateOfBirth") instanceof String) {
                        dateOfBirth = jsonStudent.getString("dateOfBirth");
                    } else {
                        // Обработка другого типа данных для "dateOfBirth", например:
                        dateOfBirth = String.valueOf(jsonStudent.get("dateOfBirth"));
                    }
                    String contactInformation;
                    if (jsonStudent.get("contactInformation") instanceof String) {
                        contactInformation = jsonStudent.getString("contactInformation");
                    } else {
                        contactInformation = String.valueOf(jsonStudent.get("contactInformation"));
                    }
                    int groupId;
                    if (jsonStudent.get("groupId") instanceof String) {
                        groupId = jsonStudent.getInt("groupId");
                    } else {
                        groupId = 0;
                    }
                    String sportType;
                    if (jsonStudent.get("sportType") instanceof String) {
                        sportType = jsonStudent.getString("sportType");
                    } else {
                        sportType = String.valueOf(jsonStudent.get("sportType"));
                    }
                    String login;
                    if (jsonStudent.get("login") instanceof String) {
                        login = jsonStudent.getString("login");
                    } else {
                        login = String.valueOf(jsonStudent.get("login"));
                    }
                    // Создание объекта Student и добавление его в список
                    Student student = new Student(id, name, dateOfBirth, contactInformation, groupId, sportType, login);
                    students.add(student);
                }


                reader.close();
            } else {
                System.out.println("GET Request - Response Code: " + responseCode);
            }

            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void deleteStudentFromServer(int studentId) {
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
}
