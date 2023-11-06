import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 0;
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            boolean word = true;
            String s = str[i];
            HashSet<Character> characters = new HashSet<>();
            characters.add(s.charAt(0));

            for (int j = 1; j < s.length(); j++) {
                if (characters.contains(s.charAt(j))) {
                    if (s.charAt(j-1) != s.charAt(j)) {
                        word = false;
                        break;
                    }
                }
                characters.add(s.charAt(j));
            }
            if (word) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}