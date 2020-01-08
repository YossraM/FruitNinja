/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ELMASREYA
 */
public class SliceBanana implements Command {
     private GetSliced slice;
   private Banana banana;
    SliceBanana(GetSliced slice,Banana banana){
        this.slice=slice;
        this.banana=banana;
    }

    @Override
    public void execute() {
        slice.sliceBanana(banana);
    }
}
