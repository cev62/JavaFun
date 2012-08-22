import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Player{
  
  double x;
  double y;
  double sizev;

  
  public Player(){ 
  
  }
  
  public Player(double newX,double newY){
   x=newX;
   y=newY;

  }
  
  public double physics(double size){
    return size+sizev;
  }
  
  
}