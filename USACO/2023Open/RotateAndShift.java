import java.io.IOException;
import java.util.*;
import java.io.*;

public class RotateAndShift {

	public static void main(String[] nutz) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()),
				t = Integer.parseInt(st.nextToken());
//		sc.nextLine();
//		t %= (n * (k - 1));
		int[] active = new int[k], curr = new int[n];
		for (int i = 0; i < n; i++)
			curr[i] = i;
		String[] startingA = br.readLine().split(" ");
		for (int i = 0; i < k; i++)
			active[i] = Integer.parseInt(startingA[i]);
//		String[] repeats = new String[n * (k - 1)];
		for (int i = 1; i <= t % (n * (k - 1)); i++) {
			// Rotating Values
			int[] copy = Arrays.copyOf(curr, n);
			for (int j = 1; j < k; j++) {
				curr[active[j]] = copy[active[j - 1]];
			}
			curr[active[0]] = copy[active[k - 1]];

			// Incrementing Actives
			for (int j = 0; j < k; j++) {
				if (active[j] == n - 1)
					active[j] = 0;
				else
					active[j]++;
			}
			StringJoiner jj = new StringJoiner(" ");
			for (int i2 : curr)
				jj.add(i2 + "");
			if (t % (n * (k - 1)) == i) {
				out.println(jj);
				break;
			}
//			out.println(jj);
//			if (i % n == 0)
//				out.println(i / n);
//			repeats[i - 1] = jj.toString();
		}
//		StringJoiner jj = new StringJoiner(" ");
//		for (int i2 : curr)
//			jj.add(i2 + "");
//		out.println(repeats[t % (n * (k - 1)) - 1]);

		out.close();
	}

	/*
	 * 
	 * 5 5 4 0 1 2 3 4
	 */

}