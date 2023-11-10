import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int alkali = 0;
        int acid = 0;


        int start = 0;
        int end = N-1;
        int sum = Integer.MAX_VALUE;
        int tmp = 0;
        int ans = 0;
        while (start < end && arr[start] + arr[end] != 0) {
            ans = arr[start] + arr[end];
            tmp = Math.abs(ans);

            if (tmp < sum) {
                sum = tmp;
                acid = arr[start];
                alkali = arr[end];
            }

            if (ans > 0) {
                end--;
            } else {
                start++;
            }
        }

        if (arr[start] + arr[end] == 0) {
            System.out.println(arr[start] + " " + arr[end]);
        } else {
            System.out.println(acid + " " + alkali);
        }

    }
}
