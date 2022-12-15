package launch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ShannonsTheorem;
import view.*;

/**
 *
 * @author Tanzim Ahmed Sagar
 */
public class ShannonLaunch extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        ShannonsTheorem model = new ShannonsTheorem();  //instantiating a model
        ShannonsView view = new ShannonsView();         //instantiating a view
        Scene scene = new Scene(view);            //creating a scene passing the view
        ShannonPresenter presenter = new ShannonPresenter(model, view); //Instantiating the presenter for the model and view
        //Configuring the stage
        primaryStage.setTitle("Shannons Theorem");
        primaryStage.setScene(scene);   //commanding the stage to load the scene
        primaryStage.show();                 //Deploying the stage
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
