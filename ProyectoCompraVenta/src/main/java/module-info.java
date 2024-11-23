module com.example.proyectocompraventa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectocompraventa to javafx.fxml;
    exports com.example.proyectocompraventa;
}