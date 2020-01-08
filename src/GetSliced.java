/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author ELMASREYA
 */
public class GetSliced {
    public void sliceWatermelon(Watermelon fruit){
        fruit.getImageView().setImage(fruit.getImage2());
    }
    public void sliceStrawberry(Strawberry fruit){
        fruit.getImageView().setImage(fruit.getImage2());
    }
        public void sliceBanana(Banana fruit){
        fruit.getImageView().setImage(fruit.getImage2());
    }
        public void slicePom(Pomegrenate pom){
            pom.getImageView().setVisible(false);
        }
        public void sliceDragonFruit( DragonFruit dragon){
            dragon.getImageView().setVisible(false);
        }
        public void sliceBomb(FatalBomb bomb){
           bomb.getImageView().setImage(bomb.getImage2());
        }
        public void sliceBomb(DangerousBomb bomb){
           bomb.getImageView().setImage(bomb.getImage2());
        }
}
