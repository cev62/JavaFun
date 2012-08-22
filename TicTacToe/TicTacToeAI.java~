import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToeAI{
  
  Random randai;
  
  boolean b1check=false;
  boolean b2check=false;
  boolean b3check=false;
  boolean b4check=false;
  boolean b5check=false;
  boolean b6check=false;
  boolean b7check=false;
  boolean b8check=false;
  boolean b9check=false;
  int move;
  
  public TicTacToeAI(){
    randai=new Random();
  }
  
  
  public int nextMove(int b1,int b2,int b3,int b4,int b5,int b6,int b7,int b8,int b9){
    
    if(b1==0){b1check=true;}
    else{b1check=false;}
    
    if(b2==0){b2check=true;}
    else{b2check=false;}
    
    if(b3==0){b3check=true;}
    else{b3check=false;}
    
    if(b4==0){b4check=true;}
    else{b4check=false;}
    
    if(b5==0){b5check=true;}
    else{b5check=false;}
    
    if(b6==0){b6check=true;}
    else{b6check=false;}
    
    if(b7==0){b7check=true;}
    else{b7check=false;}
    
    if(b8==0){b8check=true;}
    else{b8check=false;}
    
    if(b9==0){b9check=true;}
    else{b9check=false;}
    
    move=0;
    
    //This checks to see if the AI can win on this turn
    if(b1==2){
      if(b2==2 && b3==0){move=3;}
      if(b3==2 && b2==0){move=2;}
      if(b4==2 && b7==0){move=7;}
      if(b7==2 && b4==0){move=4;}
      if(b5==2 && b9==0){move=9;}
      if(b9==2 && b5==0){move=5;}
    }
    if(b2==2){
      if(b1==2 && b3==0){move=3;}
      if(b3==2 && b1==0){move=1;}
      if(b5==2 && b8==0){move=8;}
      if(b8==2 && b5==0){move=5;}
    }
    if(b3==2){
      if(b2==2 && b1==0){move=1;}
      if(b1==2 && b2==0){move=2;}
      if(b6==2 && b9==0){move=9;}
      if(b9==2 && b6==0){move=6;}
      if(b5==2 && b7==0){move=7;}
      if(b7==2 && b5==0){move=5;}
    }
    if(b4==2){
      if(b1==2 && b7==0){move=7;}
      if(b7==2 && b1==0){move=1;}
      if(b5==2 && b6==0){move=6;}
      if(b6==2 && b5==0){move=5;}
    }
    if(b6==2){
      if(b3==2 && b9==0){move=9;}
      if(b9==2 && b3==0){move=3;}
      if(b4==2 && b5==0){move=5;}
      if(b5==2 && b4==0){move=4;}
    }
    if(b7==2){
      if(b8==2 && b9==0){move=9;}
      if(b9==2 && b8==0){move=2;}
      if(b4==2 && b1==0){move=1;}
      if(b1==2 && b4==0){move=4;}
      if(b5==2 && b3==0){move=3;}
      if(b3==2 && b5==0){move=5;}
    }
    if(b8==2){
      if(b7==2 && b9==0){move=9;}
      if(b9==2 && b7==0){move=7;}
      if(b5==2 && b2==0){move=2;}
      if(b2==2 && b5==0){move=5;}
    }
    if(b9==2){
      if(b7==2 && b8==0){move=8;}
      if(b8==2 && b7==0){move=7;}
      if(b6==2 && b3==0){move=3;}
      if(b3==2 && b6==0){move=6;}
      if(b5==2 && b1==0){move=1;}
      if(b1==2 && b5==0){move=5;}
    }
    
    //If one of the above situations was possible, 
    //this exits the function and calls a winning move
    if(move!=0){
     return move; 
    }
    
    //Next priority is to block a player's winning move
    if(b1==1){
      if(b2==1 && b3==0){move=3;}
      if(b3==1 && b2==0){move=2;}
      if(b4==1 && b7==0){move=7;}
      if(b7==1 && b4==0){move=4;}
      if(b5==1 && b9==0){move=9;}
      if(b9==1 && b5==0){move=5;}
    }
    if(b2==1){
      if(b1==1 && b3==0){move=3;}
      if(b3==1 && b1==0){move=1;}
      if(b5==1 && b8==0){move=8;}
      if(b8==1 && b5==0){move=5;}
    }
    if(b3==1){
      if(b2==1 && b1==0){move=1;}
      if(b1==1 && b2==0){move=2;}
      if(b6==1 && b9==0){move=9;}
      if(b9==1 && b6==0){move=6;}
      if(b5==1 && b7==0){move=7;}
      if(b7==1 && b5==0){move=5;}
    }
    if(b4==1){
      if(b1==1 && b7==0){move=7;}
      if(b7==1 && b1==0){move=1;}
      if(b5==1 && b6==0){move=6;}
      if(b6==1 && b5==0){move=5;}
    }
    if(b6==1){
      if(b3==1 && b9==0){move=9;}
      if(b9==1 && b3==0){move=3;}
      if(b4==1 && b5==0){move=5;}
      if(b5==1 && b4==0){move=4;}
    }
    if(b7==1){
      if(b8==1 && b9==0){move=9;}
      if(b9==1 && b8==0){move=2;}
      if(b4==1 && b1==0){move=1;}
      if(b1==1 && b4==0){move=4;}
      if(b5==1 && b3==0){move=3;}
      if(b3==1 && b5==0){move=5;}
    }
    if(b8==1){
      if(b7==1 && b9==0){move=9;}
      if(b9==1 && b7==0){move=7;}
      if(b5==1 && b2==0){move=2;}
      if(b2==1 && b5==0){move=5;}
    }
    if(b9==1){
      if(b7==1 && b8==0){move=8;}
      if(b8==1 && b7==0){move=7;}
      if(b6==1 && b3==0){move=3;}
      if(b3==1 && b6==0){move=6;}
      if(b5==1 && b1==0){move=1;}
      if(b1==1 && b5==0){move=5;}
    }
    
    //If one of the above situations was possible, 
    //this exits the function and blocks the player's winning move
    if(move!=0){
     return move; 
    }
    
    
    //This loop randomizes the AI's pick from the available slots
    while(true){
     move=randai.nextInt(15);
     //move++;
     
     if(move==1){
       if(b1check){
        return move;
       }
     }
     
     if(move==2){
       if(b2check){
        return move; 
       }
     }
     
     if(move==3){
       if(b3check){
        return move; 
       }
     }
     
     if(move==4){
       if(b4check){
        return move;
       }
     }
     
     if(move==5){
       if(b5check){
        return move; 
       }
     }
     
     if(move==6){
       if(b6check){
        return move; 
       }
     }
     
     if(move==7){
       if(b7check){
        return move; 
       }
     }
     
     if(move==8){
       if(b8check){
        return move; 
       }
     }
     
     if(move==9){
       if(b9check){
        return move; 
       }
     }
     
     
    }
    
    
    
    
    
    
  }
  
}