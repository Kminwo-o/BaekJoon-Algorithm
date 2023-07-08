import java.io.*;
import java.util.*;

public class Main {
    static int N,a,b,c,ans;
    static class Node {
        int num, len;
        public Node (int num, int len) {
            this.num = num;
            this.len = len;
        }
    }
    static List<Node>[] list;
    static boolean[] visited;
    public static void dfs (int num, int dim) {
        for (Node node: list[num]) {
            if (!visited[node.num]) {
                visited[node.num] = true;
                dfs(node.num, dim + node.len);
            }
        }
        ans = (ans < dim)? dim : ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // List형태도 []로 쓰면 배정이 가능
        list = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        ans = 0;
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }
        System.out.println(ans);
    }
}