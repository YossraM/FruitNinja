/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class StateContext {
    private SoundState state;
   public StateContext(SoundState state){
        this.state=state;
    }
   public void playSound(){
       state.play();
   }
   public void stop(){
       state.stop();
   }
}
