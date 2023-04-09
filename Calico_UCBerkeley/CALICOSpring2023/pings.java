import java.io.*;
import java.util.*;
class pings {
	/**
	 * Output the number of times each user is pinged in the server after all
	 * actions.
	 *
	 * Q: the total number of actions N: the number of roles in the server M: the
	 * number of users in the server X: the list of actions performed at each
	 * timestep R: the list of roles involved at each timestep U: the list of users
	 * involved at each timestep, or -1 if the action is a ping
	 */
	static void solve(int Q, int N, int M, char[] X, int[] R, int[] U) {
		// N Roles, M Users, Q queries
		// YOUR CODE HERE
		Player[] players = new Player[M + 1];
		for (int i = 0; i < M + 1; i++)
			players[i] = new Player(N);
		for (int i = 0; i < Q; i++) {
			char action = X[i];
			int role = R[i];
			int user = U[i];
			if (action == 'P') {
				for (Player p : players) {
					if (p.roles[role] != 0)
						p.pings++;
				}
			} else if (action == 'R') {
				players[user].roles[role]--;
			} else {// aDD
				players[user].roles[role]++;
			}
		}

		// PRINT
		StringJoiner j = new StringJoiner(" ");
		for (int i = 1; i < players.length; i++) {
			Player p = players[i];
			j.add(p.pings + "");
		}
		out.println(j);
	}

	static class Player {
		long[] roles;
		long pings;

		public Player(int N) {
			roles = new long[100001];
			pings = 0;
		}
	}
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String[] temp = in.readLine().strip().split(" ");
			int Q = Integer.parseInt(temp[0]);
			int N = Integer.parseInt(temp[1]);
			int M = Integer.parseInt(temp[2]);

			char[] X = new char[Q];
			int[] R = new int[Q];
			int[] U = new int[Q];

			for (int k = 0; k < Q; k++) {
				String[] tok = in.readLine().strip().split(" ");
				X[k] = tok[0].charAt(0);
				R[k] = Integer.parseInt(tok[1]);
				if (tok.length > 2) {
					U[k] = Integer.parseInt(tok[2]);
				} else {
					U[k] = -1;
				}
			}

			solve(Q, N, M, X, R, U);
		}
		out.flush();
	}
}
/*
1
6 1 3
P 1
A 1 2
P 1
P 1
A 1 3
P 1
*/