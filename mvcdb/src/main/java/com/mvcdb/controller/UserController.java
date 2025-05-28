package com.mvcdb.controller;

import com.mvcdb.model.User;
import com.mvcdb.model.UserDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private Label statusLabel;

    private UserDAO userDAO = new UserDAO();

    @FXML
    private void handleSave() {
        String name = nameField.getText();
        String email = emailField.getText();

        if (name.isEmpty() || email.isEmpty()) {
            statusLabel.setText("Nama dan Email harus diisi!");
            return;
        }

        User user = new User(0, name, email);
        boolean success = userDAO.insertUser(user);

        if (success) {
            statusLabel.setText("Data berhasil disimpan ke database.");
            nameField.clear();
            emailField.clear();
        } else {
            statusLabel.setText("Gagal menyimpan data.");
        }
    }
}
