
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class GameOver {
    private Stage stage;
    private static GameOver instance;
    private Scene scene;
    private GameOver(Stage stage){this.stage=stage;}
    
    public static GameOver getInstance(Stage stage){
        if(instance==null)
            instance = new GameOver(stage);
        return instance;
    }
       public void prepareScene(){
           Label label = new Label("GAME OVER");
           label.setAlignment(Pos.CENTER);
           label.setScaleX(9); 
           label.setScaleY(9);
           VBox box = new VBox();
           box.getChildren().add(label);
           box.setAlignment(Pos.CENTER);
            scene = new Scene(box,640,360);
           
       }
       public Scene getScene(){return scene;}
}
