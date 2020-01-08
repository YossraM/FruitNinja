/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ELMASREYA
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HintAlert {
    
    public static void display(String Text){
        Stage window = new Stage();
       Label lbl = new Label();
       lbl.setText(Text);
       Button button = new Button("OK");
      VBox box = new VBox();
      box.getChildren().addAll(lbl,button);
      box.setAlignment(Pos.CENTER);
       Scene s; s = new Scene(box,200,200);
       button.setOnAction((ActionEvent e)->{
           window.close();
           
       });
       window.setScene(s);
      window.show(); 
    }
         public static void saveScore(String filename, int score){
          try { 
  
            try ( 
                    BufferedWriter out = new BufferedWriter( new FileWriter(filename))) {
             out.write(Integer.toString(score));
            out.write(" ");
             out.newLine();
                out.close();
            } 
        } 
        catch (IOException e) { 
            System.out.println("exception occured" + e); 
        } 
    }
      
}
