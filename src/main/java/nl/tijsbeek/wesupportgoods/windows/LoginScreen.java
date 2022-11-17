package nl.tijsbeek.wesupportgoods.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import net.synedra.validatorfx.Check;
import net.synedra.validatorfx.Validator;
import nl.tijsbeek.wesupportgoods.db.generated.tables.records.UserRecord;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static nl.tijsbeek.wesupportgoods.db.generated.tables.User.USER;

@Component
@FxmlView
public class LoginScreen {
    private static final Logger logger = LoggerFactory.getLogger(LoginScreen.class);

    private final Validator validator = new Validator();

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final FxWeaver fxWeaver;
    private final DSLContext context;

    @FXML
    private Pane loginPane;


    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;


    private Check loginCheck;

    @Autowired
    public LoginScreen(FxWeaver fxWeaver, DSLContext context) {
        this.fxWeaver = fxWeaver;
        this.context = context;
    }

    @FXML
    public void initialize() {
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1));
        Border border = new Border(borderStroke);

        loginPane.setBorder(border);

        loginCheck = validator.createCheck()
                .withMethod(c -> {
                    String checkUsername = usernameTextField.getText();
                    String checkPassword = passwordTextField.getText();

                    UserRecord checkRecord = context.selectFrom(USER)
                            .where(USER.USERNAME.eq(checkUsername), USER.PASSWORD.eq(checkPassword))
                            .fetchOne();

                    if (checkRecord == null) {
                        c.error("Username or password invalid!.");
                        logger.warn("incorrect info: '{}' & '{}'", checkUsername, checkPassword);
                    }
                })
                .decorates(usernameTextField)
                .decorates(passwordTextField);
    }

    public void onButtonClick(ActionEvent event) {
        event.getEventType();

        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        UserRecord userRecord = context.selectFrom(USER)
                .where(USER.USERNAME.eq(username), USER.PASSWORD.eq(password))
                .fetchOne();

        loginCheck.recheck();

        if (userRecord != null) {
            logger.info("Email: '{}'", userRecord.getEmail());

            switch (userRecord.getRole()) {
                case "Picker", "Voorraadmanager", "Verkoper" -> {
                    // TODO
                }
                default -> throw new IllegalStateException("Unexpected value: " + userRecord.getRole());
            }
        }
    }
}
