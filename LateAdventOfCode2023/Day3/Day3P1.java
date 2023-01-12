
import java.util.*;
import java.io.*;
import java.math.*;

public class Day3P1{
	public static int[] maxes;
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day3/input.txt"));
//		sc = new Scanner("hzJzGjGfqmGtDQtDSvVV");
		//Part 1
		/*
		 *
		 */
		long sum = 0l;
		while(sc.hasNext()) {
			String s =  sc.next();
			int[] arr= new int[53];
			for(int i = 0 ; i < s.length()/2 ;i++) {
				char c = s.charAt(i);
				if(Character.isUpperCase(c)) {
					arr[c-'A'+27]++;
				}else arr[c-'a'+1]++;
			}
			for(int i = s.length()/2; i < s.length(); i++) {
				char c = s.charAt(i);
				if(Character.isUpperCase(c)) {
					int index = c - 'A' + 27;
					if(arr[index] != 0) {
						sum += index;
//						System.out.println(c);
						break;
					}
				}else {
					int index = c - 'a' + 1;
					if(arr[index] != 0) {
						sum += index;
//						System.out.println(c);
						break;
					}
				}
			}
		}
		System.out.println(sum);
	}
}