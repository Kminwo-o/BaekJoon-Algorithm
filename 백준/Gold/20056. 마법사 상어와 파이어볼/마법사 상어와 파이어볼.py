import sys
input = sys.stdin.readline

def fireball_move():
    for r, c, m, s, d in fireball_lst:
        nr = (r + (direc[d][0] * s)) % N
        nc = (c + (direc[d][1] * s)) % N

        arr[nr][nc].append([m, s, d])


def fireball_divide():
    global fireball_lst
    fireball_lst = []
    for i in range(N):
        if K == 1 and i == 6:
            pass
        for j in range(N):
            cnt = len(arr[i][j])
            if cnt >= 2:
                odd = 0
                even = 0
                total_m = 0
                total_s = 0
                for mm, ss, dd in arr[i][j]:
                    total_m += mm
                    total_s += ss
                    if dd % 2 == 0:
                        even += 1
                    else:
                        odd += 1

                total_m = total_m // 5
                if total_m == 0:
                    continue
                total_s = total_s // cnt

                if (even > 0 and odd == 0) or (odd > 0 and even == 0):
                    for k in range(0,7,2):
                        fireball_lst.append((i, j, total_m, total_s, k))
                else:
                    for k in range(1,8,2):
                        fireball_lst.append((i, j, total_m, total_s, k))
            elif cnt == 1:
                fireball_lst.append((i, j, arr[i][j][0][0], arr[i][j][0][1], arr[i][j][0][2]))

N, M, K = map(int, input().split())
direc = [(-1, 0), (-1, 1), (0, 1), (1, 1),
         (1, 0), (1, -1), (0, -1), (-1, -1)]

fireball_lst = []

for _ in range(M):
    r, c, m, s, d = map(int, input().split())
    fireball_lst.append((r - 1, c - 1, m, s, d))

while K != 0:
    arr = [[[] for _ in range(N)] for _ in range(N)]
    fireball_move()
    fireball_divide()
    K -= 1

ans = 0
for fireball in fireball_lst:
    ans += fireball[2]

print(ans)