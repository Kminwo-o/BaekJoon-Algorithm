import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {	
	static int N;
	static int[][] arr;
	static long[][] visited;
	
	public static long dfs(int x, int y) {
		if (x == N-1 && y == N-1) {
			return 1;
		} else if (visited[x][y] != -1) {
			return visited[x][y];
		}

		visited[x][y] = 0;
		
		int nx = x + arr[x][y];
		int ny = y + arr[x][y];
		if (nx > N-1 && ny > N-1) {
			return 0;
		}
		if (nx <= N-1) {
			visited[x][y] += dfs(nx, y);
		}
		if (ny <= N-1) {
			visited[x][y] += dfs(x, ny);	
		}
		return visited[x][y];
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(dfs(0,0));
	}
}