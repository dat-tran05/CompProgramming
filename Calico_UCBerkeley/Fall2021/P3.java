import java.util.*;
import java.io.*;
import java.math.*;

public class P3 {
	static Scanner sc;
	static PrintWriter out;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();
		while (tc-- > 0) {
			String[] in = sc.nextLine().split(" ");
			String name = in[0];
			int n = Integer.parseInt(in[1]);
			List<String> ppl = new ArrayList<>();
			List<String> books = new ArrayList<>();
			ppl.add(name);
			for (int i = 0; i < n; i++) {
				String[] line = sc.nextLine().split(" ");
				String person = line[0];
				String book = line[3];
				book = book.substring(0, book.indexOf("'"));
				ppl.add(person);
				books.add(book);
			}
			ppl.removeAll(books);
			out.println(name + " HAS " + ppl.get(0) + "'s BOOK");
			sc.nextLine();
		}

		sc.close();
		out.close();
	}
}
/*
3
David 1
Alexa TURNS IN David's BOOK

Javid 5
Preston TURNS IN Walter's BOOK
Jon TURNS IN Quincy's BOOK
Walter TURNS IN Javid's BOOK
Quincy TURNS IN Jon's BOOK
Gary TURNS IN Gary's BOOK

Susan 2
Abcde TURNS IN Felicia's BOOK
Felicia TURNS IN Abcde's BOOK

*/