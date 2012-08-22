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

  
 double oldxv=0;
 double oldyv=0;
  double old1xv=0;
 double old1yv=0;
  double old2xv=0;
 double old2yv=0;
 double old3xv=0;
 double old3yv=0;
  double old4xv=0;
 double old4yv=0;
  double old5xv=0;
 double old5yv=0;
  double old6xv=0;
 double old6yv=0;
  double old7xv=0;
 double old7yv=0;
  double old8xv=0;
 double old8yv=0;
 double old9xv=0;
 double old9yv=0;
  double old10xv=0;
 double old10yv=0;
  double old11xv=0;
 double old11yv=0;

  

  
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
  double maxv=4;
  double friction=0.02;
  
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
  

  
  public void move(){
    x=newx;
    y=newy;
  }
  
  public void physics(){
    
    
    
    
    xv=xv+xa;
    yv=yv+ya;
    
    if(xv>0){xv=xv-friction;
    if(xv<0){xv=0;}
    }
    if(xv<0){xv=xv+friction;
    if(xv>0){xv=0;}
    }
    if(yv>0){yv=yv-friction;
    if(yv<0){yv=0;}
    }
    if(yv<0){yv=yv+friction;
    if(yv>0){yv=0;}
    }
    
    
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
  
  public boolean intersects(BallStorage bs){
    if(distPoints(x,y,bs.x,bs.y)<=xSize){
     return true; 
    }
    else{
     return false; 
    }
  }
  
  public boolean intersects(EnemyStorage es){
    if(distPoints(x,y,es.x,es.y)<=15){
     return true; 
    }
    else{
     return false; 
    }
  }

  public boolean intersects2(BallStorage bs){
    if(distPoints(x,y,bs.x,bs.y)<=.8*xSize){
     return true; 
    }
    else{
     return false; 
    }
  }  
  
    public double distPoints(double x1,double y1,double x2, double y2){
   return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }
  
  
}