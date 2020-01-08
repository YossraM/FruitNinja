/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ELMASREYA
 */
public class FruitFactory {
   public Fruit getType(String type){
       
       if(type.equalsIgnoreCase("WATERMELON"))
           return new Watermelon();
       
       if(type.equalsIgnoreCase("STRAWBERRY"))
           return new Strawberry();
       if(type.equalsIgnoreCase("BANANA"))
           return new Banana();
        return null;
       
     
   }
}
