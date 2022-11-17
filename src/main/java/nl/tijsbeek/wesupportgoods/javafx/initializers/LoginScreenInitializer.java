package nl.tijsbeek.wesupportgoods.javafx.initializers;

import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import nl.tijsbeek.wesupportgoods.javafx.unspecified.StageReadyEvent;
import nl.tijsbeek.wesupportgoods.javafx.windows.LoginScreen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoginScreenInitializer implements ApplicationListener<StageReadyEvent> {

    private final FxWeaver fxWeaver;

    @Autowired
    public LoginScreenInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.stage;

        Scene scene = new Scene(fxWeaver.loadView(LoginScreen.class));
        stage.setResizable(true);
        stage.setMinHeight(260);
        stage.setMinWidth(200);
        stage.setScene(scene);
        stage.show();
    }
}
