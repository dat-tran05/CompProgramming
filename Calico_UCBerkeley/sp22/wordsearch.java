/*
    Somewhere, something incredible is waiting to be known
    Don’t worry about failure; you only have to be right once.
    Don’t worry about WA; you only have to be ACCEPTED once ><
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class wordsearch {
	static Scanner sc1 = new Scanner(System.in);
	static PrintWriter out;
	static FastReader sc = new FastReader();
	final static int MOD = 1000000007;

	public static void main(String[] args) throws Exception {
		out = new PrintWriter(System.out);
		int t = 1;
		t = sc.nextInt();
		while (t-- > 0) {
			solve();
		}
		out.close();
	}

	public static void solve() {
		String s = sc.nextLine();
		String reversed = new StringBuilder(s).reverse().toString();
		int r = sc.nextInt(), c = sc.nextInt();
		char[][] grid = new char[r][c];
		for(int i =0; i < r; i++) {
			grid[i] = sc.nextLine().toCharArray();
		}
		int len = s.length();
		boolean horizontal = false, vertical = false;
		int index = 0, endIndex = 0, dimension = 0;
		for(int i =0; i < r;i++) {
			String row = new String(grid[i]);
			index = Math.max(row.indexOf(s),row.indexOf(reversed));
			if(index >= 0) {
				endIndex = index + len;
				horizontal = true;
				dimension = i;
				break;
			}
		}
		if(horizontal) {
			for(int i =0; i < r;i++) {
				for(int j =0;j < c;j++) {
					if(j >= index && j < endIndex && i == dimension) {
						out.print(grid[i][j]);
					}
					else out.print("#");
				}
				out.println();
			}
		}
		for(int j =0; j < c;j++) {
			String word = "";
			for(int i =0;i < r;i++) {
				word += grid[i][j];
			}
			index = Math.max(word.indexOf(s),word.indexOf(reversed));
			if(index >= 0) {
				endIndex = index + len;
				 vertical = true;
				dimension = j;
				break;
			}
		}
		if(vertical) {
			for(int i =0; i < r;i++) {
				for(int j =0;j < c;j++) {
					if(i >= index && i < endIndex && j == dimension) {
						out.print(grid[i][j]);
					}
					else out.print("#");
				}
				out.println();
			}
		}
//		for(char[] arr : grid) {
//			for(char c1 : arr) {
//				out.print(c1);
//			}
//			out.println();
//		}
		sc.nextLine();
		out.println();
	}

	public static long[] readArray(int n) {
		long[] ret = new long[n];
		for (int i = 0; i < n; i++) {
			ret[i] = sc.nextLong();
		}
		return ret;
	}

	public static int[] readIntArray(int n) {
		int[] ret = new int[n];
		for (int i = 0; i < n; i++) {
			ret[i] = sc.nextInt();
		}
		return ret;
	}

	public static int[][] readMatrix(int row, int col, Scanner s) {
		int[][] ans = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ans[i][j] = sc.nextInt();
			}
		}
		return ans;
	}

	public static int digitsCount(int N) {
		return (int) Math.floor(Math.log10(N)) + 1;
	}

	public static void sort(int[] arr) {
		// because Arraysc.sort() uses quicksort which is dumb
		// Collectionsc.sort() uses merge sort
		ArrayList<Integer> ls = new ArrayList<Integer>();
		for (int x : arr)
			ls.add(x);
		Collections.sort(ls);
		for (int i = 0; i < arr.length; i++)
			arr[i] = ls.get(i);
	}

	public static long power(long x, long y, long p) {
		// 0^0 = 1
		long res = 1L;
		x = x % p;
		while (y > 0) {
			if ((y & 1) == 1)
				res = (res * x) % p;
			y >>= 1;
			x = (x * x) % p;
		}
		return res;
	}

	public static boolean isPrime(long n) {
		if (n < 2)
			return false;
		if (n == 2 || n == 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		long sqrtN = (long) Math.sqrt(n) + 1;
		for (long i = 6L; i <= sqrtN; i += 6) {
			if (n % (i - 1) == 0 || n % (i + 1) == 0)
				return false;
		}
		return true;
	}

	public static long gcd(long a, long b) {
		if (a > b)
			a = (a + b) - (b = a);
		if (a == 0L)
			return b;
		return gcd(b % a, a);
	}

	static class Pair {
		int first;
		int second;

		public Pair(int f, int s) {
			first = f;
			second = s;
		}
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}