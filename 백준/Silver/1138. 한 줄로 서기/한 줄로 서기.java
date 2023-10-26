import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] taller = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        taller[arr[0]] = 1;
        for (int i = 1; i < N; i++) {
            int check = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i] == check) {
                    if(taller[j] != 0) {
                        continue;
                    }
                    taller[j] = i+1;
                    break;
                }

                if (taller[j] == 0) {
                    check++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(taller[i] + " ");
        }
    }
}