import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, W, T, K;
    static int[] wood;
    static int[] fire;
    static int[] temp;
    static int[] process;
    static int new_wood;
    static int ans = 0;
    public static void fire_minus (int time) {
        for (int i = 1; i <= N; i++) {
            temp[i] = process[i];
        }

        for (int i = 1; i <= N; i++) {
            int down = 3;
            if (new_wood == i) continue;
            if (i > 1 && i < N) {
                if (process[i + 1] > 0) down--;
                if (process[i - 1] > 0) down--;
            } else if (i == N) {
                if (process[i - 1] > 0) down--;
            } else {
                if (process[i + 1] > 0) down--;
            }
            temp[i] -= down;
        }

        new_wood = wood[time];

        for (int i = 1; i <= N; i++) {
            process[i] = temp[i];
        }
    }

    public static void dfs (int time) {
        if (time == T) {
            if (!check()) {
                return;
            }

            for (int i = 1; i <= N; i++) {
                process[i] = fire[i];
            }
            new_wood = -1;

            for (int i = 1; i <= T; i++) {
                fire_minus(i);
            }

            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (process[i] > 0) {
                    cnt++;
                }
            }
            if (cnt >= K) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            wood[time] = i;
            dfs(time+1);
            wood[time] = 0;
        }
    }

    public static boolean check() {
        for (int i = 1; i < T; i++) {
            if (Math.abs(wood[i] - wood[i - 1]) > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken())+1;
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        fire = new int[N+1];
        temp = new int[N+1];
        process = new int[N+1];
        wood = new int[T+1];


        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            fire[i] = Integer.parseInt(st.nextToken());
        }

        wood[0] = W;
        dfs(1);
        System.out.println(ans);
    }
}