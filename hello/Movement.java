//PongApp
//Author: Aaron P. Maharry
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Movement extends JFrame
  implements ActionListener, KeyListener
  {
  
  //Initialization
  
  public JLabel label;
  Timer timer;
  Ellipse2D cir;
  Rectangle2D rec1;
  Rectangle2D rec2;
  
  int changex=1;
  int changey=1;
  int friction=1;
  int maxspeed=10;
  int nmaxspeed=-maxspeed;

  int cirx= 300;
  int cirxs=0;
  int cirxa=0;
  int ciry= 200;
  int cirys=0;
  int cirya=0;
  int rec1x= 10;
  int rec1xs=0;
  int rec1xa=0;
  int rec1y= 150;
  int rec1ys=0;
  int rec1ya=0;
  int rec2x= 570;
  int rec2xs=0;
  int rec2xa=0;
  int rec2y= 150;
  int rec2ys=0;
  int rec2ya=0;
  
  
  boolean rightkeycheck=false;
  boolean leftkeycheck=false;
  boolean upkeycheck=false;
  boolean downkeycheck=false;
  
  
  
  public Movement(){


  
  //Initializes the window

  
  Container window = getContentPane();
  addKeyListener(this);
  setSize(600,400);
  setFocusable(true);
  setTitle("Pong");
  setVisible(true);
  window.setLayout(new BorderLayout());
  label=new JLabel("output", JLabel.CENTER);
  window.add(label, BorderLayout.NORTH);
  timer = new Timer(40, this);
        timer.start();
   label.setText("");
   
  }
  
  
  //Creates instance of my game
  public static void main(String[] args){
   new Movement(); 
  }
 
  //Renders Graphics
  
  public void paint(Graphics g){
    super.paint(g);
  Graphics2D g2d = (Graphics2D)g;
    g2d.draw(rec1=new Rectangle2D.Double(rec1x,rec1y,20,100));
    g2d.draw(rec2=new Rectangle2D.Double(rec2x,rec2y,20,100));
    g2d.draw(cir=new Ellipse2D.Double(cirx,ciry,20,20));
  }
  

  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==timer){
      
      //Acceleration Code
      //X accel
      if(rec1xa<0){
      if(rec1x>0){
       rec1xs=rec1xs-changex;
       if(rec1xs<nmaxspeed){
         rec1xs=nmaxspeed;
        }
        
      }
      else{rec1x=0;}
      }
      
      else if(rec1xa>0){
      if(rec1x<280){
        rec1xs=rec1xs+changex;
        if(rec1xs>maxspeed){
       rec1xs=maxspeed;
        }
      }
      else{rec1x=280;}
      }
      
      else{
        if(rec1xs>0){
         rec1xs=rec1xs-friction;
         if(rec1xs<0){
         rec1xs=0;
         }
        }
        else if(rec1xs<0){
         rec1xs=rec1xs+friction; 
         if(rec1xs>0){
          rec1xs=0; 
         }
        }
      }
      
      //Y accell
      if(rec1ya<0){
      if(rec1y>20){
       rec1ys=rec1ys-changey;
       if(rec1ys<nmaxspeed){
        rec1ys=nmaxspeed; 
       }
      }
      else{rec1y=20;}
      }
      
      else if(rec1ya>0){
      if(rec1y<300){
       rec1ys=rec1ys+changey;
       if(rec1ys>maxspeed){
        rec1ys=maxspeed; 
       }
      }
      else{rec1y=300;}
      }
      
      else{
        if(rec1ys<0){
         rec1ys=rec1ys+friction;
         if(rec1ys>0){
          rec1ys=0; 
         }
        }
        else if(rec1ys>0){
         rec1ys=rec1ys-friction;
         if(rec1ys<0){
          rec1ys=0; 
         }
        }
      }
    
      
      
      //Velocity or Position code
      //X
      if(rec1xs<0){
        if(rec1x>0){
        rec1x=rec1x+rec1xs;
        }}
      else if(rec1xs>0){
        if(rec1x<280){
        rec1x=rec1x+rec1xs;
        }}
      else{}
      
      //Y
      if(rec1ys<0){
        if(rec1y>20){
        rec1y=rec1y+rec1ys;
      }}
      else if(rec1ys>0){
        if(rec1y<300){
        rec1y=rec1y+rec1ys;
        }}
      else{}
      
    repaint();
    }
    }
  
  public void keyPressed(KeyEvent e){
  label.setText(Integer.toString(e.getKeyCode()));
    
  if(e.getKeyCode()==37){
    leftkeycheck=true;
    rec1xa=-1;
  }
  else if(e.getKeyCode()==38){
    upkeycheck=true;
    rec1ya=-1;
  }
  else if(e.getKeyCode()==39){
    rightkeycheck=true;
    rec1xa=1;
  }
  else if(e.getKeyCode()==40){
    downkeycheck=true;
    rec1ya=1;
  }
  else{}
  
}
  
public void keyReleased(KeyEvent e){
  label.setText(Integer.toString(e.getKeyCode()));
    
  if(e.getKeyCode()==37){
    leftkeycheck=false;
    if(rightkeycheck==true){
      rec1xa=1;
    }
    else{
    rec1xa=0;
    }
  }
  else if(e.getKeyCode()==38){
    upkeycheck=false;
    if(downkeycheck==true){
     rec1ya=1; 
    }
    else{
    rec1ya=0;
    }
    }
  else if(e.getKeyCode()==39){
    rightkeycheck=false;
    if(leftkeycheck==true){
      rec1xa=-1;
    }
    else{
    rec1xa=0;
    }
  }
  else if(e.getKeyCode()==40){
    downkeycheck=false;
    if(upkeycheck==true){
     rec1ya=-1; 
    }
    else{
    rec1ya=0;
    }
  }
  else{}
}

public void keyTyped(KeyEvent e){
  
}
  
  
  }
  

