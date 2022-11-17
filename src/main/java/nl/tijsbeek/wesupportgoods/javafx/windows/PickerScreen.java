package nl.tijsbeek.wesupportgoods.javafx.windows;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import nl.tijsbeek.wesupportgoods.javafx.events.ButtonTableCell;
import org.jooq.DSLContext;
import org.jooq.Record4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static nl.tijsbeek.wesupportgoods.db.generated.tables.Customer.CUSTOMER;
import static nl.tijsbeek.wesupportgoods.db.generated.tables.Order.ORDER;

@Component
@FxmlView
public class PickerScreen {

    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private final FxWeaver fxWeaver;
    private final DSLContext context;

    private final ObservableList<OrderPickItem> observableItems = FXCollections.observableArrayList();

    @FXML
    public GridPane ordersPane;

    @FXML
    public TableView<OrderPickItem> orderTable;

    @FXML
    public TextField search;
    // TODO add search logic

    @Autowired
    public PickerScreen(FxWeaver fxWeaver, DSLContext context) {
        this.fxWeaver = fxWeaver;
        this.context = context;
    }

    @FXML
    public void initialize() {
        BorderStroke borderStroke = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1));
        Border border = new Border(borderStroke);

        ordersPane.setBorder(border);

        orderTable.getColumns().get(3).setCellFactory(orderPickButtonCreator());

        orderTable.setItems(observableItems);


        Record4<Integer, String, String, Boolean>[] array = context.select(ORDER.ID, CUSTOMER.COMPANY_NAME, CUSTOMER.CONTACT_PERSON, ORDER.FINISHED)
                .from(ORDER)
                .join(CUSTOMER)
                .on(ORDER.CUSTOMER_ID.eq(CUSTOMER.ID))
                .fetchArray();

        observableItems.addAll(Arrays.stream(array)
                .map(dbRecord -> new OrderPickItem(dbRecord.value1(), dbRecord.value2(), dbRecord.value3(), dbRecord.value4()))
                .toList()
        );
    }

    private <T> Callback<TableColumn<OrderPickItem, T>, TableCell<OrderPickItem, T>> orderPickButtonCreator() {
        return param -> {
            Callback<Integer, Void> pressedCallback = index -> {
                OrderPickItem orderItem = orderTable.getItems().get(index);
                createAlert(orderItem.idProperty + "'s button was pressed!")
                        .show();
                // TODO add actual logic which opens the screen
                return null;
            };

            return new ButtonTableCell<>(pressedCallback, "Order picken", OrderPickItem::isFinishedProperty, (T) new Text("✔"));
        };
    }

    private Alert createAlert(String text) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(text);
        return alert;
    }


    public record OrderPickItem(
            IntegerProperty idProperty,
            StringProperty companyNameProperty,
            StringProperty contactPersonProperty,
            BooleanProperty finishedProperty
    ) {

        public OrderPickItem(int id, String companyName, String contactPerson, boolean finished) {
            this(new SimpleIntegerProperty(id), new SimpleStringProperty(companyName),
                    new SimpleStringProperty(contactPerson), new SimpleBooleanProperty(finished));
        }

        public boolean isFinishedProperty() {
            return finishedProperty.get();
        }
    }
}
