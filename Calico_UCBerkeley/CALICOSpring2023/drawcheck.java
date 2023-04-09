import java.io.*;
import java.util.*;

class drawcheck {
	/*
	 * Find the number on the judge's card through draw and check queries while
	 * minimizing the average number of queries needed.
	 * 
	 * Call the draw and check functions below to make draw and check queries.
	 * Return from this function when you see check() return ABSENT. This template
	 * also handles reading the final verdict at the end.
	 */
	static void solve() throws IOException {
		// YOUR CODE HERE
	}

	/**
	 * Shuffle the deck and draw the top 17 cards.
	 */
	static int[] draw() throws IOException {
		out.println("draw");
		out.flush();
		String response = in.readLine();
		if (response.equals("WRONG_ANSWER")) {
			System.exit(0);
		}
		String[] token = response.split(" ");
		int[] cards = new int[17];
		for (int i = 0; i < 17; i++) {
			cards[i] = Integer.parseInt(token[i]);
		}
		return cards;
	}

	/**
	 * Check if a card exists within the deck.
	 */
	static String check(int card) throws IOException {
		out.println("check " + card);
		out.flush();
		String response = in.readLine();
		if (response.equals("WRONG_ANSWER")) {
			System.exit(0);
		}
		return response;
	}

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			solve();
		}
		String response = in.readLine();
	}
}