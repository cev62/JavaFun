import java.util.*;

public class PrimeFinder{
  static int istrue=0;
 static int checker(int a,int b){
   int check=a % b;
   return check;
  }
  
  public static void main(String[] args){
    
    for(int test=2; test<10000; test++){
    int istrue=1;
      for(int sqtest=test-1; sqtest>1; sqtest--){
       
        
        if(checker(test, sqtest) == 0){
        istrue=0;
          break; 
        }
        

        
      }
      if (istrue==0){}
      else{System.out.println(test);}
      
    }
  }
  
}