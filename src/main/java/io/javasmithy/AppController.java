package io.javasmithy;

import io.javasmithy.data.*;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class AppController {

    @FXML
    private TextField zipTxtField;

    @FXML
    public String getZipcode(ActionEvent event) throws IOException {
        Geodata.testDerby();
        return zipTxtField.getText();
    }


}