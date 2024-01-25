module com.example.demo1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.json;


    opens com.example.demo1 to javafx.fxml;
    exports com.example.demo1;
    exports com.example.demo1.window;
    opens com.example.demo1.window to javafx.fxml;
    exports com.example.demo1.server;
    opens com.example.demo1.server to javafx.fxml;
    opens com.example.demo1.enity to javafx.base;
}