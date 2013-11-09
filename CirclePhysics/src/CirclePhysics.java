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
		float mag(){
			return (float) Math.sqrt(x * x + y * y);
		}
	}
	
	//private float x, y, xv, yv, xa, ya, xf, yf, m, r;
	private float m, r, ufk, ufs;
	private Vector d, v, a, f, p;
	
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
	public CirclePhysics(float x, float y,  float xv,  float yv,  float xa,  float ya,  float xf,  float yf, float xp, float yp, float ufk, float ufs, float m,  float r) {
		d = new Vector(x, y);
		v = new Vector(xv, yv);
		a = new Vector(xa, ya);
		f = new Vector(xf, yf);
		p = new Vector(xp, yp);
		
		this.m = m;
		this.r = r;
		this.ufk = ufk;
		this.ufs = ufs;
	}
	
	public void physics(float dt) {
		
		// Calculate friction
		float vmag = v.mag();
		float fmag = f.mag();
		boolean isKineticFrict = vmag != 0;
		float frx = 0.0f, fry = 0.0f;
		
		if(isKineticFrict) {	
			// Kinetic friction
			frx = (float) -(ufk * m * v.x / vmag);
			fry = (float) -(ufk * m * v.y / vmag);
		}		
		else if(fmag != 0){
			// Static friction
			frx = (float) -(ufs * m * f.x / fmag);
			fry = (float) -(ufs * m * f.y / fmag);
		}
		
		Vector fnet = new Vector(f.x, f.y);
		if(!isKineticFrict) {
			fnet.x = fnet.x + frx;
			if(f.x * fnet.x < 0) {
				fnet.x = 0.0f;
			}
			fnet.y = fnet.y + fry;
			if(f.y * fnet.y < 0) {
				fnet.y = 0.0f;
			}
		}
		
		// Set acceleration from applied force
		a.x = fnet.x / m;
		a.y = fnet.y / m;
		
		// Modify velocity based on acceleration
		v.x += a.x * dt;
		v.y += a.y * dt;
		
		
		
		if(isKineticFrict) {
			// Apply friction
			Vector prevV = new Vector(v.x, v.y);
			v.x += frx / m * dt;
			v.y += fry / m * dt;
			// Account for friction changing the velocities sign
			if (prevV.x * v.x < 0) {
				v.x = 0.0f;
			}
			if (prevV.y * v.y < 0) {
				v.y = 0.0f;
			}
		}
		System.out.println("(" + frx + ", " + fry + ")");
		// Apply the velocity to displacement
		d.x += v.x * dt;
		d.y += v.y * dt;
		
		/*
		 * TODO: Add tmp_v and tmp_d capabilities for unified movement
		 */
		
		/*
		 * TODO: Implement ufs
		 */
		
	}
	
	public void collideImmovable(float normalX, float normalY) {
		// Normal vector of the collision
		Vector n = new Vector(normalX, normalY);
		
		// Make n a unit vector
		float nMag = n.mag();
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
	
	public void setFrictionS(float ufs) {
		this.ufs = ufs;
	}
	public void setFrictionK(float ufk) {
		this.ufk = ufk;
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
	public float getUFS() {
		return ufs;
	}
	public float getUFK() {
		return ufk;
	}
	public float getM() {
		return m;
	}
	public float getR() {
		return r;
	}

}
