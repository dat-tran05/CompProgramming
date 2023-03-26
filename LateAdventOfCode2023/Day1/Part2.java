
import java.util.*;
import java.io.*;
import java.math.*;

public class Part2 {
	public static int[] maxes;
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day1/Day1.txt"));
		long curr =0;
		maxes = new int[3]; //store 3 big values
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if(s.isEmpty()) {
				updateValue(curr);
				curr =0 ;
			}else {
				curr+= Integer.parseInt(s);
			}
		}
		int sum = 0;
		for(int i : maxes) sum += i;
		System.out.println(sum);
		
	}
	static void updateValue(long sum) {
		Arrays.sort(maxes);
		if(sum > maxes[0])
			maxes[0] = (int)sum;
	}
}