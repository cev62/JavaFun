import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.Math;
import java.io.*;

public class PiFinder{
  
  double pi;
  BigDecimal pix;
  int times;
  
  public PiFinder(){
    
    
  }
  
  public void setTimes( int ntimes ){
   
    times = ntimes;
    
  }
  
  public void computex(){
   
    pix = new BigDecimal(0);
    
    int k = 0;
    while(k<=times-1){
      
      double temp = Math.pow(3,k);
      
      BigDecimal div = new BigDecimal( 4 );
      BigDecimal div2 = BigDecimal.valueOf( 2*k+1 );
      
      div = div.multiply(div2);
      
       BigDecimal ad = BigDecimal.valueOf(1); 
      
      
      ad = ad.divide( div,RoundingMode.DOWN );
        
      if(k%2 != 0){
       ad = ad.negate(); 
      }
      
      pix = pix.add( ad );
     
      k++;
    }
    
    pix = pix.multiply( BigDecimal.valueOf( 2*Math.sqrt(3) ) );
    
  }
  
  
  public void compute(){
  
    pi = 0;
    
    int k =0;
    while(k<=times-1){
     
      pi = pi + Math.pow(-1,k) / (Math.pow(3,k)*(2*k+1));
      
      k++;
      
    }
    
    pi = pi*2*Math.sqrt(3);
    
  }
  
  
  public static void main(String[] args){
   
    PiFinder piFinder = new PiFinder();
    
    piFinder.setTimes(1000);
    
    piFinder.computex();
    
    System.out.println(piFinder.pix);
    
    try{
    Writer output = null;
    String text = piFinder.pix.toString();
    File file = new File("pitry.txt");
    output = new BufferedWriter(new FileWriter(file));
    output.write(text);
    output.close();
    }catch(Exception e){}  
    
  }
  
}