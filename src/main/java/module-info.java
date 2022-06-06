module com.example.myapp {

    requires javafx.controls;
    requires javafx.fxml;

    requires java.persistence;
    requires java.naming;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens com.example.myapp to javafx.fxml;
    opens com.example.myapp.Controllers to javafx.fxml;
    opens com.example.myapp.App to javafx.fxml;

    opens com.example.myapp.Base;

    exports com.example.myapp.Controllers;
    exports com.example.myapp.Base.Tables;
    exports com.example.myapp;
    exports com.example.myapp.Base;
    exports com.example.myapp.App;
    opens com.example.myapp.Base.Tables;
}