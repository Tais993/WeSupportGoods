package nl.tijsbeek.wesupportgoods.javafx.events;

import javafx.beans.binding.Bindings;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.util.Callback;

import java.util.function.Predicate;

public class ButtonTableCell<S, T> extends TableCell<S, T> {

    private final Button button;

    private final Predicate<S> customUpdatePredicate;
    private final T customUpdateItem;

    @SuppressWarnings({"unused"})
    public ButtonTableCell(final Callback<Integer, Void> pressedCallback) {
        this(pressedCallback, null, any -> false, null);
    }

    @SuppressWarnings({"unused"})
    public ButtonTableCell(final Callback<Integer, Void> pressedCallback, String buttonText) {
        this(pressedCallback, buttonText, any -> false, null);
    }

    public ButtonTableCell(final Callback<Integer, Void> pressedCallback, String buttonText, final Predicate<S> customUpdatePredicate, final T customUpdateItem) {
        this.button = new Button(buttonText);
        this.button.setOnAction(event -> pressedCallback.call(getTableRow().getIndex()));
        this.customUpdatePredicate = customUpdatePredicate;
        this.customUpdateItem = customUpdateItem;
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else if (getTableRow() != null && customUpdatePredicate.test(getTableRow().getItem())) {
            setGraphic((Node) customUpdateItem);
        } else {
            setGraphic(button);
            button.disableProperty().bind(Bindings.not(
                    getTableView().editableProperty().and(
                            getTableColumn().editableProperty()).and(
                            editableProperty())
            ));
        }
    }
}
