import java.util.*;
import java.io.*;
import java.math.*;

public class outofplace {
	static FastScanner sc;

	public static void main(String[] nutz) throws IOException {
		sc = new FastScanner("outofplace.in", "outofplace.out");
//		sc = new FastScanner();
		int cases = 1;
//		cases = sc.nextInt();
		while (cases-- > 0)
			solve();
		sc.close();
	}

	public static void solve() {
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] sorted = new int[n];
		for(int i= 0; i < n;i++) {
			int a = arr[i] = sc.nextInt();
			sorted[i] = a;
		}
		Arrays.sort(sorted);
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != sorted[i])
				count++;
		}

//		if (!left) {
//			for (int i = start + 1; i < n; i++) {
//				if (arr[i] == sorted[start]) {
//					end = i;
//					break;
//				}
//			}
//		} else {
//			end = arr[start] - 1;
//		}

		sc.println(count - 1);
		
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