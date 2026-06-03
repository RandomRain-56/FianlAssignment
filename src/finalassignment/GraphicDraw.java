/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalassignment;

//import the draw core
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 350325485
 */
public class GraphicDraw extends PApplet{
    //set a variable to controle the stage 
    private int stage = 0;
    //set the Pangu
    private PanGu pangu;
    //Set this for a Fixed Point for all image
    public static final int FixedPointX = 0;
    public static final int FixedPointY = 0;
    //intalize the image
    //initanlize the bakcgournd image
    private PImage BackGround ;
    
     public void settings(){
         //set the screen size
         size (1200,800);
     }
     public void setup(){
         BackGround = this.loadImage("images/GroundSunGreen.png");
         pangu = new PanGu(this, 800, 600);
     }
     
     public void draw(){
         if (stage == 0){//if the fist stage
            //draw the background
            this.image(BackGround, FixedPointX, FixedPointY);
            //draw the Text
            textSize(30);//set the text size
            text("Press Enter for next stage:", 20, 50);
        }else if (stage == 1){//if the second stage
            background(0,0,0);
            pangu.draw();
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
         
     }
}


