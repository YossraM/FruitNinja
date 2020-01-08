
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
public class Pomegrenate extends SpecialFruit {

     ImageView image;
    private final Image img = new Image(getClass().getResourceAsStream("pom.png"));
    int posX;
    int posY;

    Pomegrenate() {
        image = new ImageView(new Image(getClass().getResourceAsStream("pom.png")));
        setX((int)(Math.random() * 600));
       setY(-10);
        image.setFitHeight(50);
        image.setFitWidth(65);
    }

    @Override
    public void setProperties() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageView getImageView() {
        return image;
    }

     @Override
    public int getXlocation() {
        return posX;
    }

    @Override
    public int getYlocation() {
        return posY;
    }

    @Override
    public int getMaxHeight() {
        return 0;
    }

    @Override
    public Boolean isSliced() {
        if(image.isVisible()==false)
        return true;
        return false;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        return getYlocation() >=350;
    }

    @Override
    public void slice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(double time) {
        setY((int)(getYlocation()/1500 +  time + getYlocation()));

    }

    @Override
    public Image[] getImages() {
        return null;
     
    }

    @Override
    public void setX(int posX) {
        image.setLayoutX(posX);
        this.posX=posX;
    }

    @Override
    public void setY(int posY) {
        image.setLayoutY(posY);
        this.posY=posY;        
    }
     @Override
    public Boolean isFruit() {
        return true;
    }
    
}
