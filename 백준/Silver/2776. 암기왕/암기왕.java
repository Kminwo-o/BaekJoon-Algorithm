import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] note1 = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (Arrays.binarySearch(note1, Integer.parseInt(st.nextToken())) >= 0 ) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }

        }
        System.out.println(sb);
    }
}