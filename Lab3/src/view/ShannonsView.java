package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * View for the main window
 * @author Tanzim Ahmed Sagar
 */
public class ShannonsView extends GridPane{
    //Labels
    /** Array of labels */
    Label[] labels = {
        new Label("Bandwidth: "),
        new Label("Signal to Noise Ratio: "),
        new Label("Max Data Rate: ")
    };
    //TextFields
    /** Array of TextFields (Automatically generated based of labels)*/
    TextField[] fields = new TextField[this.labels.length];
    //Buttons
    /** Calculate Button */
    Button calculateBtn = new Button("Calculate");
    /**
     * default constructor
     */
    public ShannonsView() {
        this.setHgap(5);
        this.setVgap(5);
        for (int index = 0; index < this.fields.length; index++) {
            fields[index] = new TextField();
        }
        fields[fields.length-1].setDisable(true);
        for (int index = 0; index < this.labels.length; index++) {
            this.add(this.labels[index], 1, index+1);
            }
        for (int index = 0; index < this.fields.length; index++) {
            this.add(this.fields[index], 2, index+1);
            }
        this.add(this.calculateBtn, this.labels.length, this.labels.length+1);
    }
}
