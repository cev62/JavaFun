/**
 * A class implementing a Kalman filter for testing
 * 
 * @author Aaron Maharry
 *
 */

import Jama.Matrix;

public class KalmanTest {

	Matrix A, B, T, H, Z, S, K, R, Q, P, Ppredicted;
	double[] x, y, z, u, xPredicted;
	int dim;

	
	KalmanTest(double[][] A_, double[][] B_, double[][] H_, double[][] P_, double[][] Q_, double[][] R_, double[] x_){
		A = A_;
		B = B_;
		H = H_;
		P = P_;
		Q = Q_;
		R = R_;
		x = x_;
		
		dim = x.length;
		y = new double[dim];
		z = new double[dim];
		u = new double[dim];
		xPredicted = new double[dim];

		T = new double[dim][dim];
		Z = new double[dim][dim];
		S = new double[dim][dim];
		K = new double[dim][dim];
		Ppredicted = new double[dim][dim];
	}
	
	/*
	 * Updates the current state based on the predicted current state and the measurement of the current state.
	 * prev_state is updated the reflect the value of the current state at the end 
	 */
	void update(double[] z_, double[] u_){
		z = z_;
		u = u_;
		xPredicted = add(mult(A, x), mult(B, u));
		Ppredicted = add(mult(mult(A, P), transpose(A)), Q);
		y = add(z, mult(H, mult(xPredicted, -1)));
		S = add(mult(H, mult(Ppredicted, transpose(H))), R);
		K = 
	}
	
	double[] getState(){
		return x;
	}
	
	/**
	 * Matrix multiplication. Requires properly dimensioned matrices
	 * @param a first mXn matrix
	 * @param b second nXp matrix
	 * @return the resultant matrix
	 */
	double[][] mult(double[][] a, double[][] b){
		int m = a.length;
		int n = a[0].length;
		int p = b[0].length;
		double[][] output = new double[m][p];
		for(int i = 0; i < m; i++){
			for(int j = 0; j < p; j++){
				output[i][j] = 0.0;
				for(int k = 0; k < n; k++){
					output[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return output;
	}
	
	/**
	 * Matrix multiplied by a vector.
	 * @param a an mXn matrix
	 * @param b an n-dim vector
	 * @return The resultant vector
	 */
	double[] mult(double[][] a, double[] b){
		int m = a.length;
		int n = a[0].length;
		double[] output = new double[n];
		for(int i = 0; i < n; i++){
			output[i] = 0.0;
			for(int j = 0; j < m; j++){
				output[i] += a[i][j] * b[i];
			}
		}
		return output;
	}
	
	double[][] add(double[][] a, double[][] b){
		int m = a.length;
		int n = a[0].length;
		double[][] output = new double[m][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				output[i][j] = a[i][j] + b[i][j];
			}
		}
		return output;
	}
	
	double[] add(double[] a, double[] b){
		int n = a.length;
		double[] output = new double[n];
		for(int i = 0; i < n; i++){
				output[i] = a[i] + b[i];
		}
		return output;
	}
	
	double[][] transpose(double[][] a){
		int m = a.length;
		int n = a[0].length;
		double[][] output = new double[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				output[i][j] = a[j][i];
			}
		}
		return output;
	}
	
	double[] mult(double[] a, double b){
		int n = a.length;
		double[] output = new double[n];
		for(int i = 0; i < n; i++){
				output[i] = a[i] * b;
		}
		return output;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] A = {{1, 1},
						{0, 1}};
		double[][] B = {{0}};
		double[][] H = {{1, 0}};
		double[][] P = {{0, 0},
						{0, 0}};
		double[][] Q = {{0.1, 0},
						{0, 0.1}};
		double[][] R = {{0.1, 0},
						{0, 0.1}};
		double[] x = {0, 1};
		
		
		KalmanTest test = new KalmanTest(A, B, H, P, Q, R, x);
		
		// Initialize a test case
		double[] measurements = {1.02, 1.89, 3.01, 4.08, 5.03};
		double[] calculatedStates = new double[5];
		double time = 0.0;
		
		// Loop through, adding the timestep, computing and soring the new state
		/*for(int i = 0; i < 5; i++){
			time += 1.0;
			test.predict(1.0);
			test.update(measurements[i]);
			calculatedStates[i] = test.getState();
		}
		
		// Print the output
		for(int i = 0; i < 5; i++){
			System.out.println(i + ": " + calculatedStates[i] + ", " + measurements[i]);
		}*/
		
	}

}

