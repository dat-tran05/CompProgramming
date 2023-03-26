
import java.util.*;
import java.io.*;
import java.math.*;

public class Part1{
	public static int[] maxes;
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day1/Day1.txt"));
		//Part 1
		long max = 0, curr =0 ;
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			if(s.isEmpty()) {
				max = Math.max(curr, max);
				curr =0 ;
			}else {
				curr+= Integer.parseInt(s);
			}
		}
		System.out.println(max);
		
	}
}