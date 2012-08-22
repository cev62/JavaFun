//Author: Aaron Maharry
//9.26.11
//Basic Calculator App

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorApp extends JFrame
  implements ActionListener

{
  
 JLabel label;
 JTextField field;  
 JButton button1;
 JButton button2;
 JButton button3;
 JButton button4;
 JButton button5;
 JButton button6;
 JButton button7;
 JButton button8;
 JButton button9;
 JButton button0;
 JButton buttonDec;
 JButton buttonEquals;
 JButton buttonAdd;
 JButton buttonSub;
 JButton buttonMult;
 JButton buttonDiv;
 JButton buttonClear;

 
 double input1=0;
 double input2=0;
 boolean add=false;
 boolean subtract=false;
 boolean multiply=false;
 boolean divide=false;
 boolean deccheck=false;
 boolean deccomplete=true;
 boolean equalscheck=false;
 boolean error=false;
 
 public CalculatorApp(){
  

  label=new JLabel("", JLabel.CENTER);
  field= new JTextField("");
  button1= new JButton("1");
  button2= new JButton("2");
  button3= new JButton("3");
  button4= new JButton("4");
  button5= new JButton("5");
  button6= new JButton("6");
  button7= new JButton("7");
  button8= new JButton("8");
  button9= new JButton("9");
  button0= new JButton("0");
  buttonDec= new JButton(".");
  buttonEquals= new JButton("=");
  buttonAdd= new JButton("+");
  buttonSub= new JButton("-");
  buttonMult= new JButton("*");
  buttonDiv= new JButton("/");
  buttonClear= new JButton("Cl");
  
  button1.addActionListener(this);
  button2.addActionListener(this);
  button3.addActionListener(this);
  button4.addActionListener(this);
  button5.addActionListener(this);
  button6.addActionListener(this);
  button7.addActionListener(this);
  button8.addActionListener(this);
  button9.addActionListener(this);
  button0.addActionListener(this);
  buttonDec.addActionListener(this);
  buttonEquals.addActionListener(this);
  buttonAdd.addActionListener(this);
  buttonSub.addActionListener(this);
  buttonMult.addActionListener(this);
  buttonDiv.addActionListener(this);
  buttonClear.addActionListener(this);
  
  JPanel numpad= new JPanel(new GridLayout(4,3,5,5));
  numpad.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
  numpad.add(button7);
  numpad.add(button8);
  numpad.add(button9);
  numpad.add(button4);
  numpad.add(button5);
  numpad.add(button6);
  numpad.add(button1);
  numpad.add(button2);
  numpad.add(button3);
  numpad.add(buttonDec);
  numpad.add(button0);
  numpad.add(buttonClear);
  
  JPanel operations= new JPanel(new GridLayout(4,1,5,5));
  operations.setBorder(BorderFactory.createEmptyBorder(0,0,0,5));
  operations.add(buttonAdd);
  operations.add(buttonSub);
  operations.add(buttonMult);
  operations.add(buttonDiv);
  
  JPanel lower=new JPanel(new GridLayout(1,2));
    lower.add(label);
    lower.add(buttonEquals);
  
  //field.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
  field.setEditable(false);
  
  Container window=getContentPane();
  
  window.setLayout(new BorderLayout(5,5));
  
  
  window.add(field, BorderLayout.NORTH);
  window.add(numpad, BorderLayout.CENTER);
  window.remove(numpad);
  window.add(operations, BorderLayout.EAST);
  window.add(lower, BorderLayout.SOUTH);
  
  setSize(220,200);
  setTitle("Calculator");
  setVisible(true);
 }
  
 public void writeNum(int num){
   if(equalscheck==true){
     input2=input1;
     ClearField();
   }
  String currentText= field.getText();
  String newText= Integer.toString(num);
  newText= currentText + newText;
  field.setText(newText);
  deccomplete=true;
  input1=Double.parseDouble(newText);
  if(error==true){
  label.setText(Double.toString(input2));
  error=false;
  }
 }
 
 public void ClearField(){
  String clearText="";
  field.setText(clearText);
  deccheck=false;
  equalscheck=false;
  deccomplete=true;
  error=false;
  input1=0;
  label.setText(Double.toString(input2));
 }
 
 public void writeDec(){
   if(deccheck==false){
     if(equalscheck==true){
      input2=input1;
       ClearField(); 
     }
   deccomplete=false;
     String currentText= field.getText();
  String newText= ".";
  newText= currentText + newText;
  field.setText(newText);
  deccheck=true;
   }
   else if (deccheck==true){
     error=true;
    label.setText("Multiple Dec."); 
   }
   else{}
 }
 
 public void Add(){
   if(deccomplete==false){
     error=true;
   label.setText("Unfinnished Dec.");
   }
   else{
   add=true;
   subtract=false;
   multiply=false;
   divide=false;
   equalscheck=false;
   input2=input1;
   label.setText(Double.toString(input2) + " +");
   ClearField();
   }
 }
 
 public void Subtract(){
   if(deccomplete==false){
     error=true;
   label.setText("Unfinnished Dec.");
   }
   else{
   add=false;
   subtract=true;
   multiply=false;
   divide=false;
   equalscheck=false;
   input2=input1;
   label.setText(Double.toString(input2) + " -");
   ClearField();
   }
 }
 
 public void Multiply(){
   if(deccomplete==false){
     error=true;
   label.setText("Unfinnished Dec.");
   }
   else{
   add=false;
   subtract=false;
   multiply=true;
   divide=false;
   equalscheck=false;
   input2=input1;
   label.setText(Double.toString(input2) + " *");
   ClearField();
   } 
 }
 
 public void Divide(){
   if(deccomplete==false){
     error=true;
   label.setText("Unfinnished Dec.");
   }
   else{
   add=false;
   subtract=false;
   multiply=false;
   divide=true;
   equalscheck=false;
   input2=input1;
   label.setText(Double.toString(input2) + " /");
   ClearField();
   }
 }
 
 public void Equals(){
   if(deccomplete==false){
     error=true;
   label.setText("Unfinnished Dec.");
   }
   else{
   
     equalscheck=true;
     
     if(add==true){
       input1=input2+input1;
       field.setText(Double.toString(input1));
       add=false;
       input2=input1;
       label.setText(Double.toString(input2));
     }
     else if(subtract==true){
       input1=input2-input1;
       field.setText(Double.toString(input1));
       subtract=false;
       input2=input1;
       label.setText(Double.toString(input2));
     }
     else if(multiply==true){
       input1=input2*input1;
       field.setText(Double.toString(input1));
       multiply=false;
       input2=input1;
       label.setText(Double.toString(input2));
     }
     else if(divide==true){
       if(input1==0){
         error=true;
       label.setText("Error: /0");
       }
       else{
       input1=input2/input1;
       field.setText(Double.toString(input1));
       divide=false;
       input2=input1;
       label.setText(Double.toString(input2));
       }
       }
     
     
   }
 }
 
 public void actionPerformed(ActionEvent evt){
   
   
   
   if(evt.getSource()==button1){
       writeNum(1);
   }    
   else if(evt.getSource()==button2){
       writeNum(2);
   }
    else if(evt.getSource()==button3){
       writeNum(3);
   }
    else if(evt.getSource()==button4){
       writeNum(4);
   }
    else if(evt.getSource()==button5){
       writeNum(5);
   }
    else if(evt.getSource()==button6){
       writeNum(6);
   }
    else if(evt.getSource()==button7){
       writeNum(7);
   }
    else if(evt.getSource()==button8){
       writeNum(8);
   }
    else if(evt.getSource()==button9){
       writeNum(9);
   }
    else if(evt.getSource()==button0){
       writeNum(0);
   }
    else if(evt.getSource()==buttonDec){
       writeDec();
   }
    else if(evt.getSource()==buttonEquals){
       Equals();
   }
    else if(evt.getSource()==buttonClear){
       ClearField();
   }
    else if(evt.getSource()==buttonAdd){
       Add();
   }
    else if(evt.getSource()==buttonSub){
       Subtract();
   }
    else if(evt.getSource()==buttonMult){
       Multiply();
   }
    else if(evt.getSource()==buttonDiv){
       Divide();
   }
    else{}
   
 }
 
 public static void main(String[] args){
  new CalculatorApp(); 
 }
 
}