import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> inCar = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            inCar.put(br.readLine(), i);
        }

        int[] outCar = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            outCar[i] = inCar.get(br.readLine());
        }

        int cnt = 0;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N+1; j++) {
                if (outCar[i] > outCar[j]) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}