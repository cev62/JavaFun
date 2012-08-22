//PongApp
//Author: Aaron P. Maharry
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;

public class PongApp extends JFrame
  implements ActionListener, KeyListener
  {
  
  //Initialization
  
  public JLabel label;
  Timer timer;
  Ellipse2D cir;
  RoundRectangle2D rec1;
  RoundRectangle2D rec2;
  Random rand;
  
  int changex=2;
  int changey=2;
  
  int friction=1;
  int maxspeed=8;
  int nmaxspeed=-maxspeed;
  int maxspeedcir=10;
  int nmaxspeedcir=-maxspeedcir;
  
  int p1=0;
  int p2=0;
  String disp="";
  
  int cirx= 290;
  int cirxs=0;
  //Double cirxr=0.00;
  int ciry= 200;
  int cirys=0;
  //Double ciryr=0.00;
  int rec1x= 10;
  int rec1xs=0;
  int rec1xa=0;
  //Double rec1xr=0.00;
  int rec1y= 150;
  int rec1ys=0;
  int rec1ya=0;
  //Double rec1yr=0.00;
  int rec2x= 570;
  int rec2xs=0;
  int rec2xa=0;
  //Double rec2xr=0.00;
  int rec2y= 150;
  int rec2ys=0;
  int rec2ya=0;
  //Double rec2yr=0.00;
  
  int p1turn=0;
  boolean rightkeycheck=false;
  boolean leftkeycheck=false;
  boolean upkeycheck=false;
  boolean downkeycheck=false;
  boolean wkeycheck=false;
  boolean akeycheck=false;
  boolean skeycheck=false;
  boolean dkeycheck=false;
  
  
  
  public PongApp(){


  
  //Initializes the window

    
    
    GradientPaint back=new GradientPaint(0,0,Color.GRAY,0,400,Color.BLACK);
  
  Container window = getContentPane();
  addKeyListener(this);
  setSize(600,400);
  setFocusable(true);
  setTitle("Pong");
  setVisible(true);
  window.setLayout(new BorderLayout());
  label=new JLabel("output", JLabel.CENTER);
  label.setForeground(Color.WHITE);
  window.add(label, BorderLayout.NORTH);
  window.setBackground(Color.BLACK);
  timer = new Timer(40, this);
        timer.start();
   
   rand=new Random();
   
   p1turn=rand.nextInt(2);
   //label.setText(Integer.toString(p1turn));
   if(p1turn==0){
    cirx=340;
    
   }
   else{
    cirx=240; 
   }
  }
  
  
  
  //Creates instance of my game
  public static void main(String[] args){
   new PongApp(); 
  }
 
  //Renders Graphics
  
  public void paint(Graphics g){
    super.paint(g);
  Graphics2D g2d = (Graphics2D)g;
 GradientPaint greentoyellow=new GradientPaint(0,0,Color.GREEN,300,0,Color.YELLOW);
 GradientPaint yellowtogreen=new GradientPaint(300,0,Color.YELLOW,600,0,Color.GREEN); 
 GradientPaint ballPaint=new GradientPaint(0,0,Color.GREEN,0,400,Color.BLUE);
 g2d.setPaint(greentoyellow);
    g2d.draw(rec1=new RoundRectangle2D.Double(rec1x,rec1y,20,100,20,20));
    g2d.fill(rec1);
 g2d.setPaint(yellowtogreen);
    g2d.draw(rec2=new RoundRectangle2D.Double(rec2x,rec2y,20,100,20,20));
    g2d.fill(rec2);
 g2d.setPaint(ballPaint);
    g2d.draw(cir=new Ellipse2D.Double(cirx,ciry,20,20));
    g2d.fill(cir);
  }
  

  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==timer){
      
      //Acceleration Code
      //X accel
      if(rec1xa<0){
      if(rec1x>0){
       rec1xs=rec1xs-changex;
       //rec1xs=rec1xr.intValue();
       if(rec1xs<nmaxspeed){
         rec1xs=nmaxspeed;
        }
        
      }
      else{rec1x=0;}
      }
      
      else if(rec1xa>0){
      if(rec1x<275){
        rec1xs=rec1xs+changex;
        //rec1xs=rec1xr.intValue();
        if(rec1xs>maxspeed){
       rec1xs=maxspeed;
        }
      }
      else{rec1x=275;}
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
      if(rec1y>22){
       rec1ys=rec1ys-changey;
       //rec1ys=rec1yr.intValue();
       if(rec1ys<nmaxspeed){
        rec1ys=nmaxspeed; 
       }
      }
      else{rec1y=22;}
      }
      
      else if(rec1ya>0){
      if(rec1y<300){
       rec1ys=rec1ys+changey;
       //rec1ys=rec1yr.intValue();
       if(rec1ys>maxspeed){
        rec1ys=maxspeed; 
       }
      }
      else{rec1y=300;}
      }
      
      else{
        if(rec1ys<0){
         rec1ys=rec1ys+friction;
         //rec1ys=rec1yr.intValue();
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
        if(rec1x>=0){
        rec1x=rec1x+rec1xs;
        if(rec1x<0){rec1x=0;}
        }}
      else if(rec1xs>0){
        if(rec1x<=275){
        rec1x=rec1x+rec1xs;
        if(rec1x>275){rec1x=275;}
        }
      }
      else{}
      
      //Y
      if(rec1ys<0){
        if(rec1y>22){
        rec1y=rec1y+rec1ys;
        if(rec1y<22){rec1y=22;}
      }}
      else if(rec1ys>0){
        if(rec1y<300){
        rec1y=rec1y+rec1ys;
        if(rec1y>300){rec1y=300;}
        }}
      else{}
      
      //Rec2
      //Acceleration Code
      //X accel
      if(rec2xa<0){
      if(rec2x>305){
       rec2xs=rec2xs-changex;
       //rec2xs=rec2xr.intValue();
       if(rec2xs<nmaxspeed){
         rec2xs=nmaxspeed;
        }
        
      }
      else{rec2x=305;}
      }
      
      else if(rec2xa>0){
      if(rec2x<580){
        rec2xs=rec2xs+changex;
        //rec2xs=rec2xr.intValue();
        if(rec2xs>maxspeed){
       rec2xs=maxspeed;
        }
      }
      else{rec2x=580;}
      }
      
      else{
        if(rec2xs>0){
         rec2xs=rec2xs-friction;
         if(rec2xs<0){
         rec2xs=0;
         }
        }
        else if(rec2xs<0){
         rec2xs=rec2xs+friction; 
         if(rec2xs>0){
          rec2xs=0; 
         }
        }
      }
      
      //Y accell
      if(rec2ya<0){
      if(rec2y>22){
       rec2ys=rec2ys-changey;
       //rec2ys=rec2yr.intValue();
       if(rec2ys<nmaxspeed){
        rec2ys=nmaxspeed; 
       }
      }
      else{rec2y=22;}
      }
      
      else if(rec2ya>0){
      if(rec2y<300){
       rec2ys=rec2ys+changey;
       //rec2ys=rec2yr.intValue();
       if(rec2ys>maxspeed){
        rec2ys=maxspeed; 
       }
      }
      else{rec2y=300;}
      }
      
      else{
        if(rec2ys<0){
         rec2ys=rec2ys+friction;
         if(rec2ys>0){
          rec2ys=0; 
         }
        }
        else if(rec2ys>0){
         rec2ys=rec2ys-friction;
         if(rec2ys<0){
          rec2ys=0; 
         }
        }
      }
    
      
      
      //Velocity or Position code
      //X
      if(rec2xs<0){
        if(rec2x>305){
        rec2x=rec2x+rec2xs;
        if(rec2x<305){rec2x=305;}
        }}
      else if(rec2xs>0){
        if(rec2x<580){
        rec2x=rec2x+rec2xs;
        if(rec2x>580){rec2x=580;}
        }}
      else{}
      
      //Y
      if(rec2ys<0){
        if(rec2y>22){
        rec2y=rec2y+rec2ys;
        if(rec2y<22){rec2y=22;}
      }}
      else if(rec2ys>0){
        if(rec2y<300){
        rec2y=rec2y+rec2ys;
        if(rec2y>300){rec2y=300;}
        }}
      else{}
      
      
      //Code for behavior of ball
      
      if(cir.intersects((rec1x+10),rec1y,10,100)){
        if(cirx>rec1x){
          if (cirxs<0){
           cirxs=rec1xs-cirxs;
           if(cirxs>maxspeedcir){cirxs=maxspeedcir;}
          }
          else if(cirxs>=0){
           cirxs=rec1xs+cirxs; 
           if(cirxs>maxspeedcir){cirxs=maxspeedcir;}
          }
        }
        
        cirys=cirys+rec1ys;
        if(cirys>maxspeedcir){cirys=maxspeedcir;}
        if(cirys<nmaxspeedcir){cirys=nmaxspeedcir;}
      }
      else{
        if(cir.intersects(rec1x,rec1y,10,100)){
        if(cirx<rec1x){
          if (cirxs<0){
           cirxs=rec1xs+cirxs;
           if(cirxs<nmaxspeedcir){cirxs=maxspeedcir;}
          }
          else if(cirxs>=0){
           cirxs=rec1xs-cirxs; 
           if(cirxs<nmaxspeedcir){cirxs=nmaxspeedcir;}
          }
        }
        
        cirys=cirys+rec1ys;
        if(cirys>maxspeedcir){cirys=maxspeedcir;}
        if(cirys<nmaxspeedcir){cirys=nmaxspeedcir;}
      }
           }
        
        
      if(cir.intersects(rec2x,rec2y,10,100)){
        if(cirx<rec2x){
          if (cirxs<0){
           cirxs=rec2xs+cirxs; 
           if(cirxs<nmaxspeedcir){cirxs=nmaxspeedcir;}
          }
          else if(cirxs>=0){
           cirxs=rec2xs-cirxs; 
           if(cirxs<nmaxspeedcir){cirxs=nmaxspeedcir;}
          }
        } 
       
        cirys=cirys+rec2ys;
        if(cirys>maxspeedcir){cirys=maxspeedcir;}
        if(cirys<nmaxspeedcir){cirys=nmaxspeedcir;}
      }
      else{
      if(cir.intersects(rec2x+10,rec2y,10,100)){
        if(cirx>rec2x){
          if (cirxs<0){
           cirxs=rec2xs-cirxs;
           if(cirxs>maxspeedcir){cirxs=maxspeedcir;}
          }
          else if(cirxs>=0){
           cirxs=rec2xs+cirxs; 
           if(cirxs>maxspeedcir){cirxs=maxspeedcir;}
          }
        }
        
        cirys=cirys+rec2ys;
        if(cirys>maxspeedcir){cirys=maxspeedcir;}
        if(cirys<nmaxspeedcir){cirys=nmaxspeedcir;}
      }
      }
      
      
      //Cir coordinate calculations
      
      //X
      if(cirxs<0){
        if(cirx>0){
        cirx=cirx+cirxs;
        if(cirx<=0){cirx=340;ciry=200;cirxs=0;cirys=0;p2=p2+1;}
        }      
      }
      else if(cirxs>0){
        if(cirx<580){
        cirx=cirx+cirxs;
        if(cirx>=580){cirx=240;ciry=200;cirxs=0;cirys=0;p1=p1+1;}
        }}
      else{}
      
      //Y
      if(cirys<0){
        if(ciry>20){
        ciry=ciry+cirys;
        if(ciry<=20){ciry=20;}
      }
        else{
        cirys=-cirys;
        }
      }
      else if(cirys>0){
        if(ciry<380){
        ciry=ciry+cirys;
        if(ciry>=380){ciry=380;}
        }
        else{
          cirys=-cirys;
        }
      }
      else{}
      
      
      //Sets ScoreBoard:
      
      disp=Integer.toString(p1)+" | "+Integer.toString(p2);
      label.setText(disp);
      //label.setText(Integer.toString(rec2x) +", "+ Integer.toString(rec2y));
      
    repaint();
    }
    }
  
  public void keyPressed(KeyEvent e){
  
    //label.setText(Integer.toString(e.getKeyCode()));
    
    if(e.getKeyCode()==82){
      
  
 
  
   p1=0;
   p2=0;
  /*String disp="";
  
  if(rand.nextInt(2)==0){
    int cirx= 340;
  }
  else{
    int cirx= 240;
  }
  

  int ciry= 200;
  int rec1x= 10;
  int rec1y= 150;
  int rec2x= 570;
  int rec2y= 150;*/
    }
    
  if(e.getKeyCode()==37){
    leftkeycheck=true;
    rec2xa=-1;
  }
  else if(e.getKeyCode()==38){
    upkeycheck=true;
    rec2ya=-1;
  }
  else if(e.getKeyCode()==39){
    rightkeycheck=true;
    rec2xa=1;
  }
  else if(e.getKeyCode()==40){
    downkeycheck=true;
    rec2ya=1;
  }
  else if(e.getKeyCode()==65){
    akeycheck=true;
    rec1xa=-1;
  }
  else if(e.getKeyCode()==87){
    wkeycheck=true;
    rec1ya=-1;
  }
  else if(e.getKeyCode()==68){
    dkeycheck=true;
    rec1xa=1;
  }
  else if(e.getKeyCode()==83){
    skeycheck=true;
    rec1ya=1;
  }
  
}
  
public void keyReleased(KeyEvent e){
  
    
  if(e.getKeyCode()==37){
    leftkeycheck=false;
    if(rightkeycheck==true){
      rec2xa=1;
    }
    else{
    rec2xa=0;
    }
  }
  else if(e.getKeyCode()==38){
    upkeycheck=false;
    if(downkeycheck==true){
     rec2ya=1; 
    }
    else{
    rec2ya=0;
    }
    }
  else if(e.getKeyCode()==39){
    rightkeycheck=false;
    if(leftkeycheck==true){
      rec2xa=-1;
    }
    else{
    rec2xa=0;
    }
  }
  else if(e.getKeyCode()==40){
    downkeycheck=false;
    if(upkeycheck==true){
     rec2ya=-1; 
    }
    else{
    rec2ya=0;
    }
  }
  else if(e.getKeyCode()==65){
    akeycheck=false;
    if(dkeycheck==true){
      rec1xa=1;
    }
    else{
    rec1xa=0;
    }
  }
  else if(e.getKeyCode()==87){
    wkeycheck=false;
    if(skeycheck==true){
     rec1ya=1; 
    }
    else{
    rec1ya=0;
    }
    }
  else if(e.getKeyCode()==68){
    dkeycheck=false;
    if(akeycheck==true){
      rec1xa=-1;
    }
    else{
    rec1xa=0;
    }
  }
  else if(e.getKeyCode()==83){
    skeycheck=false;
    if(wkeycheck==true){
     rec1ya=-1; 
    }
    else{
    rec1ya=0;
    }
  }
}

public void keyTyped(KeyEvent e){
  
}
  
  
  
  

 


}

