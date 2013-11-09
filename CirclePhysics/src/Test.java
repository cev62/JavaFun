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
import java.util.ArrayList;

public class Test extends JFrame implements ActionListener, KeyListener{

	ArrayList<CirclePhysics> c;
	CirclePhysics player;
	final int width = 800;
	final int height = 600;
	boolean keys[];
	
	public Test() {
		Container window = getContentPane();
		addKeyListener(this);	
		setSize(width, height);
		setFocusable(true);
		setTitle("Cicle Physics Test");
		setVisible(true);
		
		keys = new boolean[4];

		c = new ArrayList<CirclePhysics>();
		c.add(new CirclePhysics(100, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0f, 20));
		c.add(new CirclePhysics(700, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2.0f, 20));
		
		player = c.get(0);

		for(CirclePhysics cir : c){
			cir.setFrictionS(10.0f);
			cir.setFrictionK(10.0f);
		}
		
		javax.swing.Timer t = new Timer(5, this);
		t.start();
		
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	    Graphics2D g2d=(Graphics2D)g;
	    for(CirclePhysics cir : c){
	    g2d.fill(new Ellipse2D.Double(cir.getX(), height-cir.getY(), cir.getR() * 2, cir.getR() * 2));
	    }
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		player.applyForceX((keys[0] ? -300.0f : 0.0f) + (keys[2] ? 300.0f : 0.0f));
		player.applyForceY((keys[1] ? 300.0f : 0.0f) + (keys[3] ? -300.0f : 0.0f));

		for(CirclePhysics cir : c) {
			cir.physics((float) 0.005);
			if(cir.getX() + cir.getR() >= width) {
				cir.collideImmovable(width - cir.getX(), 0.0f);
			}
			if(cir.getX() - cir.getR() <= 0) {
				cir.collideImmovable(-cir.getX(), 0.0f);
			}
			if(cir.getY() + cir.getR() >= height) {
				cir.collideImmovable(0.0f, height - cir.getY());
			}
			if(cir.getY() - cir.getR() <= 0) {
				cir.collideImmovable(0.0f, -cir.getY());
			}
		}
		
		if(Math.pow(player.getY() - c.get(1).getY(), 2) + Math.pow(player.getX() - c.get(1).getX(), 2) < Math.pow(player.getR() + c.get(1).getR(), 2)){
			player.collide(player, c.get(1));
		}
		
		repaint();

		//System.out.println("(" + c.getX() + ", " + c.getY() + ")");
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
