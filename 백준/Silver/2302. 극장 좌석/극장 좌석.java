import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 최대 크기 40
        int[] dp = new int[41];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // 3개 연속인 경우 3, 4개 연속인 경우 5, 5개 연속인 경우 8개의 경우가 나옴.
        // i = (i - 1) + (i - 2)로 점화식 가능
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // vip 마다 크기를 컷 해줘야한다.
        int answer = 1;
        int beforeVip = 0;
        for (int i = 0; i < m; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= dp[vip - beforeVip - 1];
            beforeVip = vip;
        }

        answer *= dp[n - beforeVip];

        System.out.println(answer);
    }
}