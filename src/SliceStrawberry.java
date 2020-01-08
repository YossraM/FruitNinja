/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ELMASREYA
 */
public class SliceStrawberry implements Command  {
     private GetSliced slice;
   private Strawberry strawberry;
    SliceStrawberry(GetSliced slice,Strawberry strawberry){
        this.slice=slice;
        this.strawberry=strawberry;
    }

    @Override
    public void execute() {
        slice.sliceStrawberry(strawberry);
    }
}
