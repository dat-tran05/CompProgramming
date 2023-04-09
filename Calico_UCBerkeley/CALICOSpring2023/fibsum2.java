import java.io.*;

class fibsum2 {
	/**
	 * Output the resulting array A_1, A_2, ... , A_N after all fib-queries have
	 * completed.
	 * 
	 * N: the length of the array A_1, A_2, ... , A_N Q: the number of fib-queries
	 * L: the list of L_i values involved with each fib-query R: the list of R_i
	 * values involved with each fib-query
	 */
	static void solve(int N, int Q, int[] L, int[] R) {
		// YOUR CODE HERE
		return;
	}

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String[] info = in.readLine().split(" ");
			int N = Integer.parseInt(info[0]);
			int Q = Integer.parseInt(info[1]);
			int[] L = new int[Q];
			int[] R = new int[Q];
			for (int j = 0; j < Q; j++) {
				String[] fibq = in.readLine().split(" ");
				L[j] = Integer.parseInt(fibq[0]);
				R[j] = Integer.parseInt(fibq[1]);
			}
			solve(N, Q, L, R);
		}
		out.flush();
	}
}
