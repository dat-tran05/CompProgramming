import java.util.*;
import java.io.*;
import java.math.*;

public class Three {
	static Scanner sc;
	static PrintWriter out;
	static BufferedReader br;

	public static void main(String[] nutz) throws IOException {
		PrintWriter out = new PrintWriter(System.out);
		sc = new Scanner(new BufferedReader(new FileReader("2019/District/Three.dat")));
		br = new BufferedReader(new FileReader("2019/District/Three.dat"));

		int N = sc.nextInt();
		for(int i = 1; i <= N ; i++) {
			int num = sc.nextInt();
			String value = "";
			boolean valid = true;
			while(num != 0) {
				int last = num % 10;
				num /= 10;
				if(last == 2 || last == 3 || last == 5 || last == 7) {}
				else valid = false;
			}
			
			value = valid ? "BOTAN-PRIME" : "NOT BOTAN-PRIME";
			out.printf("Case #%d: %s\n", i, value);
		}

		sc.close();
		br.close();
		out.close();
	}
}