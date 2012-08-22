 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Walls extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  JLabel label;
  Timer timer;
  
  Player p;
  //Ellipse2D.Double playerBall;
  
  double accel = 1;
  
  boolean upKey = false;
  boolean downKey = false;
  boolean leftKey = false;
  boolean rightKey = false;
  
  
  public Walls(){
  
  Container window = getContentPane();
  window.setLayout(new BorderLayout());
  label= new JLabel("Hello",JLabel.CENTER);
  window.add(label,BorderLayout.NORTH);
  
  
  addKeyListener(this);
  addMouseListener(this);
  setSize(1000,600);
  setFocusable(true);
  setTitle("Walls");
  setVisible(true);
  
  timer = new Timer(20,this);
  timer.start();
  
  p = new Player( 200, 250, 20 );
  
  repaint();
  
  }
  
  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    
    g2d.draw(new Ellipse2D.Double( p.x-p.size, p.y-p.size, 2*p.size, 2*p.size ) );
    //g2d.fill(playerBall);
    
  }
  
  public void actionPerformed(ActionEvent evt){
  
    p.physics();
    repaint();
    
  }
  
  public void mousePressed(MouseEvent m){
    
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
    
    label.setText(Integer.toString(key.getKeyCode()));
    
    if(key.getKeyCode() == 37){
     
      leftKey = true;
      p.xa = -accel;
      
    }
    
    if(key.getKeyCode() == 39){
     
      rightKey = true;
      p.xa = accel;
      
    }
    
    if(key.getKeyCode() == 38){
     
      upKey = true;
      p.ya = -accel;
      
    }
    
    if(key.getKeyCode() == 40){
     
      downKey = true;
      p.xa = accel;
      
    }
    
  }
  
  public void keyReleased(KeyEvent key){
      
    if(key.getKeyCode() == 37){
      
      leftKey = false;
      if(rightKey){
       p.xa = accel; 
      }
      else{
       p.xa = 0; 
      }
      
    }
    
    if(key.getKeyCode() == 39){
      
      rightKey = false;
      if(leftKey){
       p.xa = -accel; 
      }
      else{
       p.xa = 0; 
      }
      
    }
    
    if(key.getKeyCode() == 38){
      
      upKey = false;
      if(downKey){
       p.ya = accel; 
      }
      else{
       p.xa = 0; 
      }
      
    }
    
    if(key.getKeyCode() == 40){
      
      downKey = false;
      if(upKey){
       p.ya = -accel; 
      }
      else{
       p.ya = 0; 
      }
      
    }
    
  }
  
  public void keyTyped(KeyEvent key){
      
  }
  
  public static void main(String[] args){
   new Walls(); 
  }
  
}

class Player{
  
 double x;
 double y;
 double size;
 double xv;
 double yv;
 double xa;
 double ya;
 
 public Player(double xn, double yn, double sizen){
  
   x = xn;
   y = yn;
   size = sizen;
   xv = 0;
   yv = 0;
   xa = 0;
   ya = 0;
  
 }
 
 void physics(){
   
  x+=xv;
  y+=yv;
  
  xv+=xa;
  yv+=ya;
   
   
 }
  
}
  


