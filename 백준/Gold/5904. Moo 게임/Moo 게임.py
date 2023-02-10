N = int(input())

# moo
moo = 'moo'
moo_lst = []
# dp[0] = 3글자
moo_lst.append(3)
for i in range(1, N+1):
    # N만큼 dp[i] 만들어 주기
    # dp[0] 생성, append
    moo_lst.append(0)
    moo_lst[i] = moo_lst[i-1] * 2 + i + 3
    # N만큼만 뽑으면 되기 때문에 moo 수열의 길이가 N 이상이면 끊어주기
    if moo_lst[i] >= N:
        break

# idx 위치 조정
n = N - 1

while True:
    # moo_lst[0] 이라는 의미
    if i == 0:
        print(moo[n])
        break
    # N이 moo_lst[i]수열의 가운데 부분보다 크면, 수열만큼 빼주고 뒷부분으로 계산
    if n >= moo_lst[i-1] + i + 3:
        n -= (moo_lst[i-1] + i + 3)
        i -= 1
    # N이 가운데 부분에 있다면, 시작하는 순간이 아니면 'o'이기 때문에 같은 경우에만 'm'
    elif n >= moo_lst[i-1]:
        if n == moo_lst[i-1]:
            print('m')
        else:
            print('o')
        break
    # N이 가운데 수열보다 앞 부분에 있다면, 현재 수열에서 볼 이유가 없으므로 수열 한단계 낮추기
    else:
        i -= 1