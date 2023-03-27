import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class gymnastics {
	static FastScanner sc;

	public static void main(String[] nutz) throws IOException {
		sc = new FastScanner("gymnastics.in", "gymnastics.out");
//		sc = new FastScanner();
		int cases = 1;
//		cases = sc.nextInt();
		while (cases-- > 0)
			solve();
		sc.close();
	}

	public static void solve() {
		int K = sc.nextInt(), N = sc.nextInt();
		int[][] grid = new int[10][20];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt() - 1;
			}
		}
		int[][] pairs = new int[20][20];
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < N; j++) {
				int curr = grid[i][j];
				for (int k = j + 1; k < N; k++) {
					pairs[curr][grid[i][k]]++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (pairs[i][j] == K)
					count++;
			}
		}
		sc.println(count);
//		int pairs = (N - 1) * N / 2;
//		int[] arr = new int[N + 1];
//		for (int i = 0; i < N; i++) {
//			arr[sc.nextInt()] = N - 1 - i;
//		}
//		if (K == 1)
//			sc.println(pairs);
//		else {
//			for (int i = 1; i < K; i++) {
//				int a = sc.nextInt();
//				arr[a] = Math.min(N - 1 - i, arr[a]);
//			}
//		}
//		sc.println(Arrays.stream(arr).sum());
	}

	static class FastScanner extends PrintWriter {
		private InputStream stream;
		private byte[] buf = new byte[1 << 16];
		private int curChar, numChars;

		// standard input
		public FastScanner() {
			this(System.in, System.out);
		}

		public FastScanner(InputStream i, OutputStream o) {
			super(o);
			stream = i;
		}

		// file input
		public FastScanner(String i, String o) throws IOException {
			super(new FileWriter(o));
			stream = new FileInputStream(i);
		}

		// throws InputMismatchException() if previously detected end of file
		private int nextByte() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars == -1)
					return -1; // end of file
			}
			return buf[curChar++];
		}

		// to read in entire lines, replace c <= ' '
		// with a function that checks whether c is a line break
		public String next() {
			int c;
			do {
				c = nextByte();
			} while (c <= ' ');
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = nextByte();
			} while (c > ' ');
			return res.toString();
		}

		public String nextLine() {
			int c;
			do {
				c = nextByte();
			} while (c < '\n');
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = nextByte();
			} while (c > '\n');
			return res.toString();
		}

		public int nextInt() {
			int c;
			do {
				c = nextByte();
			} while (c <= ' ');
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = 10 * res + c - '0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}

		public long nextLong() {
			int c;
			do {
				c = nextByte();
			} while (c <= ' ');
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = nextByte();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res = 10 * res + c - '0';
				c = nextByte();
			} while (c > ' ');
			return res * sgn;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}