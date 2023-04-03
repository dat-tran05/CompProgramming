import java.util.*;
import java.io.*;
import java.math.*;

public class P2 {
	static Scanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		for (int i = 0; i < tc; i++) {
			String s = sc.next();
			String result = "";
			for (char c : s.toCharArray()) {
				if (c == 'A')
					result += 'T';
				else if (c == 'T')
					result += 'A';
				else if (c == 'C')
					result += 'G';
				else
					result += 'C';
			}
			out.println(result);
		}

		sc.close();
		out.close();
	}
}