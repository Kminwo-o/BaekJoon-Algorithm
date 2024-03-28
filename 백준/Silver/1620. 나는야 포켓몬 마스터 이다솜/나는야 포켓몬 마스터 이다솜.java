import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameMap = new HashMap<>();
        Map<Integer, String> numberMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String pocketMonster = br.readLine();
            nameMap.put(pocketMonster, i);
            numberMap.put(i, pocketMonster);
        }

        for (int i = 0; i < m; i++) {
            String findKey = br.readLine();
            if (nameMap.containsKey(findKey)) {
                System.out.println(nameMap.get(findKey));
                continue;
            } else {
                System.out.println(numberMap.get(Integer.parseInt(findKey)));
            }
        }
    }
}