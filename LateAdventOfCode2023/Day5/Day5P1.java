
import java.util.*;
import java.io.*;
import java.math.*;

public class Day5P1{
	public static int[] maxes;
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day5/input.txt"));
		List<Stack<Character>> list = new ArrayList<>();
		for(int i = 0; i < 9 ; i++)list.add(new Stack<Character>());
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			if(line.isEmpty()) break;
		}
		System.out.println(sc.nextLine());
		while(sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] split = line.split("[\\sa-z\\s]*");
			int[] arr = new int[3];
			int index = 0;
			for(String c : split)
				if(Character.isDigit(c))arr[index++] = Integer.valueOf(c);
//			int[] arr = .mapToInt(Integer::parseInt).toArray();
			System.out.println(Arrays.toString(split));
		}
	}
}