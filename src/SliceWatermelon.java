/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ELMASREYA
 */
public class SliceWatermelon implements Command {
   private GetSliced slice;
   private Watermelon watermelon;
    SliceWatermelon(GetSliced slice,Watermelon watermelon){
        this.slice=slice;
        this.watermelon=watermelon;
    }

    @Override
    public void execute() {
        slice.sliceWatermelon(watermelon);
    }
}
