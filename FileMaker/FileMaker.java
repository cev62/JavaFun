 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class FileMaker extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  JTextField text;
  JButton button;
  
  public FileMaker(){
  
  Container window = getContentPane();
  window.setLayout(new GridLayout(2,1));
  text= new JLabel("Enter Text Here:",JLabel.CENTER);
  button=new JButton("");
  window.add(text);
  
  
  addKeyListener(this);
  addMouseListener(this);
  setSize(400,400);
  setFocusable(true);
  setTitle("FileMaker");
  setVisible(true);
  
  }
  
  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
  }
  
  public void actionPerformed(ActionEvent evt){
  
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
    
  }
  
  public void keyReleased(KeyEvent key){
      
  }
  
  public void keyTyped(KeyEvent key){
      
  }
  
  public static void main(String[] args){
   new FileMaker(); 
  }
  
}