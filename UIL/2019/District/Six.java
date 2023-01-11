import java.util.*;
import java.io.*;
import java.math.*;

public class Six {
	static Scanner sc;
	static PrintWriter out;
	static BufferedReader br;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(new BufferedReader(new FileReader("2019/District/Six.dat")));
		br = new BufferedReader(new FileReader("2019/District/Six.dat"));
		/*
		 * 4  **** 4
		 * 3 4
		 * 2 6
		 * 1 8
		 * 0 10
		 * if 0 do n times
		 * 1 8
		 * 2 6
		 * 3 4
		 * 4 ****
		 */
		int N = sc.nextInt();
		while(N-- > 0) {
			int n = sc.nextInt();
			int length = 6 + n;
			out.println("    " + "*".repeat(n));
			int firstGap = 3, mid = n;
			while(firstGap!= 0) {
				out.println(" ".repeat(firstGap) + "*" + " ".repeat(mid) + "*");
				firstGap--; mid+=2;
			}
			firstGap++; mid-=2;
			for(int i =0 ; i <  n; i++)
				out.println("*" + " ".repeat(length) + "*");
			while(firstGap != 4) {
				out.println(" ".repeat(firstGap) + "*" + " ".repeat(mid) + "*");
				firstGap++; mid-=2;
			}
			
			
			
			out.println("    " + "*".repeat(n));
			out.println("-".repeat(20));
		}

		sc.close();
		br.close();
		out.close();
	}
}