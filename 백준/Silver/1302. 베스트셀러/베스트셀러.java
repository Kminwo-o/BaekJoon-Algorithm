import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            map.put(book, map.getOrDefault(book, 0) + 1);
            max = Math.max(max, map.get(book));
        }

        Set<String> set = new TreeSet<>();
        for (String key: map.keySet()) {
            if (map.get(key) == max) {
                set.add(key);
            }
        }

        for (String name : set) {
            System.out.println(name);
            break;
        }
    }
}