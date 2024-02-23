import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
  static int n;
  static int[] arr;
  static boolean[] visited;
  static ArrayList<Integer> numbers = new ArrayList<Integer>();
  public static void dfs (int start, int end) {
    if (arr[start] == end) {
      numbers.add(end);
    }

    if (!visited[arr[start]]) {
      visited[arr[start]] = true;
      dfs(arr[start], end);
      visited[arr[start]] = false;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());

    arr = new int[n+1];
    visited = new boolean[n+1];
    
    for(int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    for (int i = 1; i <= n; i++) {
      visited[i] = true;
      dfs(i, i);
      visited[i] = false;
    }

    System.out.println(numbers.size());
    Collections.sort(numbers);
    for (int i = 0; i < numbers.size(); i++) {
      System.out.println(numbers.get(i));
    }
  }
}