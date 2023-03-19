import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class F {
	static FastScanner sc;
	static PrintWriter out;
	static int[] pow;

	public static void main(String[] nutz) throws IOException {
		// out = new PrintWriter("src/output.txt");
		// sc = new FastScanner("src/input.txt", "src/output.txt");
//		pow = new int[(int) Math.pow(10, 9)];
//		for (int i = 0; i < pow.length; i++) {
//			String s = i + "";
//			int length = s.length() - 1;
//			if (i < 10)
//				pow[i] = i;
//			else {
//				int f = Integer.parseInt(s.substring(0, length));
//				int ri = Integer.parseInt(s.substring(length));
//				pow[i] = pow[f] + ri;
//			}
//		}
		sc = new FastScanner();
		int cases = 1;
		cases = sc.nextInt();
		while (cases-- > 0)
			solve();
	}

	public static void solve() {
		int n = sc.nextInt(), q = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		while (q-- > 0) {
			int type = sc.nextInt();
			if (type == 1) {
				int l = sc.nextInt(), r = sc.nextInt();
				for (int i = l - 1; i < r; i++) {
					if (arr[i] < 10)
						continue;
					arr[i] = digitSum(arr[i]);
				}
			} else {
				int x = sc.nextInt();
				System.out.println(arr[x - 1]);
			}
		}
	}

	public static int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
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