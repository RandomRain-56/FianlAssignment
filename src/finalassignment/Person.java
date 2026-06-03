/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalassignment;

/**
 *
 * @author 350325485
 */
import processing.core.PApplet;

public class Person {
    public int x, y; // position of the person
    public PApplet app; //the canvas used to display graphical elements

    public Person(PApplet p, int x, int y) {
        this.app = p;
        this.x = x;
        this.y = y;
    }

    public void moveTo(int dx, int dy){
        x = dx;
        y = dy;
    }
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
