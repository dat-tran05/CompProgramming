import java.io.IOException;
import java.util.*;
import java.io.*;

public class FEB {

	public static void main(String[] nutz) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		s = elimMiddles(s);
		List<Integer> list = new ArrayList<>();

		out.println(s);
		out.close();
	}

	/*
	 * If F/S on ends, +-1 possibles of F span (0, n-1) all possible sums of an
	 * array
	 */
	public static String elimMiddles(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || i == s.length() - 1) {
				temp += s.charAt(i);
				continue;
			}
			char c = s.charAt(i - 1), c2 = s.charAt(i + 1);
			if (c != 'F' && c != 'S' && c2 != 'F' && c2 != 'S') {
				if ((c == 'B' && c2 == 'E') || (c == 'E' && c2 == 'B'))
					temp += 'E';
			} else
				temp += s.charAt(i);
		}
		return temp;
	}
}