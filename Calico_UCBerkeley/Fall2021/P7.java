import java.util.*;
import java.io.*;
import java.math.*;

public class P7 {
	static Scanner sc;
	static PrintWriter out;

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] nutz) throws IOException {
		out = new PrintWriter(System.out);
		sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();
		while (tc-- > 0) {
			String[] line = sc.nextLine().split("x");
			int r = Integer.parseInt(line[0]), c = Integer.parseInt(line[1]);
			List<Pair> diagonals = new ArrayList<>();
			List<Integer> xs = new ArrayList<>(), ys = new ArrayList<>();
			boolean[][] grid = new boolean[r][c];
			int numQueens = 0;
			for (int i = 0; i < r; i++) {
				String row = sc.nextLine();
				for (int j = 0; j < c; j++) {
					char spot = row.charAt(j);
					if (spot == 'Q') {
						if (!xs.contains(i))
							xs.add(i);
						if (!ys.contains(j))
							ys.add(j);
						if (diagonals.isEmpty())
							diagonals.add(new Pair(i, j));
						else {
							for (Pair p : diagonals) {
							int x = p.x, y = p.y;
							if (Math.abs(x - i) != Math.abs(y - j)) {
								diagonals.add(new Pair(i, j));
								break;
							}
						}
					}

						grid[i][j] = true;
						numQueens++;
					}
				}
			}
			for (int x : xs) {
				for (int i = 0; i < c; i++) {
					grid[x][i] = true;
				}
			}
			for (int y : ys) {
				for (int i = 0; i < r; i++) {
					grid[i][y] = true;
				}
			}
			for (Pair p : diagonals) {
				int x = p.x, y = p.y;
				long max = Math.max(Math.max(x, y), Math.max(r - x, c - y));

				for (int i = 1; i < max; i++) {
					if (validSpot(x + i, y + i, grid)) {
						grid[x + i][y + i] = true;
					}
					if (validSpot(x + i, y - i, grid)) {
						grid[x + i][y - i] = true;
					}
					if (validSpot(x - i, y + i, grid)) {
						grid[x - i][y + i] = true;
					}
					if (validSpot(x - i, y - i, grid)) {
						grid[x - i][y - i] = true;
					}

					/*
					 * x + i, y + i x + i, y - i x - i, y + i x - i, y - i
					 */
				}
				// Diagonals :/

			}
			// find queens and set board
			// T where king can't move
//			printGrid(grid);
			sc.nextLine();
			out.println(numCheckMates(grid) - numQueens);
		}

		sc.close();
		out.close();
	}

	public static boolean validSpot(int r1, int c1, boolean[][] grid) {
		return r1 >= 0 && r1 < grid.length && c1 >= 0 && c1 < grid[r1].length;
	}

	public static void printGrid(boolean[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				out.print(grid[i][j] + " ");
			}
			out.println();
		}
	}

	public static int numCheckMates(boolean[][] grid) {
		int count = 0;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[r].length; c++) {
				boolean canMove = false;
				checking:
				for (int i = -1; i <= 1; i++) {
					for (int j = -1; j <= 1; j++) {
						int r1 = r + i, c1 = c + j;
						if (validSpot(r1, c1, grid)) {
							if (!grid[r1][c1]) {
								canMove = true;
								break checking;
							}
						}
					}

				}
				count += canMove ? 0 : 1;
			}
		}
		return count;
	}
}

/*
7
3x4
----
Q---
----

4x4
Q-Q-
-QQ-
----
----

1x3
---

2x1
Q
-

4x4
-Q--
----
----
----

5x5
-----
-----
--Q--
-----
-----

5x8
--------
--------
--Q--Q--
--------
-------- 


*/