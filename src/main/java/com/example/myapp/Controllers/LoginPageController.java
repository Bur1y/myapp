package com.example.myapp.Controllers;

import com.example.myapp.App.Alerts;
import com.example.myapp.Base.CRUD;
import com.example.myapp.JavaFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class LoginPageController {

    public ImageView logoImage;
    public TextField loginLable;
    public PasswordField passwordLable;
    public Tooltip toolTip;
    public CheckBox checkBox;


    // Инициализация
    @FXML
    public void initialize() {
        logoImage.setImage(new Image(JavaFX.class.getResourceAsStream("images/logo.png")));

    }

    // Метод кнопки входа
    public void enter(ActionEvent actionEvent) throws IOException {

        if (!loginLable.getText().isBlank() || !passwordLable.getText().isBlank()) {

            switch (CRUD.getUser(loginLable.getText(), passwordLable.getText()).getRole()) {
                case 1: {
                    JavaFX.setRoot("firstPage");
                    break;
                }

                case 2: {
                    JavaFX.setRoot("secondPage");
                    break;
                }

                default: {
                    Alerts.errorAlert("Неизвестная зарегистрированная учётная запись", "Ошибка входа", "Обратитесь к администратору");
                    break;
                }

            }
        } else {
            Alerts.errorAlert("Проверьте введённые данные", "Ошибка входа", "Неверный логин или пароль");
        }

    }

    // Метод проверки паролей
    public void viewPass(ActionEvent actionEvent) {
        if (checkBox.isSelected()) {
            showPassword();
        } else {
            hidePassword();
        }
    }

    // Метод для появления окна с паролем
    private void showPassword() {
        Point2D p = passwordLable.localToScene(passwordLable.getBoundsInLocal().getMaxX(), passwordLable.getBoundsInLocal().getMaxY());
        toolTip.setText(passwordLable.getText());
        toolTip.show(passwordLable,
                p.getX() * 1.5,
                p.getY() * 1.5);
    }

    // Метод для сокрытия окна с паролем
    private void hidePassword() {
        toolTip.setText("");
        toolTip.hide();
    }
}