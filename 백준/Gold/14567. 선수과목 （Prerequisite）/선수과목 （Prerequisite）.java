import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N+1];
        List<Integer>[] arr = new List[N+1];
        for (int i = 1; i < N+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[B].add(A);
        }

        int a;
        for (int i = 1; i < N+1; i++) {
            a = 1;
            for (int j = 0; j < arr[i].size(); j++) {
                a = Math.max(a, dp[arr[i].get(j)]+1);
            }
            dp[i] = a;
        }

        for (int i = 1; i < N+1; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}