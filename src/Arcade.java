
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Arcade {
   private Stage stage;
    FruitFactory f = new FruitFactory();
    Scene scene;
    private int seconds = 60;
    Label lb, lb2, lb3;
    private int score = 0;
    Timeline timeline;
    double speed = 1;
    Score scr = new Score();
    StateContext cont;
    List<ImageView> drop = new ArrayList<>();
    List<Fruit> drop1 = new ArrayList<>();
    private static Arcade instance;

    private Arcade(Stage stage) {
    }

    public static Arcade getInstance(Stage stage) {
        if (instance == null) {
            instance = new Arcade(stage);
        }
        return instance;
    }

    public void prepareScene() throws IOException {
        //   scr.loadScore("score.txt");
        Pane canvas = new Pane();
        lb = new Label();
        lb3 = new Label();
        lb2 = new Label("score: " + score);
        lb2.setTranslateY(20);
        lb3.setTranslateY(50);
        lb3.setText("Highest score: " + scr.readXmlScore("gamescore.xml"));
        lb.setStyle("-fx-background-color: white");
        lb2.setStyle("-fx-background-color: white");
        lb3.setStyle("-fx-background-color: white");
        scene = new Scene(canvas, 640, 360, Color.ALICEBLUE);
        ImageView iv1 = new ImageView(new Image(getClass().getResourceAsStream("watermelon.png")));
        iv1.setLayoutX(Math.random() * 300);
        iv1.setLayoutY(250);
        iv1.setFitHeight(50);
        iv1.setFitWidth(65);
        canvas.getChildren().addAll(lb, lb2, lb3);
        Image image = new Image(getClass().getResourceAsStream("mainscene.jpg"));
        BackgroundImage img;
        img = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background background = new Background(img);
        canvas.setBackground(background);

        doTime();
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), (ActionEvent t) -> {
           speed += 500 / 3000;
            
                Fruit watermelon = f.getType("watermelon");
                watermelon.setProperties();
                watermelon.getImageView().setOnMouseClicked(e -> {
                    SliceWatermelon slice = new SliceWatermelon(new GetSliced(), (Watermelon) watermelon);
                    slice.execute();
                    cont = new StateContext(new SplatterSound());
                    cont.playSound();
                    score += 10;
                    lb2.setText("score: " + score);
                });
                drop1.add(watermelon);
                canvas.getChildren().add((drop1.get(drop1.size() - 1)).getImageView());

                Fruit banana = f.getType("banana");
                banana.setProperties();
                banana.getImageView().setOnMouseClicked(e -> {
                    SliceBanana slice = new SliceBanana(new GetSliced(), (Banana) banana);
                    slice.execute();
                    cont = new StateContext(new SplatterSound());
                    cont.playSound();
                    score += 10;
                    lb2.setText("score: " + score);
                });
                drop1.add(banana);
                canvas.getChildren().add((drop1.get(drop1.size() - 1)).getImageView());
            
                Fruit strawberry = f.getType("strawberry");
                strawberry.setProperties();
                strawberry.getImageView().setOnMouseClicked(e -> {
                    SliceStrawberry slice = new SliceStrawberry(new GetSliced(), (Strawberry) strawberry);
                    slice.execute();
                    cont = new StateContext(new SplatterSound());
                    cont.playSound();
                    score += 10;
                    lb2.setText("score: " + score);
                });
                drop1.add(strawberry);
                canvas.getChildren().add((drop1.get(drop1.size() - 1)).getImageView());


        }));
        timeline.setCycleCount(500);
        timeline.play();

        AnimationTimer timer = new AnimationTimer() {
            double dy = 3;

            @Override
            public void handle(long arg0) {

                for (int i = 0; i < drop1.size(); i++) {
                    drop1.get(i).move(speed);
                    if (drop1.get(i).hasMovedOffScreen()) {
                        canvas.getChildren().remove(drop1.get(i).getImageView());
                        drop1.remove(i);

                    }
                }
            }

        };
        timer.start();

    }

    private void doTime() {
        Timeline time = new Timeline();
        KeyFrame frame = new KeyFrame(Duration.minutes(0).add(Duration.seconds(1)), (ActionEvent event) -> {
            seconds--;
            lb.setText("time left: " + seconds);
            if (seconds <= 0) {
                try {
                    time.stop();
                    timeline.stop();
                    if (score > scr.readXmlScore("gamescore.xml")) {
                        scr.saveXmlScore("gamescore.xml", score);
                        lb2.setText("score: " + scr.readXmlScore("gamescore.xml"));
                    }
                    HintAlert.display("Time is up! Your score is " + score + "\n" + "Highest score is " + scr.readXmlScore("gamescore.xml"));
                } catch (IOException ex) {
                    Logger.getLogger(Arcade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if (time != null) {
            time.stop();
        }
        time.play();
    }

    public Scene getScene() {
        return scene;
    }

    public int getScore() {
        return score;
    }

}
