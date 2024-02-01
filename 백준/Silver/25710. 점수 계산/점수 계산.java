import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] arr;
    static int answer = 0;
    public static void plus (int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        answer = Math.max(ans, answer);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] visited = new int[1000];

        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            visited[num]++;
            set.add(num);
        }

        arr = new int[set.size()];
        int idx = 0;
        for (int i : set) {
            arr[idx] = i;
            idx++;
        }

        n = set.size();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int num = arr[i] * arr[j];
                if ((visited[arr[i]] < 2 && i != j) || (visited[arr[i]] > 1)) {
                    plus(num);
                }
            }
        }
        System.out.println(answer);
    }
}