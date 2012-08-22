import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.lang.Math;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageEdit extends JFrame{
  
  JPanel panel;
  Image picture;
  JLabel label;
  int[] pixels;
  
  
  public ImageEdit(){
    
    int picWidth;
    int picHeight;
    pixels=new int[400];
    int j=0;
    while(j<=400){
      pixels[j]=0;
      j++; 
    }
    
   getImageFromArray(pixels,20,20);
    
    
  label = new JLabel(new ImageIcon( picture ));
  panel= new JPanel(new GridLayout(1,1));
  panel.add(label);
  Container window = getContentPane();
  window.setLayout(new GridLayout(1,1));
  window.add(panel);
  setSize(picture.getWidth(x),picture.getHeight(y));
  setTitle("ImageEditor");
  setVisible(true);
  
  
  }
  
  
  public static Image getImageFromArray(int[] pixels, int width, int height) {
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            WritableRaster raster = (WritableRaster) image.getData();
            raster.setPixels(0,0,width,height,pixels);
            return image;
        }
  
  
  
  public static void main(String[] args){
   new ImageEdit(); 
  }
  
  
  
  
  
  
}