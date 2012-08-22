import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.lang.Math;

public class Node{
  
  double x;
  double y;
  double xc=600;
  double yc=350;
  double radius=300;
  int degree=1;
  int tempWeight;
  int tempCon;
  int tempConWeight;
  int myCons;
  int numNodes=60;
  int numCons=30;
  int[] cons=new int[numCons*numNodes];
  
  public Node(double xNew, double yNew){ 
  
    x=xNew;
    y=yNew;
  
  }
  
  public Node(){

  }
  
  
  public void setPos(int numNodes,int pos){
    double theta=pos*(2*Math.PI)/numNodes;
    x=xc+radius*Math.cos(theta);
    y=yc+radius*Math.sin(theta);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}