import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Line2D;

import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.Timer;


public class FollowingRobot extends JFrame implements ActionListener, KeyListener{

	final int width = 800;
	final int height = 600;
	boolean keys[];
	Robot robot;
	CirclePhysics person;
	
	public FollowingRobot() {
		Container window = getContentPane();
		addKeyListener(this);	
		setSize(width, height);
		setFocusable(true);
		setTitle("Cicle Physics Test");
		setVisible(true);
		
		keys = new boolean[4];
		robot = new Robot(30, 50, 0, 0, 0, 0, 1, 400.0, 300.0);
		person = new CirclePhysics(100, 500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1.0f, 20);
		
		person.setFrictionS(10.0f);
		person.setFrictionK(10.0f);
		
		//robot.setDrive(30, -30);
		
		javax.swing.Timer t = new Timer(5, this);
		t.start();
		
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
	    Graphics2D g2d=(Graphics2D)g;
	    double cost = Math.cos(robot.theta);
	    double sint = Math.sin(robot.theta);
	    double ax = robot.d.x - robot.l*sint - robot.r*cost;
	    double ay = robot.d.y + robot.l*cost - robot.r*sint;
	    double bx = robot.d.x - robot.l*sint + robot.r*cost;
	    double by = robot.d.y + robot.l*cost + robot.r*sint;
	    double cx = robot.d.x + robot.l*sint + robot.r*cost;
	    double cy = robot.d.y - robot.l*cost + robot.r*sint;
	    double dx = robot.d.x + robot.l*sint - robot.r*cost;
	    double dy = robot.d.y - robot.l*cost - robot.r*sint;
	    g2d.draw(new Line2D.Double(ax, height-ay, robot.d.x, height-robot.d.y));
	    g2d.draw(new Line2D.Double(bx, height-by, robot.d.x, height-robot.d.y));

	    g2d.draw(new Line2D.Double(ax, height-ay, bx, height-by));
	    g2d.draw(new Line2D.Double(bx, height-by, cx, height-cy));
	    g2d.draw(new Line2D.Double(cx, height-cy, dx, height-dy));
	    g2d.draw(new Line2D.Double(dx, height-dy, ax, height-ay));
	    g2d.draw(new Ellipse2D.Double(person.getX()-person.getR(), height-(person.getY()+person.getR()), person.getR() * 2, person.getR() * 2));
	    g2d.fill(new Ellipse2D.Double(person.getX(), height-(person.getY()), 2, 2));
	    
	    //g2d.fill(new Ellipse2D.Double(robot.person_d.x/2 + 400, height-(robot.person_d.y/2 + 300), 10, 10));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FollowingRobot();
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		person.applyForceX((keys[0] ? -300.0f : 0.0f) + (keys[2] ? 300.0f : 0.0f));
		person.applyForceY((keys[1] ? 300.0f : 0.0f) + (keys[3] ? -300.0f : 0.0f));
		
		person.physics((float) 0.005);
		if(person.getX() + person.getR() >= width) {
			person.collideImmovable(width - person.getX(), 0.0f);
		}
		if(person.getX() - person.getR() <= 0) {
			person.collideImmovable(-person.getX(), 0.0f);
		}
		if(person.getY() + person.getR() >= height) {
			person.collideImmovable(0.0f, height - person.getY());
		}
		if(person.getY() - person.getR() <= 0) {
			person.collideImmovable(0.0f, -person.getY());
		}
		
		robot.setPerson(person.getX(), person.getY(), person.getXV(), person.getYV());
		robot.controlOutputs();
		robot.physics(0.005f);
		
		repaint();
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
