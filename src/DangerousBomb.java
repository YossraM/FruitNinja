
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
public class DangerousBomb implements Bomb,GameObject {
   ImageView image;
   final Image img1 = new Image(getClass().getResourceAsStream("bomb.png"));
       final Image img2 = new Image(getClass().getResourceAsStream("explode.png"));
       private Image[] images;
       int posX;
       int posY;
    @Override
    public void setProperties() {
         image = new ImageView();
       image.setImage(img1);
       images = new Image[2];
       images[0]=img1;
       images[1]=img2;
       setX((int)(Math.random() * 600));
       setY(-10);
        image.setFitHeight(50);
        image.setFitWidth(65);
    }
     public Image getImage1(){return img1;}
    public Image getImage2(){return img2;}

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
        return image.getImage().equals(images[1]);
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
        return images;
     
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
        return false;
    }
}
