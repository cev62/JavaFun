// WhileLoop.java
// Author: Aaorn P Maharry
//
// Executes a While loop using recursive functions and if statements


public class WhileLoop{
  
  double start=1;               //The initial value of the variable in the While Loop's
                             //conditional statement
  
  public WhileLoop(){
    loop(start);  
  }
  
  
  public void loop(double n){      //Function that performs the loop
    
    if(n<=10){           // (condition editable) If this is false, the loop finishes
      
      
      
      System.out.println(n);       //Put the code within the loop here
      n=n+.0625;                       
      
      
      loop(n);                    //Calls the function recursively to repeat the loop
                                  //This won't be called if the condition above is false
      
    }
    
  }
  
  public static void main(String[] args){
   new WhileLoop();                         //Initializes class
  }
  
}
