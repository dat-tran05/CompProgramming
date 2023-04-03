import java.util.*;
import java.io.*;
import java.math.*;

public class P6 {
	static Scanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			makeSpiral(n);
		}

		sc.close();
		out.close();
	}

	public static void makeSpiral(int n) {
		if (n <= 0) {
			out.println();
			return;
		}
		int spaces = n + 1;
		int length = 1 + n * 4; // Square Length of Loop
		out.println("@".repeat(length));
		out.println(" ".repeat(length - 1) + "@");
		for (int i = 2; i < n - 1; i++) {

		}
		out.println("@".repeat(length));

	}
	/*
	 * 
	 * Min Length = 5 5, 9 , 13
	 * 
	 */
}