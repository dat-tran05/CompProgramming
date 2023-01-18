import java.util.*;
import java.io.*;
import java.math.*;

public class Seven {
	static Scanner sc;
	static PrintWriter out;
	static BufferedReader br;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(new BufferedReader(new FileReader("2019/District/Seven.dat")));
		br = new BufferedReader(new FileReader("2019/District/Seven.dat"));
		int tc = sc.nextInt();
		for(int i = 1; i <= tc; i++) {
			int r1 = sc.nextInt(), c1 = sc.nextInt(), r2 = sc.nextInt(), c2 = sc.nextInt();
			//may need to skip line
			sc.nextLine();
			if(c1 != r2) {
				out.printf("%d: %s\n", i, "SIZES NOT COMPATIBLE");
				out.println("^".repeat(12));
				for(int k = 0; k < r1 + r2; k++) sc.nextLine();
				continue;
			}
			int[][] first = new int[r1][c1], second = new int[r2][c2];
			int[][] res = new int[r1][c2];
			for(int j = 0; j < r1; j++)
					first[j] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j < r2; j++)
					second[j] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			for(int col1 = 0; col1 < c2; col1++) {
				for(int r = 0; r < r1; r++) {
					int sum = 0;
					for(int c = 0; c < c1; c++) {
						sum+= first[r][c] * second[c][col1];
					}
					res[r][col1] = sum;
				}
			}
			out.printf("%d:%d,%d%n", i, r1, c2);
			printGrid(res);
			out.println("^".repeat(12));
			/*
			 *  loop second cols
			 *  	loop one rows
			 *  	int sum
			 *  		loop one cols
			 *  			sum += one[r][c] * two[c][first c]
			 *  	res[r][first c] = sum
			 *  	
			 */
		}
		

		sc.close();
		br.close();
		out.close();
	}
	static void printGrid(int[][] g) {
		for(int r = 0; r < g.length; r++) {
			String line = "";
			for(int c = 0; c < g[r].length; c++) {
				String num = String.format("%5d", g[r][c]);
				line+=num +" ";
			}
			out.println(line.stripTrailing());
		}
	}
}