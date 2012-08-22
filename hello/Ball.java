import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

public class Ball extends Ellipse2D{
  
  double x;
  double y;
  
  public Ball(int xpos int ypos){
    
    x=(double)xpos;
    y=(double)ypos;
    
  }
  
  public double getXpos(){
   return x; 
  }
  
  public double getYpos(){
   return y; 
  }
  
}