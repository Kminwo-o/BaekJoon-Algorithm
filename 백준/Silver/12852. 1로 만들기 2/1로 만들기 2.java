import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        
        if (N == 2) {
            System.out.println(1);
            System.out.println(2 + " " + 1);
            return;
        }

        int[] dp = new int[N+1];
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            int n1 = dp[i-1];
            int n2 = Integer.MAX_VALUE;
            int n3 = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                n2 = dp[i / 2];
            }
            if (i % 3 == 0) {
                n3 = dp[i / 3];
            }

            dp[i] = Math.min(Math.min(n1, n2), n3) + 1;
        }

        System.out.println(dp[N]);

        int min;
        StringBuilder sb = new StringBuilder();
        while (N > 1) {
            sb.append(N).append(" ");
            int n1 = dp[N-1];
            int n2 = Integer.MAX_VALUE;
            int n3 = Integer.MAX_VALUE;

            if (N % 2 == 0) {
                n2 = dp[N / 2];
            }

            if (N % 3 == 0) {
                n3 = dp[N / 3];
            }

            min = Math.min(Math.min(n1, n2), n3);

            if (dp[N - 1] == min) {
                N = N - 1;
            } else if (n2 != Integer.MAX_VALUE && n2 == min) {
                N = N / 2;
            } else if (n3 != Integer.MAX_VALUE && n3 == min) {
                N = N / 3;
            }
        }

        sb.append(N);
        System.out.println(sb);
    }
}