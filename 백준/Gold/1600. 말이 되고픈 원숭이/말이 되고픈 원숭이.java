import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class POINT
{
    int x,y,depth,K;
    POINT(int x,int y,int depth, int K)
    {
        this.x=x;
        this.y=y;
        this.depth=depth;
        this.K=K;		//  말처럼 움직인 횟수
    }
}
public class Main {

    static int K;
    static int W;
    static int H;
    static int map[][];
    static boolean isvisisted[][][];		// 세로 가로 말로이동한횟수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K= Integer.parseInt(br.readLine()); 	// K번 말처럼 이동가능

        StringTokenizer st = new StringTokenizer(br.readLine());

        W= Integer.parseInt(st.nextToken()); // 가로
        H=Integer.parseInt(st.nextToken());	// 세로

        /**
         * 주의 해야할점: 0은 평지 1은 장애물
         */
        map=new int[H][W];
        isvisisted=new boolean[H][W][31];

        for(int i=0; i<H; i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<W; j++)
                map[i][j]=Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());

        br.close();

    }

    public static int bfs()
    {
        int horse_x[]={-2,-1,1,2, 2, 1,-2,-1};
        int horse_y[]={ 1, 2,2,1,-1,-2,-1,-2};
        int x[]= {1,0,-1,0};
        int y[]= {0,1,0,-1};
        // 앞 8개 말움직임, 뒤에 4개 원숭이움직임

        // (0,0) 에서 (W-1,H-1)

        Queue<POINT> q=new LinkedList<>();

        isvisisted[0][0][0]=true;
        q.offer(new POINT(0,0,0,0));


        while(!q.isEmpty())
        {
            POINT p=q.poll();

            if(p.x==W-1 && p.y==H-1)
            {
                return p.depth;
            }
            if(p.K<K)
            {
                for(int i=0; i<8; i++)
                {
                    int p_x=p.x+horse_x[i];
                    int p_y=p.y+horse_y[i];
                    // 말움직임

                    if(p_x>=0 && p_x<W && p_y>=0 && p_y<H && map[p_y][p_x]==0 && isvisisted[p_y][p_x][p.K+1]==false)
                    {
                        isvisisted[p_y][p_x][p.K+1]=true;
                        q.offer(new POINT(p_x,p_y,p.depth+1,p.K+1));
                    }
                }
            }
            if(p.K<=K)
            {
                for(int i=0; i<4; i++)
                {
                    int p_x=p.x+x[i];
                    int p_y=p.y+y[i];
                    if(p_x>=0 && p_x<W && p_y>=0 && p_y<H && map[p_y][p_x]==0 && isvisisted[p_y][p_x][p.K]==false)
                    {
                        isvisisted[p_y][p_x][p.K]=true;
                        q.offer(new POINT(p_x,p_y,p.depth+1,p.K));
                    }
                }
            }
        }


        return -1;

    }
}
