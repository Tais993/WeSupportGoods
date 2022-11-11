package nl.tijsbeek.wesupportgoods;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.ClassicConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class JavaFxApplicationSupport extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        this.context = new SpringApplicationBuilder()
                .sources(WeSupportGoodsApplication.class)
                .run(getParameters().getRaw().toArray(new String[0]));

        migrateFlyway();
    }

    private void migrateFlyway() {
        ConfigurableEnvironment environment = context.getEnvironment();

        ClassicConfiguration conf = new ClassicConfiguration();
        String flywayUrl = environment.getProperty("spring.flyway.url");
        String flywayUser = environment.getProperty("spring.flyway.user");
        String flywayPassword = environment.getProperty("spring.flyway.password");

        conf.setDataSource(flywayUrl, flywayUser, flywayPassword);

        Flyway flyway = new Flyway(conf);
        flyway.migrate();
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
