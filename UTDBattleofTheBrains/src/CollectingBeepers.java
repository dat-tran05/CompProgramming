import java.util.*;

public class CollectingBeepers {
	// GRAPH QUESTION -- Shortest Cycle
	static final int N = 100200;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int r = sc.nextInt(), c = sc.nextInt();
			int x = sc.nextInt(), y = sc.nextInt();
			int n = sc.nextInt();
			List<Cord> list = new ArrayList<>();
			list.add(new Cord(x, y));
			for (int i = 0; i < n; i++) {
				list.add(new Cord(sc.nextInt(), sc.nextInt()));
			}
			@SuppressWarnings("unchecked")
			List<Integer>[] gr = new List[N];
			for (int i = 0; i < N; i++)
				gr[i] = new Vector<>();

			int[][] costs = new int[n + 1][n + 1];
			for (int i = 0; i < n + 1; i++) {
				Cord one = list.get(i);
				for (int j = 0; j < n + 1; j++) {
					if (i == j)
						continue;
					Cord two = list.get(j);
					int a = costs[i][j] = dist(one.x, one.y, two.x, two.y);
				}
			}
			printGrid(costs);

		}
	}

	public static void addEdge(List<Integer>[] gr, int x, int y) {
		gr[x].add(y);
		gr[y].add(x);
	}

	public static void printGrid(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int dist(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) + Math.abs(y - y1);
	}
}

class Cord {
	int x;
	int y;

	public Cord(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "X: " + x + " " + "Y: " + y;
	}
}
