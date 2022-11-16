package nl.tijsbeek.wesupportgoods;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import nl.tijsbeek.wesupportgoods.db.DbHandler;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplicationSupport extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        this.context = new SpringApplicationBuilder()
                .sources(WeSupportGoodsApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));

        DbHandler.enableDatabase(context);
    }


    @Override
    public void start(Stage stage) {
        context.publishEvent(new StageReadyEvent(stage));
    }

    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }
}
