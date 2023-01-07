import java.util.*;
import java.io.*;
import java.math.*;

public class test {
	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		//      out = new PrintWriter("src/output.txt");
		//		sc = new FastScanner("src/input.txt", "src/output.txt");
		sc = new FastScanner();
		int cases = 1;
		cases = sc.nextInt();
		while (cases-- > 0)
			solve();
	}

	public static void solve() {
		int N = sc.nextInt();
		if(N == 3) {
			System.out.println("NO");
			return;
		} else {
			System.out.println("YES");
			boolean pos = true;
			StringJoiner j = new StringJoiner(" ");
				if (N % 2 == 0) {
				for(int i = 0; i < N; i++) {
					if(pos) {
						j.add(250 + "");
					}else {
						j.add((-1) * 250 + "");
					}
					pos = !pos;
				}
			}else {
				int val = N/2;
				pos = false;
				for(int i = 0; i < N; i++) {
					if(pos) {
						j.add(val + "");
					}else {
						j.add(1 - val + "");
					}
					pos = !pos;
				}
			}
				System.out.println(j);
		}
		
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