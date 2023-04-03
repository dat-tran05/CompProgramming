import java.util.*;
import java.io.*;
import java.math.*;

public class P1 {
	static Scanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();
		while (tc-- > 0) {
			String[] line = sc.nextLine().split(":");
			double v = Double.parseDouble(line[0]), dist = Double.parseDouble(line[1]);
			if (v * 1 >= dist) {
				out.println("SWERVE");
			} else if (v * 5 >= dist) {
				out.println("BRAKE");
			} else {
				out.println("SAFE");
			}
		}

		sc.close();
		out.close();
	}
}
/*
5
23.15:98.34
2.40:17.33
6.79:5.01
0.00:1.53
113.56:113.56

*/