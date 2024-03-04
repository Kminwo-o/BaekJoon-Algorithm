import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coin {
        int value;
        int quantity;

        public Coin(int value, int quantity) {
            this.value = value;
            this.quantity = quantity;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            Coin[] coins = new Coin[n+1];
            boolean[] dp = new boolean[100001];

            int total = 0;
            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int quantity = Integer.parseInt(st.nextToken());
                coins[j] = new Coin(value, quantity);
                total += value * quantity;

                for (int k = 1; k <= quantity; k++) {
                    dp[value * k] = true;
                }
            }

            if (total % 2 != 0) {
                System.out.println(0);
                continue;
            } else if (dp[total / 2]) {
                System.out.println(1);
                continue;
            }

            dp[0] = true;
            for (int j = 1; j <= n; j++) {
                int value = coins[j].value;
                int quantity = coins[j].quantity;

                for (int k = total/2; k >= value; k--) {
                    if (dp[k - value]) {
                        for (int l = 1; l <= quantity ; l++) {
                            if (k - value + value * l > total/2) break;
                            dp[k - value + value * l] = true;
                        }
                    }
                }
            }

            System.out.println(dp[total / 2] ? 1 : 0);
        }
    }
}