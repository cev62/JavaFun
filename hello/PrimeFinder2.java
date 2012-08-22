import java.util.*;
import java.lang.Math.*;

class Primes{
int[] d=new int[10000];
}

public class PrimeFinder2{
  static int times=0;
  static int istrue=0;
  static int i=0;
  static int j=0;
  static int testprime;
  
  static int squareroot2(double x){
    double a=1;
    double b=1;
    double c,d,e,f,g,h,dif;
    double difference=1;
    double bstart=1;
    while (difference>0.001){
    bstart=b;  
    c=b*b;
    d=c-x;
    e=2*b;
    f=d/e;
    a=b-f;
    b=a;
    dif=bstart-b;
    difference= Math.abs(dif);  
    }
  int answer=(int)b;
  return answer;
  }
  
  static int squareroot(double x){
    double a=Math.sqrt(x);
    return (int)a;
  }
  
  
 static int checker(int a,int b){
   int check=a % b;
   return check;
  }
 
 

  public static void main(String[] args){
    System.out.println("2");
    Primes data= new Primes();
    data.d[0]=2;
    for(int test=3; test<10000; test++){
    int istrue=1;
    i=0;
    int sqtest=squareroot(test);
      while(true){
       
        //j=times+i;
        testprime= data.d[i];
        if(checker(test, testprime) == 0){
        istrue=0;
          break; 
        }
        if(testprime>=sqtest){
          istrue=1;
          break;
        }

        i++;
      }
      if (istrue==0){}
      else if(istrue==1){
        times++;
        data.d[times]=test;
        System.out.println(data.d[times]);
        
      
      }
      else{}
    }
  }
  
}