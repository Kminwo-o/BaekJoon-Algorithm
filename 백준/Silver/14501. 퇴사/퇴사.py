import sys
input = sys.stdin.readline

N = int(input())
# dp 목록 생성
time = [0]
pay = [0]
total_pay = [0 for _ in range(21)]

# 추가
for i in range(N):
    t, p = map(int, input().split())
    time.append(t)
    pay.append(p)

for i in range(1, N+1):
    j = time[i] - 1
    total_pay[i] = max(total_pay[i-1], total_pay[i])
    total_pay[i + (time[i]-1)] = max(total_pay[i-1] + pay[i],total_pay[i + (time[i]-1)])
    
print(total_pay[N])