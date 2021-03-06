import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class BlackHole extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  JLabel label;
  JPanel panel;
  
  Player player;
  Ball[] ball;
  
  int k=1;
  int ballCount=0;
  
  Timer timer;
  
  double centerx=500;
  double centery=1250;
  
  double changet=0.0005;
  
  boolean leftcheck=false;
  boolean rightcheck=false;
  
  boolean grav=false;
  
  int health=100;
  String healthStr=Integer.toString(health)+"%";
  
  public BlackHole(){
    
    Container window = getContentPane();
    window.setLayout(new BorderLayout());
    
    panel=new JPanel(null);
    
    label= new JLabel("Planet Health: "+healthStr,JLabel.CENTER);
    label.setBounds(0,500,1000,50);
    
    panel.add(label);
    window.add(panel,BorderLayout.CENTER);
    
    
    addKeyListener(this);
    addMouseListener(this);
    setSize(1000,600);
    setFocusable(true);
    setTitle("Black Hole");
    setVisible(true);
    
    player= new Player();
    player.xc=centerx;
    player.yc=centery;
    player.t=-Math.PI/2;
    player.r=950;
    player.convert();
    
    ball=new Ball[10];
    
    ballCount++;
    ball[1]=new Ball();
    ball[1].r=centery;
    ball[1].t=-Math.PI/2;
    ball[1].xc=centerx;
    ball[1].yc=centery;
    
    
    timer=new Timer(20,this);
    timer.start();
    
    repaint();
    
  }
  
  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    
    g2d.draw(new Ellipse2D.Double(centerx-(centery-500),centery-(centery-500),2*(centery-500),2*(centery-500)));
    
    try{
      g2d.draw(new Ellipse2D.Double(player.x-player.size/2,player.y-player.size/2,player.size,player.size));
    }  catch(NullPointerException e){}
    
    k=1;
    while(k<=ballCount){
      
      g2d.draw(new Ellipse2D.Double(ball[k].x-ball[k].size/2,ball[k].y-ball[k].size/2,ball[k].size,ball[k].size));
      k++;
      
    }
    
    
  }
  
  public void actionPerformed(ActionEvent evt){
    
    if(evt.getSource()==timer){
      
      player.physics();
      
      k=1;
      while(k<=ballCount){
        
        ball[k].physics(player.x,player.y,player.size);
        if(ball[k].r < centery-500+ball[k].size/2){
          health=health-(int)ball[k].size;
          ball[k].r=centery;
          ball[k].t=-Math.PI/2;
        }
        k++;
        
        
        if(grav){
          
          k=1;
          while(k<=ballCount){
            ball[k].grav();
            k++;
          }
          
        }
        else{
          
          k=1;
          while(k<=ballCount){
            ball[k].antiGrav();
            k++;
          }
          
        }
        
        k=1;
        while(k<=ballCount){
          
          ball[k].physicsXY();
          k++; 
          
        }
        
        healthStr=Integer.toString(health)+"%";
        label.setText("Planet Health: "+healthStr);
        
        repaint();
        
      }
      
    }
    
  }
  
  public void mousePressed(MouseEvent m){
    label.setText(Integer.toString(m.getX())+", "+Integer.toString(m.getY()));
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
    
    if(key.getKeyCode()==37){
      
      leftcheck=true;
      player.ta=-changet;
      
    }
    
    if(key.getKeyCode()==39){
      
      rightcheck=true;
      player.ta=changet;
      
    }
    
    if(key.getKeyCode()==32){
      
      grav=true;
      
    }
    
  }
  
  public void keyReleased(KeyEvent key){
    
    if(key.getKeyCode()==37){
      
      leftcheck=false;
      if(rightcheck){
        player.ta=changet; 
      }
      else{
        player.ta=0; 
      }
      
    }
    
    if(key.getKeyCode()==39){
      
      rightcheck=false;
      if(leftcheck){
        player.ta=-changet; 
      }
      else{
        player.ta=0; 
      }
      
    }
    
    if(key.getKeyCode()==32){
      
      grav=false;
      
    }
    
  }
  
  public void keyTyped(KeyEvent key){
    
  }
  
  public double distPts2D(double x1,double y1,double x2,double y2){
    return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }
  
  public static void main(String[] args){
    new BlackHole(); 
  }
  
}



class Ball{
  
  double x;
  double y;
  
  double xv=0;
  double yv=0;
  
  double xa=0;
  double ya=0;
  
  double size=50;
  
  double yc;
  double xc;
  
  double xcp;
  double ycp;
  
  double r;
  double t;
  double rv=-2;
  double tv=0;
  double ra=0;
  double ta=0;
  
  
  public Ball(){
    
  }
  
  public Ball(double xn,double yn){
    
    x=xn;
    y=yn;
    
  }
  
  public void grav(){
    
    double maga=10/Math.pow(distPts2D(x,y,xcp,ycp),2);
    xa=(xcp-x)*maga;
    ya=(ycp-y)*maga;
    
    find();
    
  }
  
  public void antiGrav(){
    
    xa=0;
    ya=0;
    
  }
  
  public void physicsXY(){
    
    xv=xv+xa;
    yv=yv+ya;
    
    x=x+xv;
    y=y+yv;
    
  }
  
  public void physics(double ox,double oy,double osize){
    
    xcp=ox;
    ycp=oy;
    
    
    
    tv=tv+ta;
    rv=rv+ra;
    
    t=t+tv;
    r=r+rv;
    
    convert();
    
    if(x+size/2 >= 1000){
      if(tv>0){
        tv=-Math.abs(tv);
      }
    }
    if(x-size/2 <= 0)
    {
      if(tv<0){
        tv=Math.abs(tv);
        
      }
    }   
  }
  
  public void convert(){
    
    x=xc+r*Math.cos(t);
    y=yc+r*Math.sin(t);
    
  }
  
  public void find(){
    
    t=Math.atan((x-xc)/(y-yc));
    r=distPts2D(x,y,xc,yc);
    
  }
  
  public double distPts2D(double x1,double y1,double x2,double y2){
    return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }
  
}


class Player{
  
  double x;
  double y;
  
  double size=25;
  
  double yc;
  double xc;
  
  double r;
  double t;
  double rv=0;
  double tv=0;
  double ra=0;
  double ta=0;
  
  double tf=0.0005;
  double rf=0.01;
  
  public Player(){
    
  }
  
  public Player(double xn,double yn){
    
    x=xn;
    y=yn;
    
  }
  
  public void physics(){
    
    tv=tv+ta;
    rv=rv+ra;
    
    if(ta==0){
      
      if(tv>0){
        tv=tv-tf;
        if(tv<0){
          tv=0; 
        }
      }
      if(tv<0){
        tv=tv+tf;
        if(tv>0){
          tv=0; 
        }
      }
      
    }
    
    if(ra==0){
      
      if(rv>0){
        rv=rv-rf;
        if(rv<0){
          rv=0; 
        }
      }
      if(rv<0){
        rv=rv+rf;
        if(rv>0){
          rv=0; 
        }
      }
      
    }
    
    t=t+tv;
    r=r+rv;
    
    convert();
    
    if(x+size/2 >= 1000){
      if(tv>0){
        tv=-Math.abs(tv);
      }
    }
    if(x-size/2 <= 0)
    {
      if(tv<0){
        tv=Math.abs(tv);
      }
    }
    
  }
  
  public void convert(){
    
    x=xc+r*Math.cos(t);
    y=yc+r*Math.sin(t);
    
  }
  
  public double distPts2D(double x1,double y1,double x2,double y2){
    return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }
  
  
}








