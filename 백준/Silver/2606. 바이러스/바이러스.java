import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    static int N, E;
    static boolean[] visited;
    static List[] arr;

    public static void dfs(int now) {
        for (int i = 0; i < arr[now].size(); i++) {
            if (visited[(int) arr[now].get(i)]) {
                continue;
            }

            visited[(int) arr[now].get(i)] = true;
            dfs((int) arr[now].get(i));
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        arr = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        visited = new boolean[N+1];

        StringTokenizer st;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }
        dfs(1);

        int answer = 0;
        for (int i = 1; i < N+1; i++) {
            if (visited[i]) {
                answer ++;
            }
        }
        if (N == 1) {
            System.out.println(0);
        } else {
            System.out.println(answer-1);
        }

    }
}