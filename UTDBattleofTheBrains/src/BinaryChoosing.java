import java.util.*;

public class BinaryChoosing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long c = sc.nextLong();
		int x = 1, count = 0;
		while (x < c) {
			x <<= 1;
			count++;
		}
		/*
		 * Count = Amount of Bits (flips) Possible = Amount of Combinations for N bits
		 * 
		 */
		long possible = (long) Math.pow(count, 2);
		double completeRound = (double) count / possible;
		double numberOfRestarts = (double) count / c;
		System.out.println(count + " " + numberOfRestarts);
	}
}
