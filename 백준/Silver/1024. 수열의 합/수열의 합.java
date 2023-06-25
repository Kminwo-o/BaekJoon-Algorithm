import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long N, L;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        boolean flag = false;

        while (L <= 100) {
            long start = N / L - (L - 1) / 2;
            if (start < 0) break;
            if (N == (start * 2 + L - 1) * L / 2) {
                for (long i = 0; i < L; i++) {
                    sb.append(start+i).append(" ");
                }
                flag = true;
                break;
            }
            L++;
        }
        if (flag) System.out.println(sb);
        else System.out.println(-1);
    }
}