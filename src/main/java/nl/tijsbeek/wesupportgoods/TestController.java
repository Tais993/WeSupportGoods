package nl.tijsbeek.wesupportgoods;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class TestController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label test;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        test.setText("uwu");
        test.setFont(Font.font(30));
    }
}
