/**
 * A class that provides basic physics mechanics for cicles in a plane
 * @author aaron
 *
 */

import java.lang.Math;

public class CirclePhysics {

	private class Vector {
		float x, y;
		Vector(float x, float y) {
			this.x = x;
			this.y = y;
		}
		Vector() {
			this.x = (float) 0.0;
			this.y = (float) 0.0;
		}
	}
	
	//private float x, y, xv, yv, xa, ya, xf, yf, m, r;
	private float m, r;
	private Vector d, v, a, f, p, fr;
	
	/**
	 * Constructor with specified initial values for all variables
	 * @param x position (x)
	 * @param y position (y)
	 * @param xv velocity (x)
	 * @param yv velocity (y)
	 * @param xa acceleration (x)
	 * @param ya acceleration (y)
	 * @param xf force (x)
	 * @param yf force (y)
	 * @param m mass
	 * @param r radius
	 */
	public CirclePhysics(float x, float y,  float xv,  float yv,  float xa,  float ya,  float xf,  float yf, float xp, float yp, float xfr, float yfr, float m,  float r) {
		d = new Vector(x, y);
		v = new Vector(xv, yv);
		a = new Vector(xa, ya);
		f = new Vector(xf, yf);
		p = new Vector(xp, yp);
		fr = new Vector(xfr, yfr);
		
		this.m = m;
		this.r = r;
	}
	
	public void physics(float dt) {
		float fx = f.x;
		float fy = f.y;
		float frictx = 0.0f;
		float fricty = 0.0f;
		
		if(v.x < 0){
			frictx = fr.x;
		}
		if(v.x > 0){
			frictx = -fr.x;
		}
		
		if(v.y < 0){
			fricty = fr.y;
		}
		if(v.y > 0){
			fricty = -fr.y;
		}
		
		a.x = (f.x + frictx) / m;
		a.y = (f.y + fricty) / m;
		
		float prevVx = v.x;
		float prevVy = v.y;
		
		v.x += a.x * dt;
		v.y += a.y * dt;

		if (prevVx * v.x < 0 && Math.abs(v.x) < Math.abs(frictx * dt)) {
			v.x = 0.0f;
		}
		if (prevVy * v.y < 0 && Math.abs(v.y) < Math.abs(fricty * dt)) {
			v.y = 0.0f;
		}
		System.out.println("(" + frictx + ", " + fricty + ")");
		d.x += v.x * dt;
		d.y += v.y * dt;
		
		/*
		 * TODO: Add tmp_v and tmp_d capabilities for unified movement
		 */
		
	}
	
	public void collideImmovable(float normalX, float normalY) {
		// Normal vector of the collision
		Vector n = new Vector(normalX, normalY);
		
		// Make n a unit vector
		float nMag = (float) Math.sqrt(n.x*n.x+n.y*n.y);
		n.x = n.x / nMag;
		n.y = n.y / nMag;
		
		// Compute dot product
		float vDotn = v.x * n.x + v.y * n.y; 
		
		// Normal component of the velocity
		Vector vn = new Vector(n.x * vDotn, n.y * vDotn);
		
		// Make unit tangent vector
		Vector t = new Vector(-n.y, n.x);
		
		// Compute dot product
		float vDott = v.x * t.x + v.y * t.y; 
		
		// Tangential component of the velocity
		Vector vt = new Vector(t.x * vDott, t.y * vDott);
		
		// Apply collision to vn component
		vn.x = -vn.x;
		vn.y = -vn.y;
		
		// Combine vn and vt and set velocity
		v.x = vn.x + vt.x;
		v.y = vn.y + vt.y;
	}
	
	public void applyForceX(float xf) {
		this.f.x = xf;
	}
	public void applyForceY(float yf) {
		this.f.y = yf;
	}
	
	public void applyFrictionX(float xfr) {
		this.fr.x = xfr;
	}
	public void applyFrictionY(float yfr) {
		this.fr.y = yfr;
	}
	
	public float getX() {
		return d.x;
	}
	public float getY() {
		return d.y;
	}
	public float getXV() {
		return v.x;
	}
	public float getYV() {
		return v.y;
	}
	public float getXA() {
		return a.x;
	}
	public float getYA() {
		return a.y;
	}
	public float getXF() {
		return f.x;
	}
	public float getYF() {
		return f.y;
	}
	public float getXP() {
		return p.x;
	}
	public float getYP() {
		return p.y;
	}
	public float getXFR() {
		return fr.x;
	}
	public float getYFR() {
		return fr.y;
	}
	public float getM() {
		return m;
	}
	public float getR() {
		return r;
	}

}
