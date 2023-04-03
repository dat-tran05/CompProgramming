import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class Triangles {
	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
//		out = new PrintWriter(System.out);
		sc = new FastScanner("triangles.in", "triangles.out");
//		sc = new FastScanner();
		int cases = 1;
//		cases = sc.nextInt();
		while (cases-- > 0)
			solve();
		sc.close();
//		out.close();
	}

	/*
	 * 
	 * 3 3 40 75 50 35 10 45 40 75 20 30 40 30
	 */
	public static void solve() {
		int points = sc.nextInt();
		List<Point> list = new ArrayList<>();
		for(int i =0 ;i < points; i++) {
			list.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		int area = 0;
		for(int i =0; i < points; i++) {
			for(int j =0; j < points;j++) {
				for(int k = 0; k < points; k++) {
					Point one = list.get(i), two = list.get(j), three = list.get(k);
					/*
					 * top is k
					 * bot left is i
					 * bot right is j
					 */
					if(one.x == three.x && one.y == two.y) {
						int temp = (two.x - one.x) * (three.y - one.y);
						area = Math.max(area, Math.abs(temp));
					}
				}
			}
		}
		sc.println(area);
	}
	static class Point{
		int x; int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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