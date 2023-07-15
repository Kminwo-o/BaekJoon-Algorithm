import java.util.*;
import java.io.*;

public class Main {
    static int N, W, T, K; 
    static int map[];      
    static int wood[];    
    static int process[];  
    static int temp[];    
    static int cur = -1;   
    static int ans = 0;   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        W = Integer.parseInt(st.nextToken())+1;
        T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        wood = new int[T + 1]; 
        map = new int[N + 1];
        process = new int[N + 1];
        temp = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        wood[0] = W;
        site(1);
        System.out.println(ans);
    }
    public static void down(int time) {
        int size = 3;
        for (int i = 1; i <= N; i++) {
            temp[i] = process[i];
        }

        for (int i = 1; i <= N; i++) {
            size = 3;
            if (cur == i) {
                continue;
            }

            if (i > 1 && i < N) {
                if (process[i - 1] > 0) {
                    size -= 1;
                }
                if (process[i + 1] > 0) {
                    size -= 1;
                }
            } else if (i == N) {
                if (process[i - 1] > 0) {
                    size -= 1;
                }
            } else if (i == 1) {
                if (process[i + 1] > 0) {
                    size -= 1;
                }
            }
            temp[i] -= size;
        }

        cur = wood[time];

        for (int i = 1; i <= N; i++) {
            process[i] = temp[i];
        }
    }
    public static void site(int time) {
        if (time == T) {
            if (!check()) {
                return;
            }

            for (int i = 1; i <= N; i++) {
                process[i] = map[i];
            }
            
            cur = -1; // 

            for (int i = 1; i <= T; i++) {
                down(i);
            }
            
            if (min()) {
                ans++;
            }

            return;
        }

        for (int i = 1; i <= N; i++) {
            wood[time] = i;
            site(time + 1);
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

    public static boolean min() {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (process[i] > 0) {
                count++;
            }
        }
        
        if (count < K) {
            return false;
        }

        return true;
    }
}
