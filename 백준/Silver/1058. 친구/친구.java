import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main{

    static int N;
    static char[][] arr;
    static boolean[] visited;
    static int cnt;

    public static int bfs(int now, int depth) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(now);
        visited[now] = true;

        while (depth < 2){
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                int man = queue.poll();

                for (int j = 0; j < N; j++) {
                    if (arr[man][j] == 'Y' && !visited[j]) {
                        visited[j] = true;
                        cnt++;
                        queue.add(j);
                    }
                }
            }
            depth++;
        }

        return cnt;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                arr[i][j] = input[j];
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            cnt = 0;
            answer = Math.max(answer, bfs(i, 0));
        }

        System.out.println(answer);
    }
}