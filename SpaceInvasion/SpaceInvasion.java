import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;
import java.awt.geom.*;

public class SpaceInvasion extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  int planetCount=10;
  int armyCount=0;
  int maxarmyCount=1000;
  int k=1;
  
  JPanel panel;
  Random rand;
  Timer timer;
  Timer grow;
  
  Army[] army;
  Ellipse2D.Double[] armyCir;
  Planet[] planet;
  JLabel[] label;

  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public SpaceInvasion(){
  
  Container window = getContentPane();
  window.setLayout(new BorderLayout());
  
  JPanel panel=new JPanel(null);

  addKeyListener(this);
  addMouseListener(this);
  setSize(1000,600);
  setFocusable(true);
  setTitle("Space Invasion");
  setVisible(true);
  
  rand=new Random();
  

  
  
  
  army= new Army[maxarmyCount+1];
  armyCir= new Ellipse2D.Double[maxarmyCount+1];
  
  planet= new Planet[planetCount+1];
 
  k=1;
  while(k<=planetCount){
    
    boolean clear=false;
    
    while(!clear){
      
      planet[k]= new Planet(0,0,0);
      planet[k].size=rand.nextDouble()*100+50;
      planet[k].x=rand.nextDouble()*(1000-20-planet[k].size)+planet[k].size/2+10;
      planet[k].y=rand.nextDouble()*(600-44-planet[k].size)+planet[k].size/2+34;
      clear=true;
      
      int j=1;
      while(j<k){
        if(distPts2D(planet[k].x,planet[k].y,planet[j].x,planet[j].y) < 180 ){              
          clear=false;
          break;
        }
        else{
          clear=true; 
        }
        j++;
      }

    }
    
    k++;
    
  }
  

  
  timer= new Timer(40,this);
  timer.start();
  
  grow= new Timer(2000,this);
  grow.start();
  
  repaint();
  
  planet[1].inhabited=true;
  planet[1].player=true;
  planet[1].pop=50;
  
  label=new JLabel[planetCount+1];
  
  k=1;
  while(k<=planetCount){
    try{
    label[k]=new JLabel(Integer.toString(planet[k].pop),JLabel.CENTER);
    } catch(NullPointerException e){}
    try{
    label[k].setBounds((int)planet[k].x-(int)planet[k].size/2,(int)planet[k].y-24-(int)planet[k].size/2,(int)planet[k].size,(int)planet[k].size);
    } catch(NullPointerException e){}
    try{
    panel.add(label[k]);
    } catch(NullPointerException e){}
    k++;
  }
  
  
  window.add(panel,BorderLayout.CENTER);
  
  }
  
  
  
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  public void paint(Graphics g){

      super.paint(g);
      Graphics2D g2d = (Graphics2D)g;
      
      k=1;
      while(k<=armyCount){
        
        g2d.draw(armyCir[k] = new Ellipse2D.Double(army[k].x-army[k].size/2,army[k].y-army[k].size/2,army[k].size,army[k].size));
        k++;
        
      }
      
      k=1;
      while(k<=planetCount){
        
        try{
          g2d.draw(planet[k].cir = new Ellipse2D.Double(planet[k].x-planet[k].size/2,planet[k].y-planet[k].size/2,planet[k].size,planet[k].size));
        }catch(Exception e){}
        k++;
        
      }
      
      //g2d.setPaint(Color.WHITE);
      k=1;
      while(k<=planetCount){
        try{
        if(planet[k].player){
          try{
            g2d.draw(new Ellipse2D.Double(planet[k].x-planet[k].size/2+1,planet[k].y-planet[k].size/2+1,planet[k].size,planet[k].size));
          } catch(Exception e){}
        }
        k++;
      } catch(NullPointerException e){}
      }
      
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public void actionPerformed(ActionEvent evt){
  
    if(evt.getSource()==timer){
     /*
      k=1;
      int j=1;
      while(k<=planetCount){
        while(j<=armyCount){
          if(distPts2D(army[j].x,army[j].y,planet[k].x,planet[k].y) < planet[k].size+army[j].size){
            planet[k].pop+=5; 
          }
          j++;
        }
        k++;
      }*/
      
      k=1;
      while(k<=planetCount){
        label[k].setText(Integer.toString(planet[k].pop));
        k++;
      }
      repaint();
      
    }
    
    if(evt.getSource()==grow){
     
      k=1;
      while(k<=planetCount){
       
        if(planet[k].inhabited){
         planet[k].grow(); 
        }
        k++;
        
      }
      
    }
    
    
    
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public void mousePressed(MouseEvent m){
    
    armyCount++;
    army[armyCount]=new Army((double)m.getX(),(double)m.getY());
    
    repaint();
    
  }
  
  public void mouseReleased(MouseEvent m){
    
  }
  
  public void mouseExited(MouseEvent m){
    
  }
  
  public void mouseEntered(MouseEvent m){
    
  }
  
  public void mouseClicked(MouseEvent m){
    
  }
  
  public void keyPressed(KeyEvent key){
    
  }
  
  public void keyReleased(KeyEvent key){
      
  }
  
  public void keyTyped(KeyEvent key){
      
  }
  
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  public double distPts2D(double x1,double y1,double x2,double y2){
   return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }
  
  public static void main(String[] args){
   new SpaceInvasion(); 
  }
  
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Army{
  
 double x;
 double y;
 double size=10;
  
  
 public Army(){
   
 }
 
 public Army(double xn,double yn){
   x=xn;
   y=yn;
 }
  
  
  
  
  
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


class Planet{
  
  double x;
  double y;
  double size;
  
  boolean inhabited=false;
  boolean player=false;
  boolean computer=false;
  
  Ellipse2D.Double cir;
  
  int pop=0;
  
  public Planet(){
    
  }
  
  public Planet(double xn,double yn,double sizen){
    x=xn;
    y=yn;
    size=sizen;
  }
  
  public void grow(){
   
    pop++;
    
  }
  
  
  
}














