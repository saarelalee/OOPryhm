module com.example.graafiline {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.graafiline to javafx.fxml;
    exports com.example.graafiline;
}