import java.util.*;

public class Distracted {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), tc = sc.nextInt();
		Map<Node, List<Node>> map = new HashMap<>();
		Map<String, Node> people = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = sc.next();
			String status = sc.next();
			boolean married = false;
			if (status.equals("m"))
				married = true;
			Node n1 = new Node(name, married);
			if (status.equals("?")) {
				n1.setUnknown();
			}
			map.put(n1, new ArrayList<>());
			people.put(name, n1);
		}
		int count = 0;
		while (tc-- > 0) {
			String from = sc.next();
			sc.next();
			String to = sc.next();
			Node one = people.get(from), two = people.get(to);
			if (one.unknown || two.unknown) {
				System.out.println("?");
				return;
			}
			if (one.m && !two.m)
				count++;
		}
		System.out.println(count > 0 ? 1 : 0);
	}
}

class Node {
	String name;
	boolean m;
	boolean unknown = false;

	public Node(String name, boolean b) {
		this.name = name;
		this.m = b;
	}

	public void setUnknown() {
		unknown = true;
	}
}
