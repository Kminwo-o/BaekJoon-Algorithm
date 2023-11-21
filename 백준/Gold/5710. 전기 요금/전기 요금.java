import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int A, B;
    public static int getTotalWh(int totalUse) {
        int[] used = {100 * 2, 100 * 2 + 9900 * 3, 100 * 2 + 9900 * 3 + 990000 * 5};

        if (totalUse <= used[0]) {
            return totalUse / 2;
        }
        if (totalUse <= used[1]) {
            return (totalUse - used[0]) / 3 + 100;
        }
        if (totalUse <= used[2]) {
            return (totalUse - used[1]) / 5 + 10000;
        }

        return (totalUse - used[2]) / 7 + 1000000;
    }

    public static int getUsedPay(int useWh) {
        int[] wh = {100, 10000, 1000000};

        if (useWh <= wh[0]) {
            return useWh * 2;
        }
        if (useWh <= wh[1]) {
            return (useWh - 100) * 3 + 100 * 2;
        }
        if (useWh <= wh[2]) {
            return (useWh - 10000) * 5 + 9900 * 3 + 100 * 2;
        }

        return 100 * 2 + 9900 * 3 + 990000 * 5 + (useWh - 1000000) * 7;
    }

    public static int binarySearch(int s, int e, int gap) {
        int totalWh = e;

        while (true) {
            int SangGun = (s+e) / 2;
            int neighbor = totalWh - SangGun;

            int diffPay = getUsedPay(neighbor) - getUsedPay(SangGun);

            if (diffPay == gap) {
                return getUsedPay(SangGun);
            }

            if (diffPay > gap) {
                s = SangGun + 1;
            } else {
                e = SangGun - 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) break;

            int totalWh = getTotalWh(A);

            System.out.println(binarySearch(0, totalWh, B));
        }

    }
}