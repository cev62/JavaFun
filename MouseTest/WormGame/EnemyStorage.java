import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import java.lang.Math;

public class EnemyStorage{
  
  int x;
  int y;
  double newx;
  double newy;
  double xv=0;
  double yv=0;
  double xa=0;
  double ya=0;
  double xSize=20;
  double ySize=20;
  double maxv=4;
  Random rand;
  
  public EnemyStorage(int x1,int y1){
    rand=new Random();
    double r=((double)rand.nextInt(20))/10-1;
    
    xa=r;
    
    double r1=((double)rand.nextInt(20))/10-1;
    
    ya=r1;
    
    x=x1;
    y=y1;
    
    
  }
  
  public void physics(){
   
    xv=xv+xa;
    yv=yv+ya;
    
    if(Math.abs(xv)>=Math.abs(maxv)){xa=0;}
     if(Math.abs(yv)>=Math.abs(maxv)){ya=0;}
    
    newx=x+xv;
    newy=y+yv;
    
    if(newx<xSize/2){newx=xSize/2;xv=-xv;}
    if(newx>600-xSize/2){newx=600-xSize/2;xv=-xv;}
    
    if(newy<20+ySize/2){newy=20+ySize/2;yv=-yv;}
    if(newy>400-ySize/2){newy=400-ySize/2;yv=-yv;}
    
  }
  
  public void move(){
   x=(int)newx;
   y=(int)newy;
  }
  
  
  
  
  
  
  
  
  
  
}