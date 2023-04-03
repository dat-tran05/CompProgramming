import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class guessTheAnimalName{
	static FastScanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
//		out = new PrintWriter(System.out);
		sc = new FastScanner("guess.in", "guess.out");
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
		int n = sc.nextInt();
		List<List<String>> list = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			sc.next();
			sc.next();
			String[] arr = sc.nextLine().trim().split(" ");
			list.add(Arrays.asList(arr));
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j =0;j < n;j++) {
				if(i == j) continue;
				List<String> temp = list.get(i), temp2 = list.get(j);
				int count = 0;
				for(String s : temp) {
					if(temp2.contains(s)) count++;
				}
				max = Math.max(count, max);
			}
		}
		sc.println(max + 1);
		
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