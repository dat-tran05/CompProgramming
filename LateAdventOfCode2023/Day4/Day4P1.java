
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.math.*;

public class Day4P1{
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day4/input.txt"));
		int sum = 0;
		while(sc.hasNextLine()) {
			String line  =sc.nextLine().trim();
			String[] pair = line.split(",");
			System.out.println(Arrays.toString(pair));
			String[] one = pair[0].split("-");
			String[] two = pair[1].split("-");
			int one1 = Integer.parseInt(one[0]), one2 = Integer.parseInt(one[1]);
			int two1 = Integer.parseInt(two[0]), two2 = Integer.parseInt(two[1]);
			System.out.println(Arrays.toString(one) + "  " + Arrays.toString(two));
			if((one1 <= two1 && one2>= two2) || (two1 <= one1 && two2 >= one2))
					sum++;
		}
		System.out.println(sum);
//		
	}
}