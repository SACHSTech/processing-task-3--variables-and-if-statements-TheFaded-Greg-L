import processing.core.PApplet;
import processing.core.PFont;
/**
 * 
 * Drawing Random bricks on the screen and changing the colour based on the position. Also a clock
 * @author G. Lui 
 * Date Due: 7 March, 2022
 * 
 */

public class Sketch extends PApplet {

  // global variables
  // impliment font
  public PFont clockFont;

  // random background colour
  public float backgroundColourR = random(0, 255);
  public float backgroundColourG = random(0, 255);
  public float backgroundColourB = random(0, 255);

  // brick 1 positions
  public float brickX = 0;
  public float brickY = 0;

  // brick 2 positions
  public float brickXTwo = 0;
  public float brickYTwo = 0; 

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(700, 700);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
    
    //define font
    clockFont = createFont("Lato Bold", 100, true);
    textFont(clockFont);
    textAlign(CENTER, BASELINE);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */

  public void draw() {

    // first randomization to avoid endless loop
    if (brickX == 0 || brickY == 0){

      brickX = random(0, width - 100);
      brickY = random(0, height - 100);
      brickXTwo = random(0, width - 100);
      brickYTwo = random(0, height - 100); 
    }

    
    // change background to a new colour if brick one is not in bottom right and brick two is not in top left else return black background
    if (brickX >= width / 2 || brickY >= height / 2 || brickXTwo <= width / 2 || brickYTwo <= height / 2){

      background(backgroundColourR, backgroundColourG, backgroundColourB);
      fill(0, 0, 0);
    } else {

      background(0, 0, 0);
      fill(255, 255, 255);
    }

    // clock

    // define clock string
    String time = hour() + ":" + minute() + ":" + second() + " AM";

    //clock conditions
    if (hour() > 12){

      time = hour() - 12 + ":" + minute() + ":" + second() + " PM";
      text(time, (width/2), (height/2));
    } else if (hour() == 12){

      time = hour()+ ":" + minute() + ":" + second() + " PM";
      text(time, (width/2), (height/2));
    } else if (hour() == 0){

      time = "12:" + minute() + ":" + second() + " AM";
      text(time, (width/2), (height/2));
    } else {

      text(time, (width/2), (height/2));
    }

    // draw brick one
    bricks(brickX, brickY);
    
    // draw brick two
    bricks(brickXTwo, brickYTwo);
  }
  // randmomize position and background colour when mouse is released
  public void mouseReleased(){

    brickX = random(0, width - 100);
    brickY = random(0, height - 100);

    brickXTwo = random(0, width - 100);
    brickYTwo = random(0, height - 100);

    backgroundColourR = random(0, 255);
    backgroundColourG = random(0, 255);
    backgroundColourB = random(0, 255);
  }

  // draw bricks
  private void bricks(float cubeX, float cubeY){

    //brick outline
    stroke(0, 0, 0, 0);
    strokeWeight(1);
    fill(232, 164, 135);
    rect(cubeX, cubeY, 100, 100);
  
    //brick forecolour
    fill(176, 61, 16);
    rect(cubeX, cubeY, 15, 20);
    rect(cubeX + 20, cubeY, 45, 20);
    rect(cubeX + 70, cubeY, 30, 20);

    rect(cubeX, cubeY + 25, 45, 20);
    rect(cubeX + 50, cubeY + 25, 45, 20);

    rect(cubeX, cubeY + 50, 15, 20);
    rect(cubeX + 20, cubeY + 50, 45, 20);
    rect(cubeX + 70, cubeY + 50, 30, 20);

    rect(cubeX, cubeY + 75, 45, 20);
    rect(cubeX + 50, cubeY + 75, 45, 20);
    
    //brick highlights
    fill(212, 75, 17);
    rect(cubeX, cubeY, 15, 5);
    rect(cubeX + 20, cubeY, 45, 5);
    rect(cubeX + 70, cubeY, 30, 5);

    rect(cubeX, cubeY + 25, 45, 5);
    rect(cubeX + 50, cubeY + 25, 45, 5);

    rect(cubeX, cubeY + 50, 15, 5);
    rect(cubeX + 20, cubeY + 50, 45, 5);
    rect(cubeX + 70, cubeY + 50, 30, 5);

    rect(cubeX, cubeY + 75, 45, 5);
    rect(cubeX + 50, cubeY + 75, 45, 5);

    //brick shadows
    fill(161, 56, 11);
    rect(cubeX, cubeY + 15, 15, 5);
    rect(cubeX + 20, cubeY + 15, 45, 5);
    rect(cubeX + 70, cubeY + 15, 30, 5);

    rect(cubeX, cubeY + 40, 45, 5);
    rect(cubeX + 50, cubeY + 40, 45, 5);

    rect(cubeX, cubeY + 65, 15, 5);
    rect(cubeX + 20, cubeY + 65, 45, 5);
    rect(cubeX + 70, cubeY + 65, 30, 5);

    rect(cubeX, cubeY + 90, 45, 5);
    rect(cubeX + 50, cubeY + 90, 45, 5);
  }
}