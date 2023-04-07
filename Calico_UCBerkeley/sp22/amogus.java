/*
    Somewhere, something incredible is waiting to be known
    Don’t worry about failure; you only have to be right once.
    Don’t worry about WA; you only have to be ACCEPTED once ><
*/
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class amogus {
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
		int n = sc.nextInt();
		int[] arr = new int[n+2];
		for(int i =0 ; i<n;i++) {
			int a = sc.nextInt() - 1;
			arr[a]++;
		}
		Sus[] sussies = new Sus[2], civ = new Sus[n];
		int ii =0, j = 0;;
		for(int i = 0; i < n+2;i++) {
			if(i >= n) sussies[ii++] = new Sus(i, arr[i], true);
			else civ[j++] = new Sus(i,arr[i], false);
		}
		Arrays.sort(sussies);
		Arrays.sort(civ);
		Sus one = sussies[0], two = civ[0];
		for(int i = 1; i < n;i++) {
			if(two.votes == civ[i].votes)
				two = civ[i];
		}
		if(one.votes > two.votes) {
			if(one.votes > two.votes + 2) {
				out.println("SKIP SKIP");
			}else {
				out.println((two.index+1) + " " + (two.index+1));
			}
		}else if(one.votes == two.votes){
			out.println((two.index+1) + " SKIP");
		}else {
			out.println((civ[n-1].index+1+"") +" " + (civ[n-1].index+1+""));
		}
		
		sc.nextLine();
	}
	static class Sus implements Comparable<Sus>{
		int votes;
		int index;
		boolean sus;
		public Sus(int index, int votes, boolean sus) {
			this.index = index;
			this.votes = votes;
			this.sus= sus;
		}
		public int compareTo(Sus o) {
			int index = Integer.compare(o.votes, this.votes);
			if(index == 0) {
				index = Integer.compare(o.index, this.index);
			}
			return index;
		}
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