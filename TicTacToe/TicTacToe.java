import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe extends JFrame
  implements ActionListener
{
  
  JButton button1;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton button5;
  JButton button6;
  JButton button7;
  JButton button8;
  JButton button9;
  JLabel label;
  JButton buttonr;
  JPanel panel;
  Random rand;
  TicTacToeAI computer;
  Timer timer;
  
  boolean playerturn=false;
  boolean over=false;
  boolean playable=true;
  boolean cwin=false;
  boolean pwin=false;
  int computermove=0;
  
  int b1=0;
  int b2=0;
  int b3=0;
  int b4=0;
  int b5=0;
  int b6=0;
  int b7=0;
  int b8=0;
  int b9=0;
  
  
  
  public TicTacToe(){
  
  button1=new JButton();
  button2=new JButton();
  button3=new JButton();
  button4=new JButton();
  button5=new JButton();
  button6=new JButton();
  button7=new JButton();
  button8=new JButton();
  button9=new JButton();
  buttonr=new JButton();
  label=new JLabel(" ");
  panel=new JPanel(new GridLayout(3,3,5,5));
  computer=new TicTacToeAI();
  timer=new Timer(500,this);
  
  
  button1.addActionListener(this);
  button2.addActionListener(this);
  button3.addActionListener(this);
  button4.addActionListener(this);
  button5.addActionListener(this);
  button6.addActionListener(this);
  button7.addActionListener(this);
  button8.addActionListener(this);
  button9.addActionListener(this);
  buttonr.addActionListener(this);
  
  panel.add(button1);
  panel.add(button2);
  panel.add(button3);
  panel.add(button4);
  panel.add(button5);
  panel.add(button6);
  panel.add(button7);
  panel.add(button8);
  panel.add(button9);
  
  Container window=getContentPane();
  window.setLayout(new BorderLayout(5,5));
  window.add(label,BorderLayout.NORTH);
  window.add(panel,BorderLayout.CENTER);
  window.add(buttonr,BorderLayout.SOUTH);
  
  buttonr.setLabel("Reset");
  
  setSize(200,200);
  setTitle("Tic-Tac-Toe");
  setVisible(true);
  
  rand=new Random();
  if(rand.nextInt(2)==1){
    playerturn=false;
    computerTurn();
    //buttonr.setLabel("comp");
  }
  else{
    playerturn=true;
    label.setText("Player's Turn");
    //buttonr.setLabel("player");
  }
  
       
  
  
  
  }
  
  public void computerTurn(){
    isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
    if(playable){
    
    computermove=computer.nextMove(b1,b2,b3,b4,b5,b6,b7,b8,b9);
            
            if(computermove==1){
             button1.setLabel("O");
             playerturn=true;
             b1=2;
            }
            else if(computermove==2){
              button2.setLabel("O");
             playerturn=true;
             b2=2;
            }
            else if(computermove==3){
              button3.setLabel("O");
             playerturn=true;
             b3=2;
            }
            else if(computermove==4){
              button4.setLabel("O");
             playerturn=true;
             b4=2;
            }
            else if(computermove==5){
              button5.setLabel("O");
             playerturn=true;
             b5=2;
            }
            else if(computermove==6){
              button6.setLabel("O");
             playerturn=true;
             b6=2;
            }
            else if(computermove==7){
              button7.setLabel("O");
             playerturn=true;
             b7=2;
            }
            else if(computermove==8){
              button8.setLabel("O");
             playerturn=true;
             b8=2;
            }
            else if(computermove==9){
              button9.setLabel("O");
             playerturn=true;
             b9=2;
            }
            
            isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
            
    }
  }
  
  public void reset(){
            
     over=false;
     cwin=false;
     pwin=false;
     playable=true;
     timer.stop();
  
  b1=0;
  b2=0;
  b3=0;
  b4=0;
  b5=0;
  b6=0;
  b7=0;
  b8=0;
  b9=0;
  
   button1.setLabel("");
   button2.setLabel("");
   button3.setLabel("");
   button4.setLabel("");
   button5.setLabel("");
   button6.setLabel("");
   button7.setLabel("");
   button8.setLabel("");
   button9.setLabel("");
   
   if(rand.nextInt(2)==1){
    playerturn=false;
    computerTurn();
  }
  else{
    playerturn=true;
  }
   
  }
  
  public void isOver(int b1,int b2,int b3,int b4,int b5,int b6,int b7,int b8,int b9){
   
    if(playerWins(b1,b2,b3,b4,b5,b6,b7,b8,b9)){
      label.setText("Player Wins!");
      playable=false;
    }
    else if(computerWins(b1,b2,b3,b4,b5,b6,b7,b8,b9)){
      label.setText("Computer Wins!");
      playable=false;
    }
    else if(b1!=0){
     if(b2!=0){
      if(b3!=0){
        if(b4!=0){
          if(b5!=0){
            if(b6!=0){
              if(b7!=0){
                if(b8!=0){
                  if(b9!=0){
                    label.setText("Cat's Game!");
                    playable=false;
                  }
                }
              }
            }
          }
        }
      }
     }
    }
      
    
    
      
  }
  
  public boolean playerWins(int b1,int b2,int b3,int b4,int b5,int b6,int b7,int b8,int b9){
    pwin=false;
    if(b1==1 && b2==1 && b3==1){pwin=true;}
    if(b1==1 && b5==1 && b9==1){pwin=true;}
    if(b1==1 && b4==1 && b7==1){pwin=true;}
    if(b2==1 && b5==1 && b8==1){pwin=true;}
    if(b3==1 && b5==1 && b7==1){pwin=true;}
    if(b3==1 && b6==1 && b9==1){pwin=true;}
    if(b4==1 && b5==1 && b6==1){pwin=true;}
    if(b7==1 && b8==1 && b9==1){pwin=true;}
    return pwin;
  }
  
  public boolean computerWins(int b1,int b2,int b3,int b4,int b5,int b6,int b7,int b8,int b9){
    cwin=false;
    if(b1==2 && b2==2 && b3==2){cwin=true;}
    if(b1==2 && b5==2 && b9==2){cwin=true;}
    if(b1==2 && b4==2 && b7==2){cwin=true;}
    if(b2==2 && b5==2 && b8==2){cwin=true;}
    if(b3==2 && b5==2 && b7==2){cwin=true;}
    if(b3==2 && b6==2 && b9==2){cwin=true;}
    if(b4==2 && b5==2 && b6==2){cwin=true;}
    if(b7==2 && b8==2 && b9==2){cwin=true;}
    return cwin;
  }
  
  
  
  public void actionPerformed(ActionEvent evt){
    if(playable){
      
    
      if(evt.getSource()==timer){
       timer.stop();
       computerTurn();
      }
      
      
      if(playerturn){
    if(evt.getSource()==button1){
      if(b1==0){
        button1.setLabel("X");
        playerturn=false;
        b1=1;
        isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
        
      }
    }
    else if(evt.getSource()==button2){
      if(b2==0){
       button2.setLabel("X");
       playerturn=false;
       b2=1;
       isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button3){
      if(b3==0){
       button3.setLabel("X");
       playerturn=false;
       b3=1;
       isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button4){
      if(b4==0){
       button4.setLabel("X");
       playerturn=false;
       b4=1;
      isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button5){
      if(b5==0){
       button5.setLabel("X");
       playerturn=false;
       b5=1;
      isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button6){
      if(b6==0){
       button6.setLabel("X");
       playerturn=false;
       b6=1;
       isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button7){
      if(b7==0){
       button7.setLabel("X");
       playerturn=false;
       b7=1;
      isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button8){
      if(b8==0){
       button8.setLabel("X");
       playerturn=false;
       b8=1;
       isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    else if(evt.getSource()==button9){
      if(b9==0){
       button9.setLabel("X");
       playerturn=false;
       b9=1;
       isOver(b1,b2,b3,b4,b5,b6,b7,b8,b9);
        timer.start();
      }
    }
    }
    }
    if(evt.getSource()==buttonr){
      if(pwin || cwin){
      label.setText(" ");
      }
      else{
      label.setText("Cat's Game!");
      }
      reset(); 
    }
    
    
  }
  
  public static void main(String[] args){
   new TicTacToe(); 
  }
  
  
}