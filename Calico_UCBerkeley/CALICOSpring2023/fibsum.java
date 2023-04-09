
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class fibsum {
	static Scanner sc1 = new Scanner(System.in);
	static PrintWriter out;
	static FastReader sc = new FastReader();
	final static int MOD = 998244353;
	static long fib[] = new long[100002];
	public static void main(String[] args) throws Exception {
		fib[0] = 1;
		fib[1] = 1;
		for (int i = 2; i < fib.length; i++) {
			fib[i] = (fib[i - 1] + fib[i - 2]) % (998244353);
		}
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
		int quer = sc.nextInt();
		long[] fibs = new long[n+1];

		for(int i = 0; i < quer; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			for(int j = n1; j <= n2; j++) {
				fibs[j] = (fibs[j] + fib[j - n1] % (998244353)) % (998244353);
			}
			
		}
		String s = "";
		for(int i = 1; i < n+1; i++) {
			s += fibs[i] % MOD + " ";
		}
		System.out.println(s.trim());
		
	}

	static class depression {
		int n1;
		int n2;
		int freq;

		public depression(int n1, int n2) {
			this.n1 = n1;
			this.n2 = n2;
			this.freq = 0;
		}
	}
	public static int fib(int n)
    {
        int a = 1, b = 1, c;
        if (n == 1)
            return a;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
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
