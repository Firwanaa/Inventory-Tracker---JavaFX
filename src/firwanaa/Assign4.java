package firwanaa;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * Inventory Program that tests and uses the Inventory class, Display 
 * results and the total cost.
 * @author Alqassam Firwana
 */
public class Assign4 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /**
       * Launch method from Application Class
       */
        Application.launch();
    }
    
    /**
     * Loading FXML File, set Scene to a Stage, and set a Title.
     * @param stage
     * @throws Exception 
     */
    @Override
    public void start(Stage stage) throws Exception {
         Parent root = FXMLLoader.load(getClass().getResource("Assign4FXML.fxml"));
                Scene s= new Scene (root);
                stage.setScene(s);
                stage.setTitle("Inventory Tracker Program");
                stage.show();
    }

}
