package io.javasmithy;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class AppController {

    @FXML
    private TextField zipTxtField;

    @FXML
    public String getZipcode(ActionEvent event) throws IOException {
        return zipTxtField.getText();
    }


}