 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Template extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  JLabel label;
  
  public Template(){
  
  Container window = getContentPane();
  window.setLayout(new GridLayout(1,1));
  label= new JLabel("Hello",JLabel.CENTER);
  window.add(label);
  
  
  addKeyListener(this);
  addMouseListener(this);
  setSize(1000,600);
  setFocusable(true);
  setTitle("Template");
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
   new Template(); 
  }
  
}