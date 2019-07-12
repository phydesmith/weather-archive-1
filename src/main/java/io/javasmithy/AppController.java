package io.javasmithy;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class AppController {

    @FXML
    private TextField zipTxtField;

    @FXML
    public void sendZipCode(ActionEvent event) throws IOException {
        String zipCode = zipTxtField.getText();
        System.out.println("ZIP Code: " + zipCode);
    }

}