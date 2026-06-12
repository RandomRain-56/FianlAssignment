/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalassignment;

//import the draw core
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PFont;    
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
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
    private PanGu PG;
    public axe SuperAxe;
    public static boolean admin = false;
    //Set this for a Fixed Point for all image
    public static final int FixedPointX = 0;
    public static final int FixedPointY = 0;
    //intalize the image
    //initanlize the bakcgournd image
    private PImage BackGround ;
    private PImage Stage2Egg;
    private PImage Wind;
    private PImage StartWorld;
     public void settings(){
         //set the screen size
         size (1200,800);
     }
     public void setup(){
         BackGround = this.loadImage("images/StartingPage.png");
         Stage2Egg = this.loadImage("images/WorldEgg.png");
         SuperAxe = new axe (this, "Pangu use this axe to open sky", "Open Sky Axes", "images/axe.png");
         pangu = new PanGu(this, 384, 254,SuperAxe);
         PG = new PanGu(this, 384, 254,SuperAxe);
         Wind = this.loadImage("images/Wind.png");
         StartWorld = this.loadImage("images/Ground.png");
         DisplayInfo(pangu);
         DisplayInfo(SuperAxe);
         
     }
     public String [][] SenarioScentence= {
         {
                "Pangu used an axe to split the egg.",
                "The liquid in the egg begins to separate.",
                "The clear liquid flowed upwards.",
                "They became the sky.",
                "The foul liquid flowed downwards.",
                "They became the land.",
                "Thus, the world was formed."
            },
         {
                "The world was initially very narrow.",//0
                "Pangu used his own body to expand the world.",//1
                "That's why the sky is so high.",
                "Pangu died from the exhaustion.",//3
                "His body became part of the world.",
                "His eyes became the sun and moon.",//5
                "His sweat became rain, creating plants.",//6
                "His bones became mountains.",
                "His breath became the seasons and winds.",//8
                "His blood became rivers.",//9
                "Finally, Pangu became this world."//10
            }
     };
             
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
            String Page1Hint = "Press Space for strated";
            text(StartingWord, 100, 100);
            textSize(50);//set the text size
            text(Page1Hint, 320, 200);
        }else if (stage == 1){//if the second stage
            this.image(Stage2Egg, FixedPointX, FixedPointY);
            pangu.draw();//draw the main character
            //PG.draw();
            fill(255);//set the text color to white
            textSize(50);//set the text size
            int TextpointX = 75;
            int TextpointY = 113;
            String [] StateOneSentence = new String [7];
            try {
                Scanner FI = new Scanner ( new File("stageThree.txt"));
                int i = 0;
                while (FI.hasNext()){
                    StateOneSentence[i] = FI.nextLine();
                    i++;
                }
                FI.close();
            }catch(IOException e){
                System.out.println(e);
            }
            text (StateOneSentence[Stage1SentenceCount], TextpointX, TextpointY);
            /**
            
            if (pangu.isCollidingWith(PG)){
                fill(255,0,0);
                this.text("oouch1", PG.x, PG.y);
                image(Wind, 800,600);
            }**/
        }else if (stage == 2){
            this.image(Stage2Egg, FixedPointX, FixedPointY);
            pangu.draw();//draw the main character
            if (HeatCount == 2 && stage == 2){
                Stage2Egg = this.loadImage("images/MiddleEgg.png");
            }else if (HeatCount == 4 && stage == 2){
                Stage2Egg = this.loadImage("images/BrokenEgg.png");
            }
        }else if (stage == 3){
            this.image(Stage2Egg, FixedPointX, FixedPointY);
            pangu.draw();//draw the main character
            fill(255);//set the text color to white
            textSize(50);//set the text size
            int TextpointX = 75;
            int TextpointY = 113;

            text (SenarioScentence[0][Stage3SentenceCount], TextpointX, TextpointY);
        }else if (stage == 4){
            this.image(StartWorld, FixedPointX, FixedPointY);
            int TextpointX = 75;
            int TextpointY = 113;
            if (Stage4AnimationCount!= 10){
                pangu.draw();
            }
            if (keyPressed) {
                if (keyCode == LEFT) {
                  pangu.move(-5, 0);
                } else if (keyCode == RIGHT) {
                  pangu.move(5, 0);
                }
            }
            text (SenarioScentence[1][Stage4AnimationCount], TextpointX, TextpointY);
        }else if ( stage == 5){
            this.image(BackGround, FixedPointX, FixedPointY);
            String ByeBye = "Thank You for Your Wathcing!";
            int TextpointX = 75;
            int TextpointY = 113;
            text (ByeBye, TextpointX, TextpointY);
        }
     }
     public int Stage1SentenceCount = 0;
     public int Stage2PersonCount = 0;
     public int Stage3SentenceCount = 0;
     public int Stage4AnimationCount = 0;
     public boolean HeatCheck = true;
     public int HeatCount = 0;
     public boolean JumpCount = true;
     public void keyPressed(){
         if (stage == 0){//if  fist stage
            if (key == ' '){
                stage = 1;
            }
        }else if(stage == 1){
            if (key == ' '){
                Stage1SentenceCount++;
                if (Stage1SentenceCount == 4){
                    pangu.changeImage("images/man.png");
                    pangu.moveTo(420,210);
                }
                if (Stage1SentenceCount == 7){
                    stage = 2;
                    pangu.moveTo(146,166);
                    pangu.changeImage("images/ReadyToHeat.png");
                }
            }
        }else if (stage == 2){
            if (key == ' '){
                if (HeatCheck ){
                    pangu.changeImage("images/FinishHeat.png");
                    HeatCheck = false;
                    pangu.moveTo(146,166);
                }else {
                    pangu.changeImage("images/ReadyToHeat.png");
                    HeatCheck = true;
                    pangu.moveTo(146,166);
                }
            }
            if (!HeatCheck){
                HeatCount ++;
            }
            if ( HeatCount == 6){
                stage = 3;
            }
        }else if (stage == 3){
            if (key == ' '){
                Stage3SentenceCount++;
                if (HeatCheck ){
                    pangu.changeImage("images/FinishHeat.png");
                    HeatCheck = false;
                    pangu.moveTo(146,166);
                }else {
                    pangu.changeImage("images/ReadyToHeat.png");
                    HeatCheck = true;
                    pangu.moveTo(146,166);
                }
                if (Stage3SentenceCount == 6){
                    stage = 4;
                    pangu.changeImage("images/ReadyMan.png");
                    pangu.moveTo(428, 380);
                }
            }
        }else if (stage == 4){
            if (key == ' '){
                Stage4AnimationCount++;
            
            if (Stage4AnimationCount <3){
                if (JumpCount){
                    pangu.changeImage("images/JumpMan.png");
                    pangu.move(0, -200);
                    JumpCount = false;
                }else {
                    pangu.changeImage("images/ReadyMan.png");
                    pangu.move(0, 200);
                    JumpCount = true;
                }
            }else if (Stage4AnimationCount == 3){
                pangu.changeImage("images/DeathMan.png");
                pangu.moveTo(434, 409);
            }
            if (Stage4AnimationCount == 5){
                StartWorld = this.loadImage("images/GroudWithSun.png");
            }else if (Stage4AnimationCount ==   6){
                StartWorld = this.loadImage("images/GreenGround.png");
            }else if (Stage4AnimationCount ==   8){
                StartWorld = this.loadImage("images/GroundWithRiver.png");
            }else if (Stage4AnimationCount ==   9){
                StartWorld = this.loadImage("images/GroundWithRiver.png");
            }else if (Stage4AnimationCount ==   10){
                StartWorld = this.loadImage("images/GroundSunGreen.png");
            }else if (Stage4AnimationCount == 11){
                stage = 5;
            }
            }
        }else{
            
        }
     }
     public void mousePressed(){
         if (admin){
            System.out.println(mouseX+ " ," + mouseY);
            pangu.moveTo(mouseX, mouseY);
         }
     }
     public void DisplayInfo(Person p){
         System.out.println("x:" + p.x);
         System.out.println("y:" + p.x);
         if (p instanceof PanGu){
             System.out.println("it is Pangu");
            System.out.println("has " + ((PanGu) p).axes.Name);
            System.out.println("it is " + ((PanGu) p).axes.Description);
        }else if (p instanceof axe){
            System.out.println("has " + ((axe) p).Name);
            System.out.println("has " + ((axe) p).Name);
        }
     }
}


