import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t =Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int number = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    int key = number == 1 ? map.lastKey() : map.firstKey();
                    int count = map.get(key);

                    if (count == 1) map.remove(key);
                    else map.put(key, count - 1);
                }
            }

            if (map.isEmpty()) sb.append("EMPTY\n");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
        }

        System.out.println(sb);
    }
}