import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static class Node {
		private int index;
		private int value;
		
		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	static int BFS(int k, int v, ArrayList<Node>[] lst, int N) {
		int cnt = 0;
		boolean[] visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		visited[v] = true;
		queue.add(v);
		
		while (!queue.isEmpty()) {
			int num = queue.poll();
			
			for (int i = 0; i < lst[num].size(); i++) {
				int value = lst[num].get(i).value;
				int node = lst[num].get(i).index;
				
				if (value >= k && !visited[node]) {
					queue.add(node);
					visited[node] = true;
					cnt++;
				}
			}
		}
		
		return cnt;
	}

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        ArrayList<Node>[] lst = new ArrayList[N+1];
        
        for (int i = 1; i <= N; i++) {
			lst[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			lst[p].add(new Node(q, r));
			lst[q].add(new Node(p, r));
		}
        
        for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			int ans = BFS(K, V, lst, N);
			System.out.println(ans);
		}
    }
}