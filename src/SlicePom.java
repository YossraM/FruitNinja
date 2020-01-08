/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class SlicePom implements Command {
  private GetSliced slice;
   private Pomegrenate pom;
    SlicePom(GetSliced slice,Pomegrenate pom){
        this.slice=slice;
        this.pom=pom;
    }

    @Override
    public void execute() {
        slice.slicePom(pom);
    }
}
