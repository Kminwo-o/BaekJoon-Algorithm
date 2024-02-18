import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
    static int L, P, V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int Case = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            sb.setLength(0);

            int answer = 0;
            answer += (V / P) * L;
            answer += Math.min(L, V % P);

            sb.append("Case ").append(Case).append(": ").append(answer);
            System.out.println(sb);
            Case++;
        }
    }
}