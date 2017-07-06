package ilc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test {

	static double[] y_round = { 0.05, 0.07, 0.09, 0.11, 0.11, 0.15, 0.19, 0.24, 0.25, 0.27, 0.3, 0.32, 0.34, 0.36, 0.37,
			0.39, 0.4, 0.42, 0.44, 0.42, 0.45, 0.44, 0.45, 0.47, 0.47, 0.5, 0.5, 0.5, 0.52, 0.52, 0.55, 0.56, 0.56,
			0.55, 0.57, 0.61, 0.6, 0.62, 0.62, 0.61, 0.63, 0.65, 0.63, 0.65, 0.63, 0.65, 0.66, 0.66, 0.68, 0.68, 0.68,
			0.67, 0.68, 0.69, 0.69, 0.68, 0.69, 0.7, 0.72, 0.75, 0.73, 0.74, 0.73, 0.75, 0.69, 0.75, 0.75, 0.73, 0.7,
			0.79, 0.83 };
	static int[] u = { 1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105,
			110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210,
			215, 220, 225, 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 290, 295, 300, 305, 310, 320,
			330, 350, 400, 500 };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList u_real = new ArrayList();
		int[] x = { 2, 1 };
		u_real.add(x[0]);
		u_real.add(x[1]);
		Iterator it = u_real.iterator();
		while (it.hasNext()) {
			// 设it.next封装类,调用Integer的intValue方法返回值为int赋给i;
			int i = ((Integer) it.next()).intValue();
			//System.out.println("Element in list is :   " + i);
		}
		
		

		Arrays.sort(y_round);
		
		System.out.println("input \t output");
		for(int i=0;i<u.length && i<y_round.length;i++){
			System.out.println(u[i]+"\t "+y_round[i]);
		}
		
	}

}
