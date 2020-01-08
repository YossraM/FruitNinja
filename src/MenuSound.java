
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class MenuSound implements SoundState {
 MediaPlayer mediaplayer;
 public MenuSound(){
    
 }
    @Override
    public void play() {
        String path="C:\\Users\\ELMASREYA\\Desktop\\sound\\menu.mp3";
     Media hit = new Media(new File(path).toURI().toString());
     mediaplayer = new MediaPlayer(hit);
     mediaplayer.play();
    }
    public void stop(){mediaplayer.stop();}
    
}
