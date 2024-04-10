import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t, n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);

            int[] tree = new int[n];
            int leftIdx = 0;
            int rightIdx = n - 1;
            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    tree[leftIdx] = arr[j];
                    leftIdx++;
                } else {
                    tree[rightIdx] = arr[j];
                    rightIdx--;
                }
            }

            int ans = Math.abs(tree[0] - tree[n-1]);
            for (int j = 1; j < n; j++) {
                ans = Math.max(ans, Math.abs(tree[j-1] - tree[j]));
            }

            System.out.println(ans);
        }
    }
}