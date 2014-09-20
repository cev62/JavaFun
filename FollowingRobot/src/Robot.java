import java.lang.Math;

public class Robot {

	class Vector {
		double x, y;
		Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}
		Vector() {
			this.x = (double) 0.0;
			this.y = (double) 0.0;
		}
		double mag(){
			return (double) Math.sqrt(x * x + y * y);
		}
	}
	
	double r, l, vl, vr, vt, w, theta;
	Vector d, person_d, person_v;
	
	public Robot(double r, double l, double vl, double vr, double vt, double w, double theta, double x, double y){
		this.r = r;
		this.l = l;
		this.vl = vl;
		this.vr = vr;
		this.vt = vt;
		this.w = w;
		this.theta = theta;
		
		d = new Vector(x, y);
		person_d = new Vector(0, 0);
		person_v = new Vector(0, 0);
	}
	
	public void setDrive(double left, double right){
		vl = left;
		vr = right;
	}
	
	public void setDriveVtW(double vt_in, double w_in)
	{
		vl = vt_in - r*w_in;
		vr = vt_in + r*w_in;
	}
	
	public void setPerson(double px, double py, double pvx, double pvy){
		// Inputs are in earth coordinates. Need to translate to robot centric coordinates
		person_d.x =  (px - d.x)*Math.cos(-theta) - (py - d.y)*Math.sin(-theta);
		person_d.y =  (px - d.x)*Math.sin(-theta) + (py - d.y)*Math.cos(-theta);

		//System.out.print(person_d.x);
		//System.out.print(", ");
		//System.out.println(person_d.y);
		
		person_v.x =  pvx*Math.cos(-theta) - py*Math.sin(-theta);
		person_v.y =  pvy*Math.sin(-theta) + py*Math.cos(-theta);
	}
	
	public void controlOutputs()
	{
		w = (Math.atan2(person_d.y, person_d.x) - Math.PI/2) * 3;
		if(Math.abs(w) < 0.3 ){
			vt = (person_d.mag() - (l + 20 + 40)) / 2;
		}
		else{
			vt = 0;
		}
		
		setDriveVtW(vt, w);
	}
	
	public void physics(double dt){
		// Get vt and w from vl and vr
		vt = (vl + vr) / 2.0;
		w = (vr - vl) / (2.0 * r);
		
		// Apply the velocity to displacement
		d.x += -vt * Math.sin(theta) * dt;
		d.y += vt * Math.cos(theta) * dt; 
		theta += w * dt;
	}

}
