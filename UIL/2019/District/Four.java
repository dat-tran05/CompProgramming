import java.util.*;
import java.io.*;
import java.math.*;

public class Four {
	static Scanner sc;
	static PrintWriter out;
	static BufferedReader br;

	public static void main(String[] nutz) throws IOException {
	    out = new PrintWriter(System.out);
		sc = new Scanner(new BufferedReader(new FileReader("2019/District/Four.dat")));
		br = new BufferedReader(new FileReader("2019/District/Four.dat"));

		String firstLine = " ".repeat(5) + "Amount" + " ".repeat(29) + "Monthly" + " ".repeat(9) + "Total of";
		String secondLine = ".".repeat(4) + "Invested" + ".".repeat(8) + "APR" + ".".repeat(6) + "Years......Payment.........Payments" + ".".repeat(12) + "Profit..";
		out.println(firstLine+"\n"+secondLine);
		int N = sc.nextInt();
		while(N-- > 0) {
			printLine(sc.nextDouble(), sc.nextDouble(), sc.nextInt());
		}
		
		sc.close();
		br.close();
		out.close();
	}
	static void printLine(double ai, double apr, int years) {
		int payments = years * 12;
		double r = apr * .01 / 12;
		double monthly = (ai * r) / (1 - Math.pow(1 + r, years * -12));
		monthly = Double.parseDouble(String.format("%.2f", monthly));
		double total = monthly * 12 * years;
		double profit = total - ai;
		String line = "$" + formatNum(ai, false) + "  |" + String.format("%8.3f", apr)+"%  |   " + years+"  |  $" + formatNum(monthly,true)+"  |  $" +formatNum(total,false)  +"  |  $" +formatNum(profit,false);
		out.println(line);
	
	}
	static String formatNum (double n, boolean month) {
		if(month) {
			return String.format("%,9.2f", n);
		}else
			return String.format("%,12.2f", n);
	}
}