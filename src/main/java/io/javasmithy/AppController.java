package io.javasmithy;

import io.javasmithy.data.StationLocator;
import io.javasmithy.data.WeatherService;
import io.javasmithy.data.ConditionsExtractor;

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
        weatherOutput.setText(
            ConditionsExtractor.getWeatherConditions(
                new WeatherService(
                    StationLocator.findStation(zipTxtField.getText())
                ).getCurrentObservation()
            )
        );
    }
}