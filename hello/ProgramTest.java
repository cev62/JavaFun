import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProgramTest extends JFrame
  implements ActionListener

{
 JTextField field; 
 JLabel label; 
 JButton button;
 
 public ProgramTest(){
  
  label=new JLabel("Hellos"); 
  field= new JTextField("It worked");
  button= new JButton("Compute");
  
  button.addActionListener(this);
  
  Container window=getContentPane();
  
  window.setLayout(new GridLayout(3,1,10,10));
  
  window.add(label);
  window.add(field);
  window.add(button);
  
  setSize(200,150);
  setTitle("Program Tester");
  setVisible(true);
 }
  
 public void actionPerformed(ActionEvent evt){
   label.setText("Woohoo!");
 }
 
 public static void main(String[] args){
  new ProgramTest(); 
 }
 
}