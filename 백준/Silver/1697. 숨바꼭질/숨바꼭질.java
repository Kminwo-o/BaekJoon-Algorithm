import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N;
	static int K;
	static int[] visited = new int[100001];
	static Queue<Integer> queue = new LinkedList<>();
	
	public static int bfs() {
		int now;
		while (!queue.isEmpty()) {
			now = queue.remove();
			
			if (now == K) {
				return visited[now]-1;
			}
			if (now-1>=0 && visited[now-1] == 0)
			{
				visited[now-1] = visited[now]+1;
				queue.add(now-1);
			}
			if (now+1 <= 100000 && visited[now+1] == 0)
			{
				visited[now+1] = visited[now]+1;
				queue.add(now+1);
			}
			if (2*now <= 100000 && visited[2*now] == 0)
			{
				visited[2*now] = visited[now] + 1;
				queue.add(2*now);
			}
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		queue.add(N);
		visited[N] = 1;
		int result = bfs();
		
		System.out.println(result);
		}
		
}