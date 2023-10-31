import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int T, N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        long[] answer = new long[T];
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long total = 0;
            long now = arr[N-1];

            for (int j = N-2; j >= 0; j--) {
                if (now >= arr[j]) {
                    total += now - arr[j];
                } else {
                    now = arr[j];
                }
            }

            answer[i] = total;
        }
        for (long ans : answer) {
            System.out.println(ans);
        }
    }
}