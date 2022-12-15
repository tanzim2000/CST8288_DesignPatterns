package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.ShannonsTheorem;

/**
 *
 * @author Tanzim Ahmed Sagar
 */
public class ShannonPresenter {
	private final ShannonsTheorem model;
	private final ShannonsView view;
        Alert errAlrt = new Alert(AlertType.ERROR);

    public ShannonPresenter(ShannonsTheorem model, ShannonsView view) {
        this.model = model;
        this.view = view;
        view.calculateBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    model.setBandWidth(Double.parseDouble(view.fields[0].getText()));
                } catch (NullPointerException ex) {
                    errAlrt.setHeaderText("Please input a number!");
                    errAlrt.setContentText(" Bandwith can't be 0.0");
                    errAlrt.showAndWait();
                } catch (NumberFormatException ex) {
                    errAlrt.setHeaderText("Please enter a valid bandwidth number!");
                    errAlrt.setContentText(view.fields[0].getText() + " is not legal type");
                    errAlrt.showAndWait();
                }
                try {
                    model.setSignalToNoiseRatio(Double.parseDouble(view.fields[1].getText()));
                } catch (NullPointerException ex) {
                    errAlrt.setHeaderText("Please input a number!");
                    errAlrt.setContentText(" Signal To Noise Ratio can't be 0.0");
                    errAlrt.showAndWait();
                } catch (NumberFormatException ex) {
                    errAlrt.setHeaderText("Please enter a valid Signal To Noise Ratio number!");
                    errAlrt.setContentText(view.fields[1].getText() + " is not legal type");
                    errAlrt.showAndWait();
                }
                String maxDataRate = "" + model.maxDataRate();
                view.fields[2].textProperty().set(maxDataRate);
            }
        });
    }
    
}
