/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class SliceFatalBomb implements Command {
 private GetSliced slice;
   private FatalBomb bomb;
    SliceFatalBomb(GetSliced slice,FatalBomb bomb){
        this.slice=slice;
        this.bomb=bomb;
    }
    @Override
    public void execute() {
        slice.sliceBomb(bomb);
    }
 
    
}
