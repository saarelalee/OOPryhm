module com.oop2.memoriinjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.oop2.memoriinjavafx to javafx.fxml;
    exports com.oop2.memoriinjavafx;
}