import java.util.Calendar;

public class Papa{
  

  public Papa(){
    
    
    
  }

  int div(int a,int b){
    
    int result = -1;
    boolean antiSign = ((!isPositive(a) && isPositive(b)) || (isPositive(a) && !isPositive(b)));
    
    a = abs(a);
    b = abs(b);
    
    while(isPositive(a)){
     
      a = a-b;
      result++;
      
    }
    
    if(antiSign){
      result = -result;
    }
    
    return result;
    
  }
  
  boolean isPositive(int in){
    return (in>=0);
  }
  
  int abs(int in){
    if(in>=0){return in;}
    else{return -in;}
  }

  public static void main(String[] args){
   
    Papa papa = new Papa();
    
    Calendar cal = Calendar.getInstance();
    long start = cal.getTimeInMillis();
    
    int output = papa.div(700,80);
    
    cal = Calendar.getInstance();
    long end = cal.getTimeInMillis();
    
    System.out.println(""+output+"\nTime: "+(end-start));
    
  }

}




