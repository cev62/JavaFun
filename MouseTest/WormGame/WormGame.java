//WormGame
//Main class
//Uses BallStorage
//Uses EnemyStorage
//Uses FoodStorage

//import needed classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import java.lang.Math;


//declares the Class WormGame
public class WormGame extends JFrame
  implements ActionListener, KeyListener, MouseListener   /*WormGame uses an ActionListener for a timer and buttons, keylistener for controls, and mouselistener*/
{
  
  int numOfObjects=100;    //Declares the maximum number of balls, food, and enemies
  boolean foodCheck=true;  //checks if the number of food exceeds the limit
  boolean enemyCheck=true; //checks if the number of enemies exceeds the limit
    Random rand;           //Random number generator
  JLabel label;            //label displays score
  JButton classicButton;   //Button on menu
  JButton aboutButton;     //Button on menu
  Timer timer;             //timer for framerate
  BallStorage[] ball=new BallStorage[numOfObjects+1];  //Creates BallStorage for up to numOfObjects balls on the worm
  Ellipse2D[] b=new Ellipse2D[numOfObjects+1];         //Creates space to store the shapes of up to numOfObjects balls
  FoodStorage[] food=new FoodStorage[numOfObjects];    //Creates FoodStorage for up to numOfObjects food
  EnemyStorage[] enemy=new EnemyStorage[numOfObjects]; //Creates EnemyStorage for up to numOfObjects enemies
  Rectangle2D.Double f;     //the piece of food on the screen
  Ellipse2D.Double e;       //the enemy on the screen
  int i=0;                  //used later for initialization
  int cirCount=0;           //Counts the number of balls
  int foodCount=1;          //Counts the number of food that have been displayed
  int enemyCount=1;         //Counts the number of enemies that have been displayed
  int foodScore=1;          //Coefficient for points per food eaten
  int enemyScore=3;         //Coefficient for points per enemy eaten
  int score=0;              //Initializes score
  
   boolean rightkeycheck=false;   //These keep track of wheather keys are pressed
  boolean leftkeycheck=false;     //   they allow for multiple key to be pressed
  boolean upkeycheck=false;       //   and to program responds fluidly
  boolean downkeycheck=false;     //
  
  boolean gameMode=false;         //These determine if the menu is up
  boolean menuMode=true;          //or if the game is being played
  
                                      //Physics coeficients:
  double variationMultiplier=.75;     //how much the tail whips
  double distCoef=0;                  //responsiveness coef for when balls tend to somewhere not 0 relative to the ball in front of them
  double distBetweenCirclesXCoef=0;   //where the balls tend to in the x direction relative to the ball in front of them
  double distBetweenCirclesYCoef=0;   //where the balls tend to in the y direction relative to the ball in front of them
  double distPointsCoef=0.1;          //coeficient for tendency of balls to return to resting position
  double change=.3;                   //acceleration of the head of the worm
  double size=10;                     //diameter of the worm balls
  
  
  public WormGame(){                  //Constructor
    
    Container window = getContentPane();
  addKeyListener(this);
  addMouseListener(this);
  setSize(600,400);                       //Basic Window Attributes
  setFocusable(true);
  setTitle("Worm Game");
  setVisible(true);
  
  window.setLayout(new BorderLayout());
  label=new JLabel("Hi", JLabel.CENTER);   //Adds a label
  label.setForeground(Color.BLACK);
  window.add(label, BorderLayout.NORTH);
  
  
  classicButton=new JButton("Play Classic Game");  //declares a button for adding later
  
  window.setBackground(Color.WHITE); 
  
  timer=new Timer(20,this);              //Declars a timer and a random generator
     rand=new Random();
     
     
     
      while(i<numOfObjects+1){                   //initializes all of the BallStorages
  ball[i]=new BallStorage();
  i++;
  }
    
    i=0;
    while(i<numOfObjects){
     food[i]=new FoodStorage(rand.nextInt(500)+50,rand.nextInt(300)+50);   //initializes all of the FoodStorages    
     i++;
    }
    
    i=0;
    while(i<numOfObjects){
     enemy[i]=new EnemyStorage(rand.nextInt(500)+50,rand.nextInt(300)+50);   //initializes all of the EnemyStorages
     i++;
    }
    menuMode();            //Says the game opens to the menu
  repaint();                  //Initializes Graphics
  
  }
  
  public void menuMode(){     //Puts the game in a menu state
    gameMode=false;
    menuMode=true;
    
    add(classicButton,BorderLayout.CENTER);   //Adds a button for clicking
  }
  
  public void gameMode(){          //Puts the game in a game state
    remove(classicButton);
    gameMode=true;
    menuMode=false;
    
    timer.start();                 //starts the timer that refreshes game happenings every frame
    
    ball[1].isLeader=true;
    ball[1].setPoint(300,200);     //Initializes the head of the worm so the user begins with it
    ball[1].setSize(size,size);
    cirCount++;
    repaint();
  }
  
  public void paint(Graphics g){                        //Paint function does graphics
   super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    if(gameMode){
    if(foodCheck){
     g2d.draw(f=new Rectangle2D.Double((double)food[foodCount].x,(double)food[foodCount].y,size,size));
     g2d.fill(f);
    }
    
    if(enemyCheck){
     g2d.draw(e=new Ellipse2D.Double((double)enemy[enemyCount].x,(double)enemy[enemyCount].y,2*size,2*size));
     g2d.fill(e);
    }
    
    int k=1;
      while(k<=cirCount){
      g2d.draw(b[k]=new Ellipse2D.Double(ball[k].getX()-ball[k].getXSize()/2,ball[k].getY()-ball[k].getYSize()/2,ball[k].getXSize(),ball[k].getYSize()));
      if(k==1){
      g2d.fill(b[k]);
      }
      k++;
  }
  }
  }
  
  public void actionPerformed(ActionEvent evt){
    if(evt.getSource()==timer){
      
      physics();
      suicide();
      label.setText("Score: "+Integer.toString(score)+" Billion :  Number of balls: "+Integer.toString(cirCount));
     repaint(); 
     eat();
    }
  }
  
  
  
  public void mousePressed(MouseEvent m){
    if(gameMode){
  newFood();
  newBall();
    }
    else{
     gameMode(); 
    }
  }
  
   public void keyReleased(KeyEvent k){
    if(k.getKeyCode()==37){
      leftkeycheck=false;
      if(rightkeycheck){
       ball[1].xa=change; 
      }
      else{
     ball[1].xa=0; 
      }
    }
    if(k.getKeyCode()==39){
     rightkeycheck=false;
     if(leftkeycheck){
      ball[1].xa=-change; 
     }
     else{
       ball[1].xa=0;
     }
    }
    if(k.getKeyCode()==38){
      upkeycheck=false;
      if(downkeycheck){
     ball[1].ya=change; 
      }
      else{
      ball[1].ya=0; 
      }
    }
    if(k.getKeyCode()==40){
      downkeycheck=false;
      if(upkeycheck){
        ball[1].ya=-change;
      }
      else{
     ball[1].ya=0;
      }
    }
  }
  
  public void keyTyped(KeyEvent k){
    
  }
  
   public void keyPressed(KeyEvent k){
     if(k.getKeyCode()==37){
       leftkeycheck=true;
     ball[1].xa=-change;
   }
     if(k.getKeyCode()==38){
       upkeycheck=true;
     ball[1].ya=-change;
   }
     if(k.getKeyCode()==39){
       rightkeycheck=true;
     ball[1].xa=change;
   }
     if(k.getKeyCode()==40){
       downkeycheck=true;
     ball[1].ya=change;
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
      double x=ball[cirCount-1].x;
      double y=ball[cirCount-1].y;
    ball[cirCount].setPoint(x,y);
    ball[cirCount].setSize(size,size);
    repaint();
  } 
  }
  
  public void physics(){
     
    enemy[enemyCount].physics();
    enemy[enemyCount].move();
    
   int k=cirCount;
   while(k>1){
     
    ball[k].old11xv=ball[k].old10xv;
     ball[k].old11yv=ball[k].old10yv;
     
     ball[k].old10xv=ball[k].old9xv;
     ball[k].old10yv=ball[k].old9yv;
     
     ball[k].old9xv=ball[k].old8xv;
     ball[k].old9yv=ball[k].old8yv;
     
     ball[k].old8xv=ball[k].old7xv;
     ball[k].old8yv=ball[k].old7yv;
     
     ball[k].old7xv=ball[k].old6xv;
     ball[k].old7yv=ball[k].old6yv;
     
     ball[k].old6xv=ball[k].old5xv;
     ball[k].old6yv=ball[k].old5yv;
   
    ball[k].old5xv=ball[k].old4xv;
     ball[k].old5yv=ball[k].old4yv;
     
     ball[k].old4xv=ball[k].old3xv;
     ball[k].old4yv=ball[k].old3yv;
     
     ball[k].old3xv=ball[k].old2xv;
     ball[k].old3yv=ball[k].old2yv;
     
     ball[k].old2xv=ball[k].old1xv;
     ball[k].old2yv=ball[k].old1yv;
     
     ball[k].old1xv=ball[k].oldxv;
     ball[k].old1yv=ball[k].oldyv;
 
     
     ball[k].xv=variationMultiplier*(1+distCoef*distBetweenCirclesXCoef)*ball[k-1].old3xv+distPointsCoef*distPoints1D(ball[k].x,ball[k-1].x+(distBetweenCirclesXCoef*size));
     ball[k].yv=variationMultiplier*(1+distCoef*distBetweenCirclesYCoef)*ball[k-1].old3yv+distPointsCoef*distPoints1D(ball[k].y,ball[k-1].y+(distBetweenCirclesYCoef*size));
     ball[k].oldxv=ball[k].xv;
     ball[k].oldyv=ball[k].yv;
       ball[k].physics();
      
    k=k-1;
  }
   k=1;
     ball[k].old11xv=ball[k].old10xv;
     ball[k].old11yv=ball[k].old10yv;
     
     ball[k].old10xv=ball[k].old9xv;
     ball[k].old10yv=ball[k].old9yv;
     
     ball[k].old9xv=ball[k].old8xv;
     ball[k].old9yv=ball[k].old8yv;
     
     ball[k].old8xv=ball[k].old7xv;
     ball[k].old8yv=ball[k].old7yv;
     
     ball[k].old7xv=ball[k].old6xv;
     ball[k].old7yv=ball[k].old6yv;
     
     ball[k].old6xv=ball[k].old5xv;
     ball[k].old6yv=ball[k].old5yv;
   
    ball[k].old5xv=ball[k].old4xv;
     ball[k].old5yv=ball[k].old4yv;
     
     ball[k].old4xv=ball[k].old3xv;
     ball[k].old4yv=ball[k].old3yv;
     
     ball[k].old3xv=ball[k].old2xv;
     ball[k].old3yv=ball[k].old2yv;
     
     ball[k].old2xv=ball[k].old1xv;
     ball[k].old2yv=ball[k].old1yv;
     
     ball[k].old1xv=ball[k].oldxv;
     ball[k].old1yv=ball[k].oldyv;
     
         ball[1].physics();
 ball[k].oldxv=ball[k].xv;
     ball[k].oldyv=ball[k].yv;

    
    
    k=1;
    while(k<=cirCount){
     ball[k].move();
     k++;
    }
    
  }
  
  public void suicide(){
   
    int k=3;
    while(k<=cirCount){
    if(ball[1].intersects2(ball[2])==false && ball[1].intersects(ball[k])){
     cirCount=k;
     repaint();
    }
    k++;
    }
  }
  
  public void eat(){
    if(b[1].intersects(food[foodCount].x,food[foodCount].y,size,size)){
     score=score+foodScore*cirCount;
     newFood(); 
     newBall();
     repaint();
    }
     if(b[1].intersects(enemy[enemyCount].x,enemy[enemyCount].y,2*size,2*size)){
     score=score+enemyScore*cirCount;
     newEnemy();
     repaint();
    } 
    int k=2;
    while(k<=cirCount){
    
      if(ball[k].intersects(enemy[enemyCount])){
        cirCount=k-1;
        repaint();
      }
    k++;
    }
  }
  
 
  
  public void newFood(){
   if(foodCount<numOfObjects-1){
      foodCount++;
      repaint();
    } 
   else{
    foodCheck=false; 
   }
  }
  
  public void newEnemy(){
   if(enemyCount<numOfObjects-1){
      enemyCount++;
      repaint();
    } 
   else{
    enemyCheck=false; 
   }
  }
  
  public double distPoints(double x1,double y1,double x2, double y2){
   return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)); 
  }
  
  public double distPoints1D(double x1,double x2){
   return x2-x1; 
  }
  
  public static void main(String[] args){
   new WormGame(); 
  }
  
  
}