import sys
input = sys.stdin.readline

N, M = map(int,input().split())

arr = [list(map(int,input().strip().split())) for _ in range(N)]

# 모든 도형을 고려하여 순회
tetro_brute = (((0,0),(0,1),(0,2),(0,3)),((0,0),(1,0),(2,0),(3,0)),((0,0),(0,1),(1,0),(1,1)),((0,0),(1,0),(2,0),(2,1)),
            ((0,0),(1,0),(2,0),(2,-1)),((0,0),(0,1),(1,1),(2,1)),((0,0),(0,1),(1,0),(2,0)),((0,0),(-1,0),(0,1),(0,2)),
            ((0,0),(1,0),(0,1),(0,2)),((0,0),(0,1),(0,2),(-1,2)),((0,0),(0,1),(0,2),(1,2)),((0,0),(1,0),(1,1),(2,1)),
            ((0,0),(1,0),(1,-1),(2,-1)),((0,0),(0,1),(-1,1),(-1,2)),((0,0),(0,1),(1,1),(1,2)),((0,0),(0,-1),(1,0),(0,1)),
            ((0,0),(-1,0),(1,0),(0,1)),((0,0),(0,-1),(-1,0),(0,1)),((0,0),(0,-1),(1,0),(-1,0)))

_max = 0
for i in range(N) :
    for j in range(M) :
        for tetromino in tetro_brute :
            tmp = 0
            for di, dj in tetromino :
                ni, nj = i + di, j + dj
                if 0 > ni or ni >= N or 0 > nj or nj >= M :
                    continue
                tmp += arr[ni][nj]
            _max = max(_max,tmp)
print(_max)