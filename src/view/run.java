
package view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class run extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/caculator.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
        
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
//x^3*log(20-x^2)(x+1/x)+tan(x*2)
// sin(x+10)-(log(x+1/x)(100-x^x))/sqrt(1-tan(x*3)) 2