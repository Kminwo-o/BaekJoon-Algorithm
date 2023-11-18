import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w, l;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        int[] truck = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int time = 0;
        int weight = 0;
        int nowTruck = 0;
        while (!bridge.isEmpty()) {
            weight -= bridge.poll();
            time++;

            if (weight+truck[nowTruck] > l) {
                bridge.add(0);
                continue;
            }

            if (nowTruck < n) {
                weight += truck[nowTruck];
                bridge.add(truck[nowTruck]);
                nowTruck++;
            }
        }

        System.out.println(time);
    }
}