import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[n+1];
        int index = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (answer[index] < num) {
                answer[++index] = num;
            } else {
                int lowerbound = BinarySearch(num, answer, index);
                answer[lowerbound] = num;
            }
        }
        System.out.println(index);
    }

    static int BinarySearch(int num, int[] answer, int size) {
        int left = 0;
        int right = size;

        while (left < right) {
            int mid = (left + right) / 2;
            if (answer[mid] < num) {
                left = mid + 1;

            } else {
                right = mid;
            }
        }

        return left;
    }
}