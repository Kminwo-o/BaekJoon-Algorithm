import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+2];
        int[] P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] best_money = new int[N+2];
        int max = 0;

        for (int i = 1; i < N+2; i++) {
            if (max < best_money[i]) {
                max = best_money[i];
            }

            int day = i + T[i];
            if (day < N + 2) {
                best_money[day] = Math.max(best_money[day], max + P[i]);
            }
        }
        System.out.println(max);

    }
}