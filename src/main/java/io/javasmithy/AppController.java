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
    public void getZipcode(ActionEvent event) throws IOException {
        System.out.println(zipTxtField.getText());
        Geodata.findStation(zipTxtField.getText());
    }


}