import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Math;
import java.awt.geom.*;

public class Graphs extends JFrame implements ActionListener{
  
  int numNodes=60;
  int numCons=30;
  int weightCoef=1;
  double size=10;
  Node[] node;
  Random rand;
  Timer timer;
  double xc=600;
  double yc=350;
  
  public Graphs(){
    
    rand=new Random();
    timer=new Timer(20,this);
    
    node = new Node[numNodes+1];

    
    int k=1;
    while(k<=numNodes){
     node[k]= new Node(); 
     k++;
    }
   
    k=1;
    while(k<=numNodes){
     node[k].setPos(numNodes,k); 
     k++;
    }
    
    connections();
    
    Container window = getContentPane();
    

    setFocusable(true);
    setTitle("Graphs");
    setVisible(true);
    setSize(1200,700);
    
  }
  
  
  public void paint(Graphics g){
  super.paint(g);
  Graphics2D g2d=(Graphics2D)g;
  
  int k=1;
  while(k<=numNodes){
    g2d.draw(new Ellipse2D.Double(node[k].x-size/2,node[k].y-size/2,size,size));
    k++; 
  }
  
  k=1;
  while(k<=numNodes){
    int i=1;
    while(i<=node[k].myCons){
    g2d.draw(new Line2D.Double(node[k].x,node[k].y,node[node[k].cons[i]].x,node[node[k].cons[i]].y));
    i++;
    }
    k++;
  }
  
  k=1;
  while(k<numNodes){
   g2d.draw(new Line2D.Double(node[k].x,node[k].y,node[k+1].x,node[k+1].y));
    k++; 
  }
  
  g2d.draw(new Line2D.Double(node[1].x,node[1].y,node[numNodes].x,node[numNodes].y));
  
  }
  
  
  public void actionPerformed(ActionEvent evt){
   repaint(); 
  }
  
  
  public void connections(){
    int k=2;
    while(k<=numNodes){
    int diff=k-numCons;
    if(diff>=0){
     //normal connections  #=numCons
      connect(node[k],numCons,k);
    }
    else{
    //low connections  #=k-1
      connect(node[k],k-1,k);
    }
    
    k++;
    }
  }
  
  public void connect(Node n,int num,int index){
    
    
    int i=1;
    while(i<=num){
    int k=1;
    while(k<=numNodes){
      if(k!=index){
        node[k].tempWeight=rand.nextInt(1000)*node[k].degree;
      }
      k++;
    }
      
    k=1;
    node[index].tempCon=0;
    node[index].tempConWeight=0;
    while(k<=numNodes){
      if(k!=index){
        if(node[k].tempWeight>node[index].tempConWeight){
        node[index].tempConWeight=node[k].tempWeight;
        node[index].tempCon=k;
        }
      }
      k++; 
    }
    node[index].cons[i]=node[index].tempCon;
    node[index].degree++;
    node[i].degree++;
    node[index].myCons=i;
    i++;
  }
  
  }
  
  
  
  
  public static void main(String[] args){
   new Graphs(); 
  }
  
  
}