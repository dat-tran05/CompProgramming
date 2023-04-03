import java.util.*;
import java.io.*;
import java.math.*;

public class P4 {
	static Scanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();
		while (tc-- > 0) {
			String[] line = sc.nextLine().split(" ");
			int max = 0;
			for (String s : line)
				max = Math.max(max, s.length());
			out.println("*".repeat(max + 2));
			for (String s : line) {
				out.printf("*%-" + max + "s*\n", s);
			}
			out.println("*".repeat(max + 2));
			out.println();
		}

		sc.close();
		out.close();
	}
}
/*
4
Live Laugh Love
Bless This Mess
i have high blood pressure
A 
*/