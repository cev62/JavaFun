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
	float m, r, ufk, ufs;
	Vector d, v, a, f, p;
	
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
		// Apply the velocity to displacement
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
		float nMag = n.mag();
		n.x = n.x / nMag;
		n.y = n.y / nMag;
		
		// Adjust for overlap
		float overlap = r - nMag;
		Vector overlapVector = new Vector(overlap * n.x, overlap * n.y);
		d.x -= overlapVector.x;
		d.y -= overlapVector.y;
		
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
	
	void collide(CirclePhysics a, CirclePhysics b) {
		
		// Make a normal unit vector relative to a
		Vector n_a = new Vector(b.d.x -a.d.x, b.d.y - a.d.y);
		float n_aMag = n_a.mag();
		n_a = new Vector(n_a.x / n_aMag, n_a.y / n_aMag);
		
		// Get the normal component of a's velocity
		float v_aDotn_a = a.v.x * n_a.x + a.v.y * n_a.y;
		Vector vn_a = new Vector(n_a.x * v_aDotn_a, n_a.y * v_aDotn_a);
		
		// Make a normal tangent vector relative to a
		Vector t_a = new Vector(-n_a.y, n_a.x);
		
		// Get the tangential component of a's velocity
		float v_aDott_a = a.v.x * t_a.x + a.v.y * t_a.y;
		Vector vt_a = new Vector(t_a.x * v_aDott_a, t_a.y * v_aDott_a);
		
		/*
		 * End repeat
		 */
		
		// Make a normal unit vector relative to b
		Vector n_b = new Vector(a.d.x - b.d.x, a.d.y - b.d.y);
		float n_bMag = n_b.mag();
		n_b = new Vector(n_b.x / n_bMag, n_b.y / n_bMag);
		
		// Get the normal component of b's velocity
		float v_bDotn_b = b.v.x * n_b.x + b.v.y * n_b.y;
		Vector vn_b = new Vector(n_b.x * v_bDotn_b, n_b.y * v_bDotn_b);
		
		// Make a normal tangent vector relative to b
		Vector t_b = new Vector(-n_b.y, n_b.x);
		
		// Get the tangential component of a's velocity
		float v_bDott_b = b.v.x * t_b.x + b.v.y * t_b.y;
		Vector vt_b = new Vector(t_b.x * v_bDott_b, t_b.y * v_bDott_b);
		
		/*
		 * End repeat
		 */
		
		/*
		 * Apply collision
		 */
		
		float tmp = vn_a.x;
		vn_a.x = vn_b.x;
		vn_b.x = tmp;
		
		tmp = vn_a.y;
		vn_a.y = vn_b.y;
		vn_b.y = tmp;
		
		/*
		 * Sum vectors back up
		 */

		a.v.x = vn_a.x + vt_a.x;
		a.v.y = vn_a.y + vt_a.y;

		b.v.x = vn_b.x + vt_b.x;
		b.v.y = vn_b.y + vt_b.y;
		
		/*
		 * TODO implement momentum (mass)
		 */
	}

}
