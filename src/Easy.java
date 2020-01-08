
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Easy {

    private static Easy instance;
    private Stage stage;
    GameOver over;
   private Scene scene;
    FruitFactory f = new FruitFactory();
    BombFactory b = new BombFactory();
    StateContext cont;
    Fruit straw;
    Fruit melon;
    Fruit banana;
    Timeline timeline;
    AnimationTimer timer;
    Label scr;
    Label life;
    Label max;
   
    List<GameObject> fall = new ArrayList<>();
    private int speed = 1;
    private int lives = 3;
    Score score = new Score();

    private Easy(Stage stage) {
        this.stage=stage;
    }

    public static Easy getInstance(Stage stage) {
        if (instance == null) {
            instance = new Easy(stage);
        }
        return instance;
    }

    public void prepareScene() throws IOException {
     over = GameOver.getInstance(stage);
     over.prepareScene();
        scr = new Label("score: " + score.getScore());
        scr.setTranslateY(20);
        scr.setStyle("-fx-background-color: white");
        max = new Label("highest score: " + score.readXmlScore("score.xml"));
        max.setTranslateY(50);
        max.setStyle("-fx-background-color: white");
        life=new Label("lives left: " + lives);
        life.setTranslateY(70);
  life.setStyle("-fx-background-color: red");
        
        

        Image image = new Image(getClass().getResourceAsStream("mainscene.jpg"));
        BackgroundImage img;
        img = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
        Background background = new Background(img);
        
        Pane root = new Pane();
        root.setBackground(background); root.getChildren().addAll(scr,max,life);
        
        timeline = new Timeline(new KeyFrame(Duration.millis(3000), (ActionEvent t) -> {
            speed += 500 / 3000;
               
            for(int i=0; i< Math.random()*3;i++){
                Fruit watermelon = f.getType("watermelon");
            watermelon.setProperties();
            watermelon.getImageView().setOnMouseClicked(e -> {
                SliceWatermelon slice = new SliceWatermelon(new GetSliced(), (Watermelon) watermelon);
                slice.execute();
                cont = new StateContext(new SplatterSound());
                cont.playSound();
                score.setScore(score.getScore() + 10);
                scr.setText("score: " + score.getScore());
            });
            fall.add(watermelon);
            root.getChildren().add((fall.get(fall.size() - 1)).getImageView());
     
            }
            
          for(int i=0; i< Math.random()*2;i++){
            Fruit banana = f.getType("banana");
            banana.setProperties();
            banana.getImageView().setOnMouseClicked(e -> {
                SliceBanana slice = new SliceBanana(new GetSliced(), (Banana) banana);
                slice.execute();
                cont = new StateContext(new SplatterSound());
                cont.playSound();
                score.setScore(score.getScore() + 10);
                scr.setText("score: " + score.getScore());
            });
            fall.add(banana);
            root.getChildren().add((fall.get(fall.size() - 1)).getImageView());
        }

            Fruit strawberry = f.getType("strawberry");
            strawberry.setProperties();
            strawberry.getImageView().setOnMouseClicked(e -> {
                SliceStrawberry slice = new SliceStrawberry(new GetSliced(), (Strawberry) strawberry);
                slice.execute();
                cont = new StateContext(new SplatterSound());
                cont.playSound();
                score.setScore(score.getScore() + 10);
                scr.setText("score: " + score.getScore());
            });
            fall.add(strawberry);
            root.getChildren().add((fall.get(fall.size() - 1)).getImageView());

            Bomb dbomb = b.getType("dangerous bomb");
            dbomb.setProperties();
            dbomb.getImageView().setOnMouseClicked(e -> {
                SliceDangerousBomb slice = new SliceDangerousBomb(new GetSliced(), (DangerousBomb) dbomb);
                slice.execute();
                cont = new StateContext(new BombSound());
                cont.playSound();
                lives--;
                life.setText("lives left: " + lives);
                
            });
            fall.add(dbomb);
            root.getChildren().add((fall.get(fall.size() - 1)).getImageView());
            
             Fruit specialf = new DragonFruit();

            specialf.getImageView().setOnMouseClicked(e -> {
                SliceDragonFruit slice = new SliceDragonFruit(new GetSliced(), (DragonFruit) specialf);
                slice.execute();
                cont = new StateContext(new SplatterSound());
                cont.playSound();
                score.setScore(score.getScore() + 1000);
                scr.setText("score: " + score.getScore() + "\nAwesome!!");
            });
            fall.add(specialf);
            root.getChildren().add((fall.get(fall.size() - 1)).getImageView());

        }));
        timeline.setCycleCount(500);
        timeline.play();

        timer = new AnimationTimer() {
            double dy = 3;

            @Override
            public void handle(long arg0) {

                for (int i = 0; i < fall.size(); i++) {
                    try {
                        fall.get(i).move(speed);
                        if (fall.get(i).hasMovedOffScreen()) {
                            root.getChildren().remove(fall.get(i).getImageView());
                            if (fall.get(i).isSliced()==false && fall.get(i).isFruit() == true) {
                                lives--;
                                life.setText("lives left: " + lives);
                                System.out.println(fall.get(i).isFruit());
                            }
                            fall.remove(i);
                            
                            
                        }
                        
                        if (lives == 0) {
                            timeline.stop();
                            timer.stop();
                           // HintAlert.display("Game over!");
                            stage.setScene(over.getScene());
                            break;
                        
                        }
                        if(score.getScore() > score.readXmlScore("score.xml")){
                            score.saveXmlScore("score.xml", score.getScore());
                            max.setText("Highest score: " + score.readXmlScore("score.xml"));
                        }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Easy.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Easy.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }

        };
        timer.start();

        scene = new Scene(root, 640, 360);

    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
