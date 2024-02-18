import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] country = new int[n+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int world = Integer.parseInt(st.nextToken());
            // 금
            country[world] += Integer.parseInt(st.nextToken()) * 3;
            // 은
            country[world] += Integer.parseInt(st.nextToken()) * 2;
            // 동
            country[world] += Integer.parseInt(st.nextToken());
        }

        int score = country[k];
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            if (country[i] > score) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}