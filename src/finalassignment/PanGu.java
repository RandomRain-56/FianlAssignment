/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalassignment;
//import the core
import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 350325485
 */
public class PanGu extends Person{
    private PImage image;//the image need to use
    
    public PanGu(PApplet p, int x, int y){
        super(p,x,y);//transfer VAriable to parent class
        this.image = p.loadImage("images/sleepMan.png");
    }
    public void moveTo(int dx, int dy){
        x =  dx;
        y = dy;
    }
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
    public void draw() {
        app.image(image, x, y);
    }
}
