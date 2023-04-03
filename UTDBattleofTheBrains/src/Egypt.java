import java.util.*;

public class Egypt {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0)
				return;
			Arrays.sort(arr);
			boolean valid = false;
			if (arr[0] * arr[0] + arr[1] * arr[1] == arr[2] * arr[2])
				valid = true;
			System.out.println(valid ? "right" : "wrong");
		}
	}
}