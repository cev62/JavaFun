 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class BaseCalc extends JFrame implements ActionListener, KeyListener, MouseListener{
  

  JLabel label1;
  JLabel label2;
  JLabel label3;
  JLabel label4;
  
  JTextField field1;
  JTextField field2;
  JTextField field3;
  JTextField field4;
  
  JButton button1;
  JButton button2;
  JButton button3;
  JButton button4;
  
  public BaseCalc(){
  
  Container window = getContentPane();
  window.setLayout(new GridLayout(4,2));
  
  label1= new JLabel("Decimal",JLabel.CENTER);
  window.add(label1);
  field1 = new JTextField();
  window.add(field1);
  button1 = new JButton("Convert!");
  button1.addActionListener(this);
  window.add(button1);
  
  label2= new JLabel("Binary",JLabel.CENTER);
  window.add(label2);
  field2 = new JTextField();
  window.add(field2);
  button2 = new JButton("Convert!");
  button2.addActionListener(this);
  window.add(button2);
  
  label3= new JLabel("Hexidecimal",JLabel.CENTER);
  window.add(label3);
  field3 = new JTextField();
  window.add(field3);
  button3 = new JButton("Convert!");
  button3.addActionListener(this);
  window.add(button3);
  
  label4= new JLabel("Octal",JLabel.CENTER);
  window.add(label4);
  field4 = new JTextField();
  window.add(field4);
  button4 = new JButton("Convert!");
  button4.addActionListener(this);
  window.add(button4);
  
  addKeyListener(this);
  addMouseListener(this);
  setSize(300,150);
  setFocusable(true);
  setTitle("BaseCalc");
  setVisible(true);
  
  }
  
  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
  }
  
  public void actionPerformed(ActionEvent evt){

    if(evt.getSource() == button1){
      computeDecimal(field1.getText());
    }
    
    if(evt.getSource() == button2){
      computeBinary(field1.getText());
    }
    
    if(evt.getSource() == button3){
      computeHexadecimal(field1.getText());
    }
    
    if(evt.getSource() == button4){
      computeOctal(field1.getText());
    }
    
  }
  
  public void computeDecimal(String in){
    
    char[] input = in.toCharArray();
    
    int out = 0;
    
    int value = 0;
    int place = 0;
    
    for(int i = input.length-1;i>=0;i--){
     
      value += Math.pow(10,place)*(Integer.parseInt(Character.toString(input[i])));
      place++;
      
    }
    
    label1.setText(Integer.toString(value));
    
    place = 0;
    
    while( Math.pow(2,place) <= value ){
     place++; 
    }
    
    label1.setText(Integer.toString(value));
    label2.setText(Integer.toString(place));
    
    for(int i = place;i < place; i++){
      
      if( Math.pow( 2,place ) >= value ){
       
        value -= Math.pow( 2,place );
        out += Math.pow( 10,place );
        
      }
      
    }
    
    field2.setText(Integer.toString(out));
    
    
    
    
    //field2.setText(Character.toString(input[input.length-1]));
    
  }
  
  public void computeBinary(String in){
    
    
    
  }
  
  public void computeHexadecimal(String in){
    
    
    
  }
  
  public void computeOctal(String in){
    
    
    
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
   new BaseCalc(); 
  }
  
}