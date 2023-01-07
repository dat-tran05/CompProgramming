import java.util.*;
import java.io.*;
import java.math.*;

public class TheHumanoid {
	public static void main(String[] nutz) throws IOException {
		FastScanner sc = new FastScanner();
		int tc = sc.nextInt();
		while(tc--> 0){
			int N = sc.nextInt(), P = sc.nextInt();
			int G = 2, B = 1;
			int[] arr = new int[N];
			int total = 0;
			for(int i =0;i<N;i++)
				arr[i] = sc.nextInt();
			Arrays.sort(arr);
			for(int i =0;i<N;i++) {
				if(P > arr[i]) {
					total++;
					P = P + arr[i]/2;
				}else {
					if(P * 2 > arr[i]) {
						total++;
						P *=2;
						G--;
					}else if(P*3 > arr[i]) {
						
					}
				}
			}
		}
	}
}

//class FastScanner extends PrintWriter {
//	private InputStream stream;
//	private byte[] buf = new byte[1 << 16];
//	private int curChar, numChars;
//
//	// standard input
//	public FastScanner() {
//		this(System.in, System.out);
//	}
//
//	public FastScanner(InputStream i, OutputStream o) {
//		super(o);
//		stream = i;
//	}
//
//	// file input
//	public FastScanner(String i, String o) throws IOException {
//		super(new FileWriter(o));
//		stream = new FileInputStream(i);
//	}
//
//	// throws InputMismatchException() if previously detected end of file
//	private int nextByte() {
//		if (numChars == -1)
//			throw new InputMismatchException();
//		if (curChar >= numChars) {
//			curChar = 0;
//			try {
//				numChars = stream.read(buf);
//			} catch (IOException e) {
//				throw new InputMismatchException();
//			}
//			if (numChars == -1)
//				return -1; // end of file
//		}
//		return buf[curChar++];
//	}
//
//	// to read in entire lines, replace c <= ' '
//	// with a function that checks whether c is a line break
//	public String next() {
//		int c;
//		do {
//			c = nextByte();
//		} while (c <= ' ');
//		StringBuilder res = new StringBuilder();
//		do {
//			res.appendCodePoint(c);
//			c = nextByte();
//		} while (c > ' ');
//		return res.toString();
//	}
//
//	public String nextLine() {
//		int c;
//		do {
//			c = nextByte();
//		} while (c < '\n');
//		StringBuilder res = new StringBuilder();
//		do {
//			res.appendCodePoint(c);
//			c = nextByte();
//		} while (c > '\n');
//		return res.toString();
//	}
//
//	public int nextInt() {
//		int c;
//		do {
//			c = nextByte();
//		} while (c <= ' ');
//		int sgn = 1;
//		if (c == '-') {
//			sgn = -1;
//			c = nextByte();
//		}
//		int res = 0;
//		do {
//			if (c < '0' || c > '9')
//				throw new InputMismatchException();
//			res = 10 * res + c - '0';
//			c = nextByte();
//		} while (c > ' ');
//		return res * sgn;
//	}
//
//	public long nextLong() {
//		int c;
//		do {
//			c = nextByte();
//		} while (c <= ' ');
//		int sgn = 1;
//		if (c == '-') {
//			sgn = -1;
//			c = nextByte();
//		}
//		long res = 0;
//		do {
//			if (c < '0' || c > '9')
//				throw new InputMismatchException();
//			res = 10 * res + c - '0';
//			c = nextByte();
//		} while (c > ' ');
//		return res * sgn;
//	}
//
//	public double nextDouble() {
//		return Double.parseDouble(next());
//	}
//}