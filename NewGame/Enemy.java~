import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Enemy{
  
  double x;
  double y;
  
  double r;
  double t;
  double tv=0;
  double rv=0;
  double ta;
  double ra;
  double friction=0.0005;
  
  double maxtv=0.005;
  double maxrv=2;
  
  double xc=500;
  double yc;
  
  
  
  public Enemy(){ 
  
  }
  
  public Enemy(double newR,double newT,double off){
   r=newR;
   t=newT;
   yc=off;
   convert();
  }
  
 
  
  public void physics(){
    tv=tv+ta;
    rv=rv+ra;
    
    if(ta==0 && tv>0){
    tv=tv-friction;
    if(tv<0){tv=0;}
    }
    if(ta==0 && tv<0){
    tv=tv+friction;
    if(tv>0){tv=0;}
    }
    
    if(tv>maxtv){tv=maxtv;}
    if(tv<-maxtv){tv=-maxtv;}
    if(rv>maxtv){rv=maxrv;}
    if(rv<-maxtv){rv=-maxrv;}
    
    
    
    t=t+tv;
    r=r+rv;
    
    if(r<=0){r=0;}
    
    convert();
  }
  
  void convert(){
   x=xc+r*Math.cos(t);
   y=yc+r*Math.sin(t);
  }
  
  public boolean reproduce(double maxr){
    if(r<maxr){
     return true; 
    }
    else{
     return false; 
    }
  }
  
  
  
  
  
}