/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalassignment;

//import the draw core
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;
/**
 *
 * @author 350325485
 */
public class GraphicDraw extends PApplet{
    //set a variable to controle the stage 
    private int stage = 0;
    PFont font;
    //set the Pangu
    private PanGu pangu;
    public static boolean admin = true;
    //Set this for a Fixed Point for all image
    public static final int FixedPointX = 0;
    public static final int FixedPointY = 0;
    //intalize the image
    //initanlize the bakcgournd image
    private PImage BackGround ;
    private PImage StartingEgg;
    
     public void settings(){
         //set the screen size
         size (1200,800);
     }
     public void setup(){
         BackGround = this.loadImage("images/StartingPage.png");
         StartingEgg = this.loadImage("images/WorldEgg.png");
         pangu = new PanGu(this, 384, 254);
     }
     
     public void draw(){
         if (stage == 0){//if the fist stage
            //draw the background
            this.image(BackGround, FixedPointX, FixedPointY);
            //draw the Text
            fill(0);//set the color to black
            textSize(50);//set the text size
            font = createFont("Georgia", 90);//set the font
            textFont(font);//use the font
            //variable for Starting page
            String StartingWord = "Pangu created the World!";
            String Page1Hint = "Press Enter for strated";
            text(StartingWord, 100, 100);
            textSize(50);//set the text size
            text(Page1Hint, 320, 200);
        }else if (stage == 1){//if the second stage
            this.image(StartingEgg, FixedPointX, FixedPointY);
            pangu.draw();
            /**
            if (keyPressed) {
                if (keyCode == LEFT) {
                  pangu.move(-5, 0);
                } else if (keyCode == RIGHT) {
                  pangu.move(5, 0);
                } else if (keyCode == UP) {
                  pangu.move(0, -5);
                } else if (keyCode == DOWN) {
                  pangu.move(0, 5);
                }
            }
            **/
        }
     }
     
     public void keyPressed(){
         if (stage == 0){//if  fist stage
            if (keyCode == ENTER ){
                stage = 1;
            }else if (key != CODED){//if second stage
                
            }
        }
     }
     public void mousePressed(){
         if (admin){
            System.out.println(mouseX+ " ," + mouseY);
            pangu.moveTo(mouseX, mouseY);
         }
     }
}


