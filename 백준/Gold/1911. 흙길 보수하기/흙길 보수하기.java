import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr, (s1, s2) -> Long.compare(s1[0], s2[0]));

        int answer = 0;
        int dL = 0;
        for (int i = 0; i < N; i++) {
            if (dL > arr[i][1]) {
                continue;
            }

            if (dL < arr[i][0]) {
                dL = arr[i][0];
            }

            answer += (arr[i][1] - dL) / L;
            int remain = (arr[i][1] - dL) % L;
            dL = arr[i][1];

            if (remain != 0) {
                answer++;
                dL += L - remain;
            }
        }

        System.out.println(answer);
    }
}