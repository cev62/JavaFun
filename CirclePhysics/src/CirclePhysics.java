/**
 * A class that provides basic physics mechanics for cicles in a plane
 * @author aaron
 *
 */
public class CirclePhysics {

	private class Vector {
		float x, y;
		Vector(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
	
	//private float x, y, xv, yv, xa, ya, xf, yf, m, r;
	private float m, r;
	private Vector d, v, a, f, p;
	
	/**
	 * Constructor with specified initial values for all variables
	 * @param x
	 * @param y
	 * @param xv
	 * @param yv
	 * @param xa
	 * @param ya
	 * @param xf
	 * @param yf
	 * @param m
	 * @param r
	 */
	public CirclePhysics(float x, float y,  float xv,  float yv,  float xa,  float ya,  float xf,  float yf, float xp, float yp, float m,  float r) {
		this.d.x = x;
		this.d.y = y;
		this.v.x = xv;
		this.v.y = yv;
		this.a.x = xa;
		this.a.y = ya;
		this.f.x = xf;
		this.f.y = yf;
		this.p.x = xp;
		this.p.y = yp;
		this.m = m;
		this.r = r;
	}
	
	public void physics(float dt) {
		a.x = f.x / m;
		a.y = f.y / m;
		
		v.x += a.x * dt;
		v.y += a.y * dt;
		
		d.x += v.x * dt;
		d.y += v.y * dt;
	}
	
	public void collideImmovable() {
		
	}
	
	public void applyForceX(float xf) {
		this.f.x = xf;
	}
	public void applyForceY(float yf) {
		this.f.y = yf;
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
	public float getM() {
		return m;
	}
	public float getR() {
		return r;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
