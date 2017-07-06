package ilc;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Calculator {

	static int[] u = { 1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105,
			110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210,
			215, 220, 225, 230, 235, 240, 245, 250, 255, 260, 265, 270, 275, 280, 285, 290, 295, 300, 305, 310, 320,
			330, 350, 400, 500 };
	static double[] y_real = { 0.053183931, 0.07201688, 0.086136051, 0.105441305, 0.106430801, 0.154773989, 0.191181549,
			0.242178445, 0.249330598, 0.268776271, 0.29619399, 0.315940264, 0.335619732, 0.359101158, 0.374091174,
			0.388486814, 0.399387792, 0.416792826, 0.441425745, 0.422269289, 0.445779503, 0.443223973, 0.45066971,
			0.467345602, 0.47474136, 0.501710034, 0.499999995, 0.503224622, 0.517016931, 0.518713108, 0.547484791,
			0.555151145, 0.559680871, 0.550341763, 0.565969453, 0.609887693, 0.604104119, 0.623153185, 0.619421525,
			0.611305272, 0.630289246, 0.646131875, 0.630371225, 0.652616197, 0.634902275, 0.654888796, 0.662406906,
			0.656936483, 0.677033525, 0.681654341, 0.683188282, 0.669859688, 0.678276597, 0.691480679, 0.694673695,
			0.682800285, 0.68762213, 0.702533275, 0.722217416, 0.749327657, 0.726752438, 0.736414902, 0.72747595,
			0.745990319, 0.687871732, 0.75440048, 0.749527548, 0.731582194, 0.696214534, 0.79014958, 0.826992032 };
	static double[] y_round = { 0.05, 0.07, 0.09, 0.11, 0.11, 0.15, 0.19, 0.24, 0.25, 0.27, 0.3, 0.32, 0.34, 0.36, 0.37,
			0.39, 0.4, 0.42, 0.44, 0.42, 0.45, 0.44, 0.45, 0.47, 0.47, 0.5, 0.5, 0.5, 0.52, 0.52, 0.55, 0.56, 0.56,
			0.55, 0.57, 0.61, 0.6, 0.62, 0.62, 0.61, 0.63, 0.65, 0.63, 0.65, 0.63, 0.65, 0.66, 0.66, 0.68, 0.68, 0.68,
			0.67, 0.68, 0.69, 0.69, 0.68, 0.69, 0.7, 0.72, 0.75, 0.73, 0.74, 0.73, 0.75, 0.69, 0.75, 0.75, 0.73, 0.7,
			0.79, 0.83 };

	public static void main(String[] args) {

		if ((u.length == y_real.length) && (y_real.length == y_round.length)) {

		} else {
			System.out.println("data error......");
			return;
		}

		Arrays.sort(y_real);
		Arrays.sort(y_round);
		for (int i = 0; i < y_real.length; i++) {
			// System.out.println(u[i]+"\t"+y_real[i]+"\t"+y_round[i]);
		}

		double q = 1;
		for (int i = 0; i < y_round.length; i++) {

			if ((u[i] - 5) != 0) {
				double alpha = (y_round[i] - 0.11) / (u[i] - 5);
				if (alpha != 0) {
					q = 1 / alpha;
					//System.out.println(u[i]+"----"+y_round[i]+"----"+q);

				}

			}

		}

		ILC_Round(15,0.19,0.7,125);
		
		// the 3th iterator of input is 15
		// the 3th iterator of output is 0.19
		// the target output is 0.5
		// the learning gain is 125
		 //ILC_Round(15,0.19,0.5,125);
		
		// the 3th iterator of input is 15
		// the 3th iterator of output is 0.19
		// the target output is 0.7
		// the learning gain is 125

		// the 3th iterator of input is 15
		// the 3th iterator of output is 0.19
		// the target output is 0.3
		// the learning gain is 125

	}

	public static void ILC_Real(int u_current, double y_current, double y_d, double q) {

		System.out.println("the target output is " + y_d + " ......");

		ArrayList u_rlc = new ArrayList();
		ArrayList y_rlc = new ArrayList();

		System.out.println("begin......");

		int u_next = u_current;

		for (int j = 0; j < 50; j++) {
			double u_next_double = u_current + q * (y_d - y_current);

			// the round of the next input: u_next
			BigDecimal double2int = new BigDecimal(u_next_double);
			u_next = double2int.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

			// System.out.println(u_next_double+"\t"+u_next);

			// to find the suitable input and output
			int u5_int = u_next / 5;
			int u5_rem = u_next % 5;

			// System.out.println(u5_int+"\t"+u5_rem);

			for (int k = 0; k < u.length; k++) {
				// System.out.println(k+"\t****\t"+u[k]);
				if (u[k] == u5_int * 5) {
					// System.out.println("----------");
					if (k + 1 < u.length) {

						double gama = ((double) u5_rem) / ((double) 5);
						u_current = u_next;
						y_current = y_real[k] + ((y_real[k + 1] - y_real[k]) * gama);
						BigDecimal double2double = new BigDecimal(y_current);
						y_current = double2double.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

						u_rlc.add(u_current);
						y_rlc.add(y_current);
						// System.out.println(u_current+"\t"+y_current);
						// System.out.println("++++++++++++++");

					} else {
						return;
					}
					// return;
				}

			}

			/*
			 * 
			 * // 选择最近一个输入值u int u_index = 0;// 记录最的输入值的下标 int u_dif = 1000;//
			 * u_next与u的差
			 * 
			 * for (int k = 0; k < u.length; k++) { if (Math.abs(u_dif) >
			 * Math.abs(u[k] - u_next)) { u_dif = u[k] - u_next; u_index = k; }
			 * } // 完成上面的循环后，可以找到下次输入和最终输出。 u_rlc.add(u_next + u_dif);
			 * y_rlc.add(y_round[u_index]);
			 * 
			 * u_current = u_next + u_dif;
			 * 
			 * y_current = y_round[u_index];// y当前的输出应该再重新处理
			 * 
			 */

		}

		Iterator it_u = u_rlc.iterator();
		Iterator it_y = y_rlc.iterator();
		int l = 0;
		while (it_u.hasNext() && it_y.hasNext()) {

			int u_it = ((Integer) it_u.next()).intValue();
			double y_it = ((Double) it_y.next()).doubleValue();
			l++;
			System.out.println(u_it + "/" + y_it + " -- the " + l + "th iteration of input/output");
		}

		System.out.println("end......");
	}

	public static void ILC_5(int u_current, double y_current, double y_d, double q) {

		ArrayList u_rlc = new ArrayList();
		ArrayList y_rlc = new ArrayList();

		// double q=1;
		// int u_current=15;
		// double y_current=0.19;
		// double y_d=0.5;
		System.out.println("begin......");

		// q=125;

		int u_next = u_current;

		for (int j = 0; j < 100; j++) {
			double u_next_double = u_current + q * (y_d - y_current);
			BigDecimal double2int = new BigDecimal(u_next_double);
			u_next = double2int.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

			// 选择最近一个输入值u
			int u_index = 0;// 记录最的输入值的下标
			int u_dif = 1000;// u_next与u的差

			for (int k = 0; k < u.length; k++) {
				if (Math.abs(u_dif) > Math.abs(u[k] - u_next)) {
					u_dif = u[k] - u_next;
					u_index = k;
				}
			}
			// 完成上面的循环后，可以找到下次输入和最终输出。
			u_rlc.add(u_next + u_dif);
			y_rlc.add(y_round[u_index]);

			u_current = u_next + u_dif;

			y_current = y_round[u_index];// y当前的输出应该再重新处理

		}

		Iterator it_u = u_rlc.iterator();
		Iterator it_y = y_rlc.iterator();
		int l = 0;
		while (it_u.hasNext() && it_y.hasNext()) {

			int u_it = ((Integer) it_u.next()).intValue();
			double y_it = ((Double) it_y.next()).doubleValue();
			l++;
			System.out.println(u_it + "/" + y_it + " -- the " + l + "th iteration of input/output");
		}

		System.out.println("end......");
	}

	// backup 1
	public static void ILC_Round(int u_current, double y_current, double y_d, double q) {

		System.out.println("the target output is " + y_d + " ......");

		ArrayList u_ilc = new ArrayList();
		ArrayList y_ilc = new ArrayList();

		System.out.println("begin......");

		int u_next = u_current;

		for (int j = 0; j < 50; j++) {
			double u_next_double = u_current + q * (y_d - y_current);

			// the round of the next input: u_next
			BigDecimal double2int = new BigDecimal(u_next_double);
			u_next = double2int.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();

			// System.out.println(u_next_double+"\t"+u_next);

			// to find the suitable input and output
			int u5_int = u_next / 5;
			int u5_rem = u_next % 5;

			for (int k = 0; k < u.length; k++) {
				if (u[k] == u5_int * 5) {
					if (k + 1 < u.length) {

						double gama = ((double) u5_rem) / ((double) 5);
						u_current = u_next;
						y_current = y_round[k] + ((y_round[k + 1] - y_round[k]) * gama);
						BigDecimal double2double = new BigDecimal(y_current);
						y_current = double2double.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

						u_ilc.add(u_current);
						y_ilc.add(y_current);

					} else {
						return;
					}

				}

			}

		}

		Iterator it_u = u_ilc.iterator();
		Iterator it_y = y_ilc.iterator();
		int l = 0;
		while (it_u.hasNext() && it_y.hasNext()) {

			int u_it = ((Integer) it_u.next()).intValue();
			double y_it = ((Double) it_y.next()).doubleValue();
			l++;
			System.out.println(u_it + "/" + y_it + " -- the " + l + "th iteration of input/output");
		}

		System.out.println("end......");
	}
}
