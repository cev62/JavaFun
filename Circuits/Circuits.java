 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Circuits extends JFrame implements ActionListener, KeyListener, MouseListener{
  
  JLabel labelTopLeft;
  JLabel labelTopRight;
  
  JPanel buttonPanel;
  JRadioButton seriesChoice;
  JRadioButton paralellChoice;
  
  JLabel labelBattery;
  JTextField fieldBattery;
  
  JPanel panelBattery;
  JPanel panel1;
  JPanel panel2;
  JPanel panel3;
  JPanel panel4;
  
  JLabel label1;
  JLabel label2;
  JLabel label3;
  JLabel label4;
  
  JTextField field1;
  JTextField field2;
  JTextField field3;
  JTextField field4;
  
  public Circuits(){
  
  Container window = getContentPane();
  window.setLayout(new GridLayout(2,4));
  
  labelTopLeft= new JLabel("TopLeft",JLabel.CENTER);
  window.add(labelTopLeft);
  labelTopRight= new JLabel("TopRight",JLabel.CENTER);
  window.add(labelTopRight);
  
  
  
  buttonPanel = new JPanel();
  buttonPanel.setLayout(new GridLayout(2,1));
  seriesChoice = new JRadioButton();
  paralellChoice = new JRadioButton();
  buttonPanel.add(seriesChoice);
  buttonPanel.add(paralellChoice);
  window.add(buttonPanel);
  
  panelBattery = new JPanel();
  panelBattery.setLayout(new GridLayout(2,1));
  labelBattery = new JLabel("Battery");
  fieldBattery = new JTextField();
  panelBattery.add(labelBattery);
  panelBattery.add(fieldBattery);
  window.add(panelBattery);
  
  panel1 = new JPanel();
  panel1.setLayout(new GridLayout(2,1));
  label1 = new JLabel("1");
  field1 = new JTextField();  
  panel1.add(field1);
  panel1.add(label1);
  window.add(panel1);  
  
  panel2 = new JPanel();  
  panel2.setLayout(new GridLayout(2,1));
  label2 = new JLabel("2");
  field2 = new JTextField();
  panel2.add(field2);
  panel2.add(label2);
  window.add(panel2);  
  
  panel3 = new JPanel();
  panel3.setLayout(new GridLayout(2,1));
  label3 = new JLabel("3");
  field3 = new JTextField();
  panel3.add(field3);
  panel3.add(label3);
  window.add(panel3);  
  
  panel4 = new JPanel();  
  panel4.setLayout(new GridLayout(2,1));
  label4 = new JLabel("4");
  field4 = new JTextField();
  panel4.add(field4);  
  panel4.add(label4);
  window.add(panel4);
  
  addKeyListener(this);
  addMouseListener(this);
  setSize(1000,600);
  setFocusable(true);
  setTitle("Circuits");
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
   new Circuits(); 
  }
  
}