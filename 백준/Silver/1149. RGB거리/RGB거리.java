import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static final int red = 0;
    static final int green = 1;
    static final int blue = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] cost = new int[n][3];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cost[i][red] = Integer.parseInt(st.nextToken());
            cost[i][green] = Integer.parseInt(st.nextToken());
            cost[i][blue] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            cost[i][red] += Math.min(cost[i - 1][green], cost[i - 1][blue]);
            cost[i][green] += Math.min(cost[i - 1][red], cost[i - 1][blue]);
            cost[i][blue] += Math.min(cost[i - 1][red], cost[i - 1][green]);
        }

        System.out.println(Math.min(Math.min(cost[n - 1][red], cost[n - 1][green]), cost[n - 1][blue]));
    }
}