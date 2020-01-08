/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public class BombFactory {
    
     public Bomb getType(String type){
       
       if(type.equalsIgnoreCase("FATAL BOMB"))
           return new FatalBomb();
       
       if(type.equalsIgnoreCase("DANGEROUS BOMB"))
           return new DangerousBomb();
        return null;
       
     
   }


}
