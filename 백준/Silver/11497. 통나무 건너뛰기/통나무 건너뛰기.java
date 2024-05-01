import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int t, n;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int left = 0;
            int right = n-1;
            int[] newArr = new int[n];

            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    newArr[left] = arr[j];
                    left++;
                } else {
                    newArr[right] = arr[j];
                    right--;
                }
            }

            int answer = newArr[n-1] - newArr[0];
            for (int j = 1; j < n; j++) {
                answer = Math.max(answer, Math.abs(newArr[j - 1] - newArr[j]));
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}