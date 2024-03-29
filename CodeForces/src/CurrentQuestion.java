import java.util.*;
import java.io.*;
import java.math.*;

public class CurrentQuestion extends PrintWriter {
	CurrentQuestion() {
		super(System.out);
	}

	FastScanner sc = new FastScanner();

	public static void main(String[] nutz) throws IOException {
		CurrentQuestion o = new CurrentQuestion();
		o.main();
		o.flush();

	}

	void main() {
		for (int t = 1; t-- > 0;) {
			int N = sc.nextInt();
			int[] x = new int[N], y = new int[N];
			for(int i = 0; i < N ; i++) x[i] = sc.nextInt();
			for(int i = 0; i < N ; i++) y[i] = sc.nextInt();
			int max = 0;
			for(int i =0 ; i < N -1 ; i++) {
				for(int j = 0; j < N -1; j++) {
					max = Math.max(max,  getDistance2(x[i], y[i], x[j+1], y[j+1]));
				}
			}
			println(max);
			
		}
	}
	public static int getDistance2(int x, int y, int x2, int y2) {
		return (int)(Math.pow(x - x2,2) + Math.pow(y - y2, 2));
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