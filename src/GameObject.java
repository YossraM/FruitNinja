/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ELMASREYA
 */
public interface GameObject {
    public int getXlocation();
public void setX(int posX);
public void setY(int posY);
public int getYlocation();

public int getMaxHeight();



public Boolean isSliced();
public Boolean isFruit();

public Boolean hasMovedOffScreen();
public void slice();

public void move(double time);
public Image[] getImages();
public ImageView getImageView();
}
