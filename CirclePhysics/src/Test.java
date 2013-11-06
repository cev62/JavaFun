/**
 * 
 * @author aaron
 *
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class Test extends JFrame implements ActionListener, KeyListener{

	CirclePhysics c;
	final int width = 800;
	final int height = 600;
	boolean keys[];
	
	public Test() {
		Container window = getContentPane();
		addKeyListener(this);	
		setSize(width,height);
		setFocusable(true);
		setTitle("Cicle Physics Test");
		setVisible(true);
		
		keys = new boolean[4];
		
		c = new CirclePhysics(400, 300, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 10);
		//c.applyForceX(-100.0f);
		//c.applyForceY(0.0f);
		c.applyFrictionX(100.0f);
		c.applyFrictionY(100.0f);
		
		javax.swing.Timer t = new Timer(20, this);
		t.start();
		
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	    Graphics2D g2d=(Graphics2D)g;
	    g2d.fill(new Ellipse2D.Double(c.getX(), height-c.getY(), c.getR() * 2, c.getR() * 2));
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		c.applyForceX((keys[0] ? -300.0f : 0.0f) + (keys[2] ? 300.0f : 0.0f));
		c.applyForceY((keys[1] ? 300.0f : 0.0f) + (keys[3] ? -300.0f : 0.0f));
		
		c.physics((float) 0.02);
		if(c.getX() + c.getR() >= width-10) {
			c.collideImmovable(1.0f, 0.0f);
		}
		if(c.getX() - c.getR() <= 0) {
			c.collideImmovable(-1.0f, 0.0f);
		}
		if(c.getY() + c.getR() >= height-10) {
			c.collideImmovable(0.0f, 1.0f);
		}
		if(c.getY() - c.getR() <= 0) {
			c.collideImmovable(0.0f, -1.0f);
		}
		repaint();
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test();
	}

	@Override
	public void keyPressed(KeyEvent key) {
		if(key.getKeyCode()==37){
			keys[0] = true;
	    }
	    if(key.getKeyCode()==38){
	    	keys[1] = true;
	    }
	    if(key.getKeyCode()==39){
	    	keys[2] = true;
	    }
	    if(key.getKeyCode()==40){
	    	keys[3] = true;
	    }	
	}

	@Override
	public void keyReleased(KeyEvent key) {
		if(key.getKeyCode()==37){
			keys[0] = false;
	    }
	    if(key.getKeyCode()==38){
	    	keys[1] = false;
	    }
	    if(key.getKeyCode()==39){
	    	keys[2] = false;
	    }
	    if(key.getKeyCode()==40){
	    	keys[3] = false;
	    }	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
