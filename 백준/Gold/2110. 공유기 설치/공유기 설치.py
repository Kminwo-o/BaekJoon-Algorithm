import sys
input = sys.stdin.readline

def wifi_install(left, right):
    global ans
    while left <= right:    
        mid = (left + right) // 2
        now = house[0]
        cnt = 1

        for i in range(1, len(house)):
            if house[i] >= now + mid:
                cnt += 1
                now = house[i]
            
        if cnt >= C:
            ans = mid
            left = mid + 1
        else:
            right = mid - 1
        

N,C = map(int, input().split())

house = [int(input()) for _ in range(N)]
house.sort()

left = 1
right = house[-1] - house[0]
ans = 0

wifi_install(left, right)
print(ans)