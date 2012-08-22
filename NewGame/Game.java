 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Game extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  int numEnemy=400;        //Number of circles
  double changeT=0.001;    //Speed that you rotate enemies
  double rSpeed=2;         //radial speed of enemies
  double sizeV=1;          //Speed that you lose and gain size
  double offset=1250;
  
  double pSize=30;
  double playerSize=30;
  int xSize=1000;
  int ySize=600;
  Player player;
  Enemy[] enemy;
  Ellipse2D.Double p;
  Ellipse2D.Double e;
  Timer timer;
  Timer delay;
  Random rand;
  JLabel label;
  int cumulativeScore=0;
  int score=0;
  int topScore=0;
  
  boolean leftCheck=false;
  boolean rightCheck=false;
  boolean shrinking=false;
  boolean growing=false;
  boolean reverse=true;
  boolean pause=false;
  
  int k;
  
  public Game(){
  
    rand=new Random();
    label= new JLabel("hi",JLabel.CENTER);
    
    player=new Player(500,480);
    enemy=new Enemy[numEnemy+1];
    
    k=1;
    while(k<=numEnemy){
    createEnemy(k);

      k++;
    }
      
  Container window = getContentPane();
  window.setLayout(new BorderLayout());
  window.add(label,BorderLayout.NORTH);
  addKeyListener(this);
  addMouseListener(this);
  setSize(xSize,ySize);
  setFocusable(true);
  setTitle("Game");
  setVisible(true);
  
  
  timer= new Timer(20,this);
  timer.start();
  delay= new Timer(1000,this);
  
  
  k=1;
  while(k<=numEnemy){
  enemy[k].rv=-rSpeed;
  k++;
  }
  }
  
  public void paint(Graphics g){
   super.paint(g);
   Graphics2D g2d=(Graphics2D)g;
   g2d.draw(p=new Ellipse2D.Double(player.x-playerSize/2,player.y-playerSize/2,playerSize,playerSize)); 
   g2d.fill(p);
   k=1;
   while(k<=numEnemy){
   g2d.draw(e=new Ellipse2D.Double(enemy[k].x-pSize/2,enemy[k].y-pSize/2,pSize,pSize));
   g2d.setPaint(new GradientPaint(0,0,Color.GREEN,xSize,ySize,Color.YELLOW));
   g2d.fill(e);
   k++;
   }
  }
  
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==timer){
    k=1;
    while(k<=numEnemy){
    enemy[k].physics();
    if(enemy[k].reproduce(offset-ySize-pSize)){newEnemy(k);}
    
    if(leftCheck && rightCheck){
      
    }
    else if(leftCheck){
           enemy[k].ta=changeT; 
    }
    else if(rightCheck){
           enemy[k].ta=-changeT; 
    }
    else{
           enemy[k].ta=0; 
    }
    
    k++;
    }
    
    k=1;
    while(k<numEnemy){
      if(distPts2D(player.x,player.y,enemy[k].x,enemy[k].y)<playerSize/2+pSize/2 && !shrinking && !growing && !reverse){
       shrinking=true;
       break;
      }
      else{
       shrinking=false; 
      }
      k++; 
    }
    }
    if(evt.getSource()==delay){

     growing=true;
     delay.stop();
    }
    
    
      
    if(topScore<score){topScore=score;}
    
    
    label.setText("Score: "+ Integer.toString(score)+".  High Score: "+ Integer.toString(topScore));
    shrink();
    repaint();
  
  }
  
  public void shrink(){
    if(playerSize<=0){
      shrinking=false;
      reverse=true;
     delay.start();
     
     score=0;

      
    }
    if(playerSize>=pSize){
     
     reverse=false;
      
     growing=false; 
    }
  
    
    
    
    if(shrinking){
   player.sizev=-sizeV;
       playerSize=player.physics(playerSize); 
    }
    
    if(growing){

         player.sizev=sizeV;
       playerSize=player.physics(playerSize);
    }
    if(reverse){
    k=1;
      while(k<=numEnemy){
       enemy[k].rv=rSpeed;
        k++; 
      }
  }
    else{
     k=1;
     while(k<=numEnemy){
      enemy[k].rv=-rSpeed;
      k++;
     } 
    }
    
  }
  

  
  public void createEnemy(int index){
          enemy[index]=new Enemy(offset-(double)rand.nextInt((int)(offset)),(Math.PI*2)*1/600*(double)rand.nextInt(600),offset);
          enemy[index].rv=-rSpeed;

  }
  public void newEnemy(int index){
          enemy[index]=new Enemy(offset+(double)(rand.nextInt(100)-50),(Math.PI*2)*1/600*(double)rand.nextInt(600),offset);
          enemy[index].rv=-rSpeed;
          score++;
          cumulativeScore++;
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
    if(!reverse){
    if(key.getKeyCode()==37 || key.getKeyCode()==65){
      leftCheck=true;
    }
    
    if(key.getKeyCode()==39 || key.getKeyCode()==68){
      rightCheck=true;
    }
    }
    
    if(key.getKeyCode()==40 && !pause){
      k=1;
    while(k<=numEnemy){
     createEnemy(k);
     k++;
    }
    player.sizev=0;
    playerSize=pSize;
    }
    
    if(key.getKeyCode()==32 || key.getKeyCode()==27){
      if(pause){
        pause=false;
       timer.start(); 
      }
      else{
        pause=true;
       timer.stop(); 
       //delay.pause();
      }
    }
    
  }
  
  public void keyReleased(KeyEvent key){
    if(key.getKeyCode()==37 || key.getKeyCode()==65){
      leftCheck=false;
    }
    
    if(key.getKeyCode()==39 || key.getKeyCode()==68){
      rightCheck=false;
    }
    
  }
  
  public void keyTyped(KeyEvent key){
    
  }
  
  public double distPts2D(double x1,double y1,double x2,double y2){
   return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }

  
  public static void main(String[] args){
  new Game();
  }
  
}