
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author ELMASREYA
 */
public class Ninjja extends Application {

    Easy game;
    Mediam game2;
    Hard game3;
    Arcade arcade;
    Scene scene;
  private Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
  stage = primaryStage;
        game = Easy.getInstance(stage);
        game2 = Mediam.getInstance(stage);
        game3 = Hard.getInstance(stage);
        arcade = Arcade.getInstance(stage);
        StateContext cont = new StateContext(new MenuSound());
        cont.playSound();

        Button easy = new Button("EASY");
        Button mediam = new Button("MEDIAM");
        Button hard = new Button("HARD");
        Button arc = new Button("ARCADE");
        Button exit = new Button("EXIT");

        easy.setStyle("-fx-background-color: yellow");
        mediam.setStyle("-fx-background-color: yellow");
        hard.setStyle("-fx-background-color: yellow");
        exit.setStyle("-fx-background-color: yellow");
        Image image = new Image(getClass().getResourceAsStream("background_1.jpg"));
        BackgroundImage img;
        img = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background background = new Background(img);

        VBox box = new VBox();

        box.getChildren().addAll(easy, mediam, hard, arc, exit);
        box.setBackground(background);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(5);

        exit.setOnAction((ActionEvent e) -> {
            stage.close();
        });

        easy.setOnAction((ActionEvent e) -> {

            try {
                game.prepareScene();
                stage.setScene(game.getScene());
                cont.stop();
            } catch (IOException ex) {
                Logger.getLogger(Ninjja.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        mediam.setOnAction((ActionEvent e) -> {

            try {
                game2.prepareScene();
                stage.setScene(game2.getScene());
                cont.stop();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ninjja.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
          Logger.getLogger(Ninjja.class.getName()).log(Level.SEVERE, null, ex);
      }

        });

        hard.setOnAction((ActionEvent e) -> {

            try {
                game3.prepareScene();
                stage.setScene(game3.getScene());
                cont.stop();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ninjja.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
          Logger.getLogger(Ninjja.class.getName()).log(Level.SEVERE, null, ex);
      }

        });
        arc.setOnAction((ActionEvent e) -> {
            try {
                arcade.prepareScene();
                stage.setScene(arcade.getScene());
                cont.stop();
            } catch (IOException ex) {
                Logger.getLogger(Ninjja.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        scene = new Scene(box, 800, 800);

        stage.setScene(scene);
        stage.setTitle("NINJA");
        stage.setResizable(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    public Stage getStage(){return stage;}
    public Scene getScene(){return scene;}

}
