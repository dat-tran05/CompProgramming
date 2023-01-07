import java.util.*;
import java.io.*;

public class Two {
    public static void main(String[] args) throws Throwable {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "January");
        map.put(2, "February");
        map.put(3, "March");
        map.put(4, "April");
        map.put(5, "May");
        map.put(6, "June");
        map.put(7, "July");
        map.put(8, "August");
        map.put(9, "September");
        map.put(10, "October");
        map.put(11, "November");
        map.put(12, "December");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().map(Integer::parseInt).forEach(n -> {
            System.out.println(map.get(n));
        });
    }
}
