/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class SliceDragonFruit implements Command {
    private GetSliced slice;
   private DragonFruit dragon;
    SliceDragonFruit(GetSliced slice,DragonFruit dragon){
        this.slice=slice;
        this.dragon=dragon;
    }

    @Override
    public void execute() {
        slice.sliceDragonFruit(dragon);
    }
}
