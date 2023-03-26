
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;

public class Day3P2{
	public static int[] maxes;
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day3/input.txt"));
//		sc = new Scanner("hzJzGjGfqmGtDQtDSvVV");
		//Part 1
		/*
		 *
		 */
		long sum = 0l;
		while(sc.hasNextLine()) {
			
//			String s =  sc.next();
			ArrayList<String> first = new ArrayList<>();
			ArrayList<String> second = new ArrayList<>();
			ArrayList<String> third = new ArrayList<>();
			first.addAll(Arrays.asList(sc.nextLine().split("")));
			second.addAll(Arrays.asList(sc.nextLine().split("")));
			third.addAll(Arrays.asList(sc.nextLine().split("")));
			Set<String> commons = new HashSet<>();
			for(String sa : first) {
				if(second.contains(sa) && third.contains(sa))
					commons.add(sa);
			}
			for(String sa : commons) {
				char c = sa.charAt(0);
				if(Character.isUpperCase(c)) {
					sum += c - 'A' + 27;
				}else {
					sum += c - 'a' + 1;
				}
			}
			
			
		}
		System.out.println(sum);
	}
}