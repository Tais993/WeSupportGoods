package nl.tijsbeek.wesupportgoods;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeSupportGoodsApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplicationSupport.class, args);
    }
}
