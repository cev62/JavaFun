import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import java.lang.Math;

public class BallStorage{
  
  boolean mouseCheck=false;
  boolean holdCheck=false;
  boolean isLeader=false;
  boolean reachedGoal=true;
  
  double oldx;
  double oldy;
  double oldxv;
  double oldyv;
  double oldxa;
  double oldya;
  
  double x;
  double y;
  double newx;
  double newy;
  double xSize;
  double ySize;
  double xv=0;
  double yv=0;
  double xa=0;
  double ya=0;
  double mx;
  double my;
  double distx=0;
  double disty=0;
  double maxv=5;
  double friction=.01;
  
  public BallStorage(int xpos, int ypos,int xsize,int ysize){
    
    setPoint(xpos,ypos);
    setSize(xsize,ysize);
    
  }
  public BallStorage(){
   setPoint(0,0);
   setSize(0,0);
  }
  
  public double getX(){
   return x; 
  }
  
  public double getXSize(){
   return xSize; 
  }
  
  public double getYSize(){
   return ySize; 
  }
  
  public double getY(){
   return y; 
  }
  public void setPoint(int xpos,int ypos){
   x=(double)xpos;
    y=(double)ypos;
  }  
  public void setPoint(double xpos,double ypos){
   x=xpos;
    y=ypos;
  } 
  
  public void setSize(int xsize,int ysize){
    xSize=(double)xsize;
    ySize=(double)ysize;
  }
  
  public void setSize(double xsize,double ysize){
    xSize=xsize;
    ySize=ysize;
  }
  
  public void setOldPos(){
   oldx=x+xSize;
   oldy=y;
   oldxv=xv;
   oldyv=yv;
   oldxa=xa;
   oldya=ya;
  }
  
  public void move(){
    x=newx;
    y=newy;
  }
  
  public void physics(){
    
    
    
    
    xv=xv+xa;
    yv=yv+ya;
    
    
    
    if(xv>maxv){xv=maxv;}
    if(xv<-maxv){xv=-maxv;}
    if(yv>maxv){yv=maxv;}
    if(yv<-maxv){yv=-maxv;}
    
    newx=x+xv;
    newy=y+yv;
    
    if(newx<xSize/2){newx=xSize/2;xv=-xv;}
    if(newx>600-xSize/2){newx=600-xSize/2;xv=-xv;}
    
    if(newy<20+ySize/2){newy=20+ySize/2;yv=-yv;}
    if(newy>400-ySize/2){newy=400-ySize/2;yv=-yv;}
  }
  
  public void setMousePosition(int mousex,int mousey){
  mx=(double)mousex;
  my=(double)mousey;
  my=my-22;
  }
  
  
  double distFromMouseX(){
     distx=x-mx;
   return distx;
  }
  
  double distFromMouseY(){
    disty=y-my;
   return disty;
  }
  
  public void setAccel(double x,double y)
  {
    xa=x;
    ya=y;
  }
  
  public void setAccelx(double x){
   xa=x; 
  }
  
  public void setAccely(double x){
   ya=x; 
  }
  
  
  
  
  
}