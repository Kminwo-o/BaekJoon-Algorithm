import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        boolean[] broken = new boolean[10];
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if(broken[str.charAt(j) - '0']) {
                    isBreak = true;
                    break;
                }
            }
            if (!isBreak) {
                int min = Math.abs(N - i) + len; // +- 횟수 + 채널 길이만큼 버튼 눌러야함
                ans = Math.min(min, ans);
            }
        }
        System.out.println(ans);
    }
}