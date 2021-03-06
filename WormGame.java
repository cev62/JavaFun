import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import java.lang.Math;

public class WormGame extends JFrame
  implements ActionListener, KeyListener, MouseListener
{
  
  int numOfObjects=10;
    Random rand;
  JLabel label;
  Timer timer;
  BallStorage[] ball=new BallStorage[numOfObjects+1];
  Ellipse2D[] b=new Ellipse2D[numOfObjects+1];
  double[] vStoragex=new double[numOfObjects+1];
  double[] vStoragey=new double[numOfObjects+1];
  int i=0;
  int cirCount=0;
  double change=1;
  double size=10;
  
  
  public WormGame(){
    
    Container window = getContentPane();
  addKeyListener(this);
  addMouseListener(this);
  setSize(600,400);
  setFocusable(true);
  setTitle("Worm Game");
  setVisible(true);
  window.setLayout(new BorderLayout());
  label=new JLabel("", JLabel.CENTER);
  label.setForeground(Color.BLACK);
  window.add(label, BorderLayout.NORTH);
  window.setBackground(Color.WHITE); 
    timer=new Timer(20,this);
    timer.start();
   rand=new Random();

    
    
    while(i<numOfObjects+1){
  ball[i]=new BallStorage();
  i++;
  }
    
    ball[1].isLeader=true;
    ball[1].setPoint(300,200);
    ball[1].setSize(size,size);
    cirCount++;
    repaint();
  }
  
  public void paint(Graphics g){
   super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    int k=1;
      while(k<=cirCount){
      g2d.draw(b[k]=new Ellipse2D.Double(ball[k].getX()-ball[k].getXSize()/2,ball[k].getY()-ball[k].getYSize()/2,ball[k].getXSize(),ball[k].getYSize()));
      g2d.fill(b[k]);
      k++;
  }
  }
  
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==timer){
      physics();
      label.setText(Integer.toString(cirCount));
     repaint(); 
    }
  }
  
  
  
  public void mousePressed(MouseEvent m){
    
  newBall();
  
  }
  
   public void keyReleased(KeyEvent k){
    if(k.getKeyCode()==37){
     ball[1].xa=0; 
    }
    if(k.getKeyCode()==39){
     ball[1].xa=0; 
    }
    if(k.getKeyCode()==38){
     ball[1].ya=0; 
    }
    if(k.getKeyCode()==40){
     ball[1].ya=0; 
    }
  }
  
  public void keyTyped(KeyEvent k){
    
  }
  
   public void keyPressed(KeyEvent k){
     if(k.getKeyCode()==37){
     ball[1].xa=-0.1;
   }
     if(k.getKeyCode()==38){
     ball[1].ya=-0.1;
   }
     if(k.getKeyCode()==39){
     ball[1].xa=0.1;
   }
     if(k.getKeyCode()==40){
     ball[1].ya=0.1;
   }
  }
  
  public void mouseReleased(MouseEvent m){
    
  }
  
  public void mouseExited(MouseEvent m){
    
  }
  
  public void mouseEntered(MouseEvent m){
    
  }
  
  public void mouseClicked(MouseEvent m){
    
  }
  
  public void newBall(){
   if(cirCount<numOfObjects){
      cirCount++;
      double x=ball[cirCount-1].x+size;
      double y=ball[cirCount-1].y;
    ball[cirCount].setPoint(x,y);
    ball[cirCount].setSize(size,size);
  } 
  }
  
  public void physics(){
   
     
    
    int k=cirCount;
    while(k>1){
       ball[k].xv=vStoragex[k-1];
       ball[k].yv=vStoragey[k-1];
       ball[k].physics();
    k=k-1;
    }
    ball[1].physics();
    
    k=1;
    while(k<=cirCount){
       vStoragex[k]=ball[k].xv;
       vStoragey[k]=ball[k].yv;
    k++;
    }
    
    k=1;
    while(k<=cirCount){
     ball[k].move();
     k++;
    }
    
  }
  
  public static void main(String[] args){
   new WormGame(); 
  }
  
  
}