package io.javasmithy;

import io.javasmithy.weather.StationLocator;
import io.javasmithy.weather.RemoteServiceAccessor;
import io.javasmithy.weather.DataParser;

import io.javasmithy.weather.CurrentObservation;

import java.io.IOException;
import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

import javafx.event.ActionEvent;

public class AppController {

    @FXML
    private TextField zipTxtField;

    @FXML
    private TextArea weatherOutput;

    @FXML
    public void getZipcode(ActionEvent event) throws IOException {
        System.out.println(zipTxtField.getText());

        weatherOutput.setText( new CurrentObservation(zipTxtField.getText()).toString() );

        /*
        weatherOutput.setText(
            new DataParser(
                new RemoteServiceAccessor(
                    StationLocator.findStation(zipTxtField.getText())
                ).getCurrentObservation()
            ).concatTextData()
        );
        */
    }
}