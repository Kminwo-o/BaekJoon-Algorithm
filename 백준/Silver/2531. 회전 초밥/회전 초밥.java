import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N, d, k, c;
    static int[] arr;
    static int[] sushi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken())-1;

        arr = new int[N];
        sushi = new int[d];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }

        int eat_sushi = 0;
        for (int i = 0; i < k; i++) {
            if (sushi[arr[i]] == 0) {
                eat_sushi++;
            }
            sushi[arr[i]]++;
        }

        int answer = eat_sushi;
        for (int i = 0; i < N; i++) {
            if (answer <= eat_sushi) {
                if (sushi[c] == 0) {
                    answer = eat_sushi + 1;
                } else {
                    answer = eat_sushi;
                }
            }

            int end = (i + k) % N;

            if(sushi[arr[end]] == 0) {
                eat_sushi++;
            }

            sushi[arr[end]]++;
            sushi[arr[i]]--;

            if (sushi[arr[i]] == 0) {
                eat_sushi--;
            }
        }

        System.out.println(answer);
    }
}