module com.example.java {
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;

    opens com.example.java to javafx.fxml;
    exports com.example.java;
}