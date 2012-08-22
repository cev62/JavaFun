import java.lang.Math;
import java.io.*;
import java.util.Calendar;

public class PrimeWriter{
  
  int cPrime = 0;
  int nPrime;
  int lim = 500000000;
  int i;
  int oldSqrt = 1;
  int k = 0;
  boolean isPrime;
  boolean good = true;
  
  int[] pd = new int[2*lim/(int)Math.log(lim)];

  public PrimeWriter(){
      //System.out.println(""+pd.length);
  }
  
  public int nextPrime(){
   
    nPrime = cPrime;
    
    while(nPrime <= lim-1){
     
      nPrime++;
      
      isPrime = true;
      i = 1;
      
      if((oldSqrt+1)*(oldSqrt+1) < nPrime){
      oldSqrt++;
      }
      
      while( i<k && oldSqrt>=pd[i] ){
       
        if( nPrime % pd[i] == 0 ){
          isPrime = false;
          break;
        }
        i++;
        
      }
      
      if(isPrime == true){
        cPrime = nPrime;
        pd[k] = nPrime;
        //System.out.println( k );
        k++;
        return nPrime;
      }
      
    }
    
    return 0;
    
  }
  
  public static void main(String[] args){
    
    Calendar cal = Calendar.getInstance();
    long start = cal.getTimeInMillis();
    
    PrimeWriter primeWriter = new PrimeWriter();
    
    while(primeWriter.good){
      
      int temp = primeWriter.nextPrime();
      
      if(temp == 0){
       primeWriter.good = false; 
      }
      else{
    //System.out.println(""+temp );
      
      }
    }
    
    cal = Calendar.getInstance();
    long end = cal.getTimeInMillis();
    
    System.out.println( "Computation took " + (end-start) + " milli-seconds to find all prime numbers up to " + primeWriter.lim+ "which is "+ (primeWriter.k-1) +" prime numbers");
    System.out.println("" + primeWriter.pd[primeWriter.k-1]);
  }
  
}