import java.io.*;

class genshin {
	/**
	 * Starting with P primogems, get Baizhu through wishing without buying more
	 * primogems than necessary.
	 * 
	 * Call the buy and wish functions below to make buy and wish queries. This
	 * template handles parsing P and checking for CORRECT after you get Baizhu.
	 * 
	 * P: the number of starting primogems
	 */
	static void solve(int P) throws IOException {
		// YOUR CODE HERE
		int wishes = 180;
		while (wishes > 0) {
			if (P < 160) {
				P += buy();
			} else {
				String s = wish();
				P -= 160;
				wishes--;
				if (s.equals("baizhu")) {
					return;
				}
			}
		}
	}

	/**
	 * Buy primogems. Returns the number of primogems you got.
	 */
	static int buy() throws IOException {
		out.println("buy");
		out.flush();
		String response = in.readLine();
		if (response.equals("WRONG_ANSWER")) {
			System.exit(0);
		}
		int amount = Integer.parseInt(response.split(" ")[2]);
		return amount;
	}

	/**
	 * Wish for a random item. Returns the name of the item you got.
	 */
	static String wish() throws IOException {
		out.println("wish");
		out.flush();
		String response = in.readLine();
		if (response.equals("WRONG_ANSWER")) {
			System.exit(0);
		}
		String item = response.split(" ")[2];
		return item;
	}

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			int P = Integer.parseInt(in.readLine());
			solve(P);
			String response = in.readLine();
			if (response.equals("WRONG_ANSWER")) {
				System.exit(0);
			}
		}
		out.flush();
	}
}
