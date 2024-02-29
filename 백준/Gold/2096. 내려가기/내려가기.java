import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  static int n, maxValue, minValue;
  static int[][] arr, maxDp, minDp;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    n = Integer.parseInt(br.readLine());
    arr = new int[n][3];
    maxDp = new int[n + 1][3];
    minDp = new int[n + 1][3];

    maxValue = -1;
    minValue = 1000000;
    
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= n; i++) {
      maxDp[i][0] = Math.max(maxDp[i-1][0], maxDp[i-1][1]) + arr[i-1][0];
      maxDp[i][1] = Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]) + arr[i-1][1];
      maxDp[i][2] = Math.max(maxDp[i-1][1], maxDp[i-1][2]) + arr[i-1][2];

      minDp[i][0] = Math.min(minDp[i-1][0], minDp[i-1][1]) + arr[i-1][0];
      minDp[i][1] = Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]) + arr[i-1][1];
      minDp[i][2] = Math.min(minDp[i-1][1], minDp[i-1][2]) + arr[i-1][2];
    }

    for (int i = 0; i < 3; i++) {
      maxValue = Math.max(maxValue, maxDp[n][i]);
      minValue = Math.min(minValue, minDp[n][i]);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(maxValue).append(" ").append(minValue);

    System.out.print(sb.toString());
  }
}