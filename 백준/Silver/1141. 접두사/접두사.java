import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (String s1, String s2) -> s2.length() - s1.length());

        HashSet<String> set = new HashSet<>();
        for (String str1 : arr) {
            if (set.size() == 0) {
                set.add(str1);
                continue;
            }

            boolean valid = true;
            for (String str2 : set) {
                if (str2.indexOf(str1) == 0) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                set.add(str1);
            }
        }
        System.out.println(set.size());
    }
}