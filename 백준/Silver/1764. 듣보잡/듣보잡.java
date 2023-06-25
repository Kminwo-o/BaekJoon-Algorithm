import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        List<String> not_listen_look = new ArrayList<>();
        // list의 contains는 O(n)이지만 set의 contains는 O(1)입니다.
        for (int i = 0; i < M; i++) {
            String not = br.readLine();
            if (set.contains(not)) {
                not_listen_look.add(not);
            }
        }

        Collections.sort(not_listen_look);

        System.out.println(not_listen_look.size());
        for (int i = 0; i < not_listen_look.size(); i++) {
            System.out.println(not_listen_look.get(i));
        }
    }
}