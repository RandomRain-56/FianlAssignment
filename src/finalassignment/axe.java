/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalassignment;

import processing.core.PApplet;
import processing.core.PImage;
/**
 *
 * @author 350325485
 */
public class axe extends Person{
    public String Description;
    public String Name;
    public PImage images;
    
    public axe(PApplet p, String D, String N, String Path){
        super(p);
        Description = D;
        Name = N;
        images = p.loadImage("images/sleepMan.png");
    }
    public String getDescribtion(){
        return Description;
    }
    public String getName(){
        return Name;
    }
}
