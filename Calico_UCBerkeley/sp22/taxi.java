import java.util.*;
import java.io.*;
import java.math.*;

public class taxi {
	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);// "src/output.txt");
		// sc = new FastScanner("src/input.txt", "src/output.txt");
		sc = new FastScanner();
		int cases = 1;
		cases = sc.nextInt();
		while (cases-- > 0)
			solve();
		out.close();
	}

	public static void solve() {
		String city = sc.next();
		int n = sc.nextInt();
		long time = 0;
		out.println(city + ":");
		car[] cars = new car[n];
		for (int i = 0; i < n; i++) {
			cars[i] = new car(sc.next(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(cars);
		for (int i = 0; i < n - 1; i++) {
			car one = cars[i], two = cars[i + 1];
			long oldTime = time;
			time = Math.round((one.flat - two.flat) / (two.cpm - one.cpm));
			out.println(oldTime + "-" + time + ": " + one.name);
			time++;
		}
		out.println(time + "+: " + cars[n - 1].name);

	}

	static class car implements Comparable<car> {
		int flat;
		int cpm;
		String name;

		public car(String name, int flat, int cpm) {
			this.flat = flat;
			this.cpm = cpm;
			this.name = name;
		}

		public int compareTo(car o) {
			int index = Integer.compare(flat, o.flat);
			if (index != 0)
				index = Integer.compare(cpm, o.cpm);
			return index;
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