import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
//     static class Time implements Comparable<Time> {
//         int start;
//         int end;
        
//         public Time (int start, int end) {
//             this.start = start;
//             this.end = end;
//         }
        
//         @Override
//         public int compareTo(Time t) {
//             if (this.start != t.start) {
//                 return this.start - t.start;
//             } else {
//                 return this.end - t.end;
//             }
//         }
//     }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] realBookTime = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            int s = Integer.parseInt(book_time[i][0].replace(":", ""));
            int e = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            e += 10;
            if (e % 100 >= 60) e += 40;
            realBookTime[i][0] = s;
            realBookTime[i][1] = e;            
        }
        
        Arrays.sort(realBookTime, (x,y) -> x[0] - y[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();       
        
        for (int[] time : realBookTime) {
            if (pq.isEmpty()) {
                pq.add(time[1]);
                continue;
            }
            
            int endTime = pq.peek();
            
            if (time[0] >= endTime) {
                pq.poll();
                pq.add(time[1]);
            } else {
                pq.add(time[1]);
            }
        }
        
        answer = pq.size();
        
        return answer;
    }
}