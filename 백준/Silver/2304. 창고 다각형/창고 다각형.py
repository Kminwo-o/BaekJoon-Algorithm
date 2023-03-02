N = int(input())

lst = []
for i in range(N):
    L, H = map(int,input().split())
    lst.append([L,H])

# x축을 기준으로 정렬
lst.sort(key=lambda x: x[0])
 
# 가장 높은 기둥의 면적을 구하고 미리 더해주기
value = 0
for i in range(len(lst)) :
    if lst[i][1] > value :
        value = lst[i][1]
        idx = i

# 처음 높이는 첫번째 기둥의 높이 
high = lst[0][1]

# 가장 높은 기둥 전까지 돌면서 면적을 추가해주기 
# value에 면적을 계산해서 더해주고 높이를 다음 기둥으로 갱신
for i in range(idx) :
    if high < lst[i+1][1] :
        value += high * (lst[i+1][0]-lst[i][0])
        high = lst[i+1][1]
    # 높이가 낮다면 이전 높이를 그대로하고 현재 면적을 더하기
    else :
        value += high * (lst[i+1][0] - lst[i][0])

# 뒤에서도 가장 큰 기둥까지 면적을 추가
high = lst[-1][1]

for i in range(N-1, idx, -1) :
    if high < lst[i-1][1] :
        value += high * (lst[i][0]-lst[i-1][0])
        high = lst[i-1][1]
    else :
        value += high * (lst[i][0] - lst[i-1][0])

print(value)