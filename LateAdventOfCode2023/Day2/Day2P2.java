
import java.util.*;
import java.io.*;
import java.math.*;

public class Day2P2{
	public static int[] maxes;
	public static void main(String[] nutz) throws IOException {
		Scanner sc = new Scanner(new File("Day2/input.txt"));
		//Part 1
		/*
		 * Rock A X(lose)  1
		 * Paper B Y(draw)  2
		 * Scissors C Z(win)  3
		 * W = 6
		 * T = 3
		 * L = 0
		 */
		long score = 0l;
		while(sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			char you = line[1].charAt(0);
			if(line[0].equals("A")) {
				if(you == 'X') {
					score += 3;
				}else if(you == 'Y') {
					score += 4;
				}else {
					score += 8;
				}
			}else if(line[0].equals("B")) {
				if(you == 'X') {
					score += 1;
				}else if(you == 'Y') {
					score += 5;
				}else {
					score += 9;
				}
			}else {
				if(you == 'X') {
					score += 2;
				}else if(you == 'Y') {
					score += 6;
				}else {
					score += 7;
				}
			}
			
		}
		System.out.println(score);
		
	}
}