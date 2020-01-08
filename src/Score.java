/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;

/**
 *
 * @author ELMASREYA
 */
public class Score {
    int score;

    public Score(){score=0;}
    public void setScore(int score){
        this.score=score;
    }
    public int getScore(){return score;}
  
    static List<Integer> scores = new ArrayList<>();
    
               public void saveScore(String filename, int score){
          try { 
  
            try ( 
                    BufferedWriter out = new BufferedWriter( new FileWriter(filename))) {
                
                   for(int s=0; s<scores.size();s++){
                     out.write(Integer.toString(scores.get(s)));
                     out.newLine();
                }  
                out.close();
            } 
        } 
        catch (IOException e) { 
            System.out.println("exception occured" + e); 
        } 
          System.out.println(scores);
    }
        public void loadScore(String filename){
     
       BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(filename));
            String inputLine;
            int i=0;
            while((inputLine=in.readLine())!=null){
                // String[] values = inputLine.split("\n");
                 
           scores.add(Integer.valueOf(inputLine));
                i=i+1;
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(Score.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
        public  int getMaxScore(){
            int max=scores.get(0);
            for(int i=0;i<scores.size();i++){
                if(max < scores.get(i))
                    max=scores.get(i);
            }
            return max;
        }
        public void saveXmlScore(String filename, int score) throws FileNotFoundException, IOException{
            FileOutputStream out = new FileOutputStream(new File(filename));
            XMLEncoder encoder = new XMLEncoder(out);
            encoder.writeObject(score);
            encoder.close();
            out.close();
            
        }
        public int readXmlScore(String filename) throws FileNotFoundException, IOException{
            FileInputStream in = new FileInputStream(new File(filename));
            XMLDecoder decoder = new XMLDecoder(in);
            int s =(int) decoder.readObject();
            decoder.close();
            in.close();
            return s;
        }
        
    
             
   
}
