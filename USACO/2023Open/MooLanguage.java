import java.io.IOException;
import java.util.*;
import java.io.*;

public class MooLanguage {

	public static void main(String[] nutz) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken()),
					p = Integer.parseInt(st.nextToken());
			List<String> nouns = new ArrayList<>(), trans = new ArrayList<>(), conj = new ArrayList<>(),
					intrans = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String word = st.nextToken(), identifier = st.nextToken();
				if (identifier.equals("noun"))
					nouns.add(word);
				else if (identifier.equals("transitive-verb"))
					trans.add(word);
				else if (identifier.equals("intransitive-verb"))
					intrans.add(word);
				else
					conj.add(word);
			}
			int[] arr = { nouns.size(), trans.size(), conj.size(), intrans.size() };

		}
		out.close();
	}

	/*
	 * If F/S on ends, +-1 possibles of F span (0, n-1) all possible sums of an
	 * array
	 */

}