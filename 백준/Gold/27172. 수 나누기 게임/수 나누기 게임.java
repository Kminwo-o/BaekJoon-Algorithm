import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] card_list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int max = 0;
        card_list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card_list[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, card_list[i]);
        }

        int[] ans = new int[N+1];
        int[] pos = new int[max+1];
        
        for (int i = 0; i < N; i++) {
            pos[card_list[i]] = i + 1;
        }

        for (int mod: card_list) {
            for (int i = mod*2; i <= max; i += mod) {
                if(pos[i] != 0) {
                    ans[pos[i]]--;
                    ans[pos[mod]]++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}