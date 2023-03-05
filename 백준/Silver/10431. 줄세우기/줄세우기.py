P = int(input())

for tc in range(P):
    lst = list(map(int, input().split()))
    ans = 0
    cnt = 1

    while cnt != 0:
        cnt = 0
        for i in range(1,len(lst)-1):
            if lst[i] > lst[i+1]:
                lst[i], lst[i+1] = lst[i+1], lst[i]
                cnt += 1
        else:
            ans += cnt
    
    print(lst[0], ans)