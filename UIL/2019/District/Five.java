import java.util.*;
import java.io.*;
import java.math.*;

public class Five {
	static Scanner sc;
	static PrintWriter out;
	static BufferedReader br;

	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(new BufferedReader(new FileReader("2019/District/Five.dat")));
		br = new BufferedReader(new FileReader("2019/District/Five.dat"));
		
		/*
		 * TDL
		 * <=8 letters >= 5
		 * no ph
		 * no c,m , o y
		 * first letter < a + 13
		 */
		TreeSet<String> set = new TreeSet<>();
		int N = sc.nextInt();
		while(N-- > 0) {
			String s = sc.next();
			if(valid(s)) set.add(s);
		}
		for(String s : set)
			out.println(s);
		sc.close();
		br.close();
		out.close();
	}
	static boolean valid(String s) {
		s = s.toLowerCase();
		int l = s.length();
		if(l < 5 || l > 8) return false;
		Set<Integer> set = new HashSet<>();
		set.add(s.indexOf("ph"));
		set.add(s.indexOf("c"));
		set.add(s.indexOf("m"));
		set.add(s.indexOf("o"));
		set.add(s.indexOf("y"));
		if(set.size() > 1)return false;
		char c = s.charAt(0);
		if(c < 'a' + 13) return true;
		else return false;
	}
}