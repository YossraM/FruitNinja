
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELMASREYA
 */
public abstract class SpecialFruit implements Fruit{
    @Override
    abstract public void setProperties();

    @Override
    abstract public ImageView getImageView();
   

    @Override
  abstract  public int getXlocation();
   

    @Override
  abstract  public void setX(int posX);
    

    @Override
   abstract public void setY(int posY);
   

    @Override
   abstract public int getYlocation();
    

    @Override
  abstract  public int getMaxHeight();
   

    @Override
   abstract public Boolean isSliced();
   

    @Override
abstract public Boolean hasMovedOffScreen();
    

    @Override
   abstract public void slice();
   

    @Override
   abstract public void move(double time);
    

    @Override
   abstract public Image[] getImages();
    

    
}
