package nl.tijsbeek.wesupportgoods.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class LoginScreen {

    @SuppressWarnings("unused")
    private final FxWeaver fxWeaver;

    @FXML
    private Pane loginPane;


    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    public LoginScreen( FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    public void initialize() {
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(2));
        Border border = new Border(borderStroke);

        loginPane.setBorder(border);
    }

    public void onButtonClick(ActionEvent event) {
        event.getEventType();
    }
}
